package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.UserDao;
import jdbc.DBContext;
import model.Category;
import model.Product;
import model.User;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

public class ProductDaoImpl extends DBContext implements ProductDao {

    CategoryService categortService = new CategoryServiceImpl();

    @Override
    public void edit(Product product) {
        String sql = "UPDATE Product SET Product.name = ? , price = ?, image = ?,cate_id=?, des=?  WHERE id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getImage());
            statement.setInt(4, product.getCategory().getId());
            statement.setString(5, product.getDes());
            statement.setInt(6, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Product product) {
        String sql = "INSERT INTO Product(name, price, image, cate_id, des, quantity) VALUES (?,?,?,?,?,?)";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setLong(2, product.getPrice());
            statement.setString(3, product.getImage());
            statement.setInt(4, product.getCategory().getId());
            statement.setString(5, product.getDes());
            statement.setInt(6, product.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Product WHERE id=?";
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
    public List<Product> getAll() {

        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id, quantity  "
                + "FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM user WHERE name LIKE ? ";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));

                Category category = new Category();
                category.setId(rs.getInt("c_id"));
                category.setName(rs.getString("c_name"));

                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> seachByCategory(int cate_id) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id , quantity"
                + "	 FROM Product , Category   where product.cate_id = category.cate_id and Category.cate_id=?";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cate_id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> seachByName(String productName) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id, quantity				"
                + " FROM Product , Category   where product.cate_id = category.cate_id and Product.name like ? ";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + productName + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product get(int id) {
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image,product.des, category.cate_name AS c_name, category.cate_id AS c_id, quantity "
                + "FROM product INNER JOIN category " + "ON product.cate_id = category.cate_id WHERE product.id=?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));

                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);

                return product;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> sortByCategory() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id, quantity  \n"
                + "		FROM product INNER JOIN category   ON product.cate_id = category.cate_id order by c_id";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> sortByName() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id, quantity  \n"
                + "FROM product INNER JOIN category   ON product.cate_id = category.cate_id order by p_name";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> sortByPrice() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT product.id, product.name AS p_name, product.price, product.image, product.des , category.cate_name AS c_name, category.cate_id AS c_id , quantity \n"
                + "FROM product INNER JOIN category   ON product.cate_id = category.cate_id order by price";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = categortService.get(rs.getInt("c_id"));
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("p_name"));
                product.setPrice(rs.getLong("price"));
                product.setImage(rs.getString("image"));
                product.setDes(rs.getString("des"));
                product.setCategory(category);
                product.setQuantity(rs.getInt("quantity"));
                product.setCategory(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

}
