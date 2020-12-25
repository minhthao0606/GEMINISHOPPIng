package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import dao.CartDao;
import dao.CartItemDao;
import dao.CategoryDao;
import dao.ProductDao;
import dao.UserDao;
import jdbc.DBContext;

import model.Cart;
import model.CartItem;
import model.Category;
import model.Product;
import model.User;
import service.CartService;
import service.CategoryService;
import service.ProductService;
import service.UserService;
import service.impl.CartServiceImpl;
import service.impl.ProductServiceImpl;

public class CartItemDaoImpl extends DBContext implements CartItemDao {

    CartService cartService = new CartServiceImpl();
    ProductService productService = new ProductServiceImpl();
    UserDao userDao = (UserDao) new UserDaoImpl();

    @Override
    public CartItem get(int id) {
        String sql = "SELECT "
                + "CartItem.id, "
                + "CartItem.quantity, "
                + "CartItem.unitPrice, "
                + "cart.u_id, "
                + "cart.buyDate, "
                + "product.name, "
                + "product.price "
                + "FROM CartItem "
                + "INNER JOIN Cart "
                + "ON CartItem.cart_id = cart.id "
                + "INNER JOIN Product "
                + "ON CartItem.pro_id = Product.id "
                + "WHERE CartItem.id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("u_id"));

                Cart cart = new Cart();
                cart.setBuyer(user);
                cart.setBuyDate(rs.getDate("buyDate"));

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));

                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));

                return cartItem;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void edit(CartItem cartItem) {
        String sql = "UPDATE CartItem SET cat_id = ?, pro_id = ?, quantity = ?, unitPrice=? WHERE id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, cartItem.getCart().getId());
            statement.setInt(2, cartItem.getProduct().getId());
            statement.setInt(3, cartItem.getQuantity());
            statement.setLong(4, cartItem.getUnitPrice());
            statement.setString(5, cartItem.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM CartItem WHERE id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void insert(CartItem cartItem) {
        String sql = "INSERT INTO CartItem(id, cat_id, pro_id, quantity, unitPrice) VALUES (?,?,?,?,?)";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, cartItem.getId());
            statement.setString(2, cartItem.getCart().getId());
            statement.setInt(3, cartItem.getProduct().getId());
            statement.setInt(4, cartItem.getQuantity());
            statement.setLong(5, cartItem.getUnitPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CartItem> getAll() {
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        String sql = "SELECT "
                + "CartItem.id, "
                + "CartItem.quantity, "
                + "CartItem.unitPrice, "
                + "cart.u_id, "
                + "cart.buyDate, "
                + "product.name, "
                + "product.price "
                + "FROM CartItem "
                + "INNER JOIN Cart "
                + "ON CartItem.cat_id = Cart.id "
                + "INNER JOIN Product "
                + "ON CartItem.pro_id = Product.id ";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = userDao.get(rs.getInt("u_id"));

                Cart cart = new Cart();
                cart.setBuyer(user);
                cart.setBuyDate(rs.getDate("buyDate"));

                Product product = new Product();
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));

                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getString("id"));
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setQuantity(rs.getInt("quantity"));
                cartItem.setUnitPrice(rs.getLong("unitPrice"));

                cartItemList.add(cartItem);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cartItemList;
    }

    public List<CartItem> search(String name) {
        return null;
    }

    @Override
    public CartItem get(String name) {
        // TODO Auto-generated method stub
        return null;
    }
}
