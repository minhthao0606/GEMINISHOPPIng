package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import jdbc.DBContext;
import model.Category;

public class CategoryDaoImpl extends DBContext implements CategoryDao {

    @Override
    public void edit(Category category) {
        String sql = "UPDATE category SET cate_name = ? WHERE cate_id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM category WHERE cate_id = ?";
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
    public Category get(int id) {
        String sql = "SELECT * FROM category WHERE cate_id = ? ";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("cate_id"));
                category.setName(rs.getString("cate_name"));

                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Category category) {
        String sql = "insert into Category values (?)";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM Category";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("cate_id"));
                category.setName(rs.getString("cate_name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public Category get(String name) {
        String sql = "SELECT * FROM Category WHERE cate_name = ? ";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("cate_id"));
                category.setName(rs.getString("cate_name"));

                return category;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> search(String keyword) {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM category WHERE name LIKE ? ";
        Connection conn = super.getConnection();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
