package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.CartDao;
import dao.CategoryDao;
import dao.ProductDao;
import jdbc.DBContext;
import model.Cart;
import model.Category;
import model.Product;
import model.User;
import service.CategoryService;
import service.UserService;
import service.impl.UserServiceImpl;

public class CartDaoImpl extends DBContext implements CartDao {

    UserService userS = new UserServiceImpl();

    @Override
    public void edit(Cart cart) {
        String sql = "UPDATE cart SET id_user = ?, buyDate = ? WHERE id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, cart.getBuyer().getId());
            statement.setDate(2, new Date(cart.getBuyDate().getTime()));
            statement.setString(3, cart.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Cart cart) {
        String sql = "INSERT INTO Cart(id,u_id, buyDate) VALUES (?,?,?)";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, cart.getId());
            statement.setInt(2, cart.getBuyer().getId());
            statement.setDate(3, new Date(cart.getBuyDate().getTime()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cart get(int id) {
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id WHERE cart.id=?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                return cart;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Cart> getAll() {
        ArrayList<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cart WHERE id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Cart get(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<Cart> search(String name) {
        ArrayList<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id LIKE User.email = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = userS.get(rs.getInt("user_id"));

                Cart cart = new Cart();
                cart.setId(rs.getString("id"));
                cart.setBuyDate(rs.getDate("buyDate"));
                cart.setBuyer(user);

                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartList;
    }
}
