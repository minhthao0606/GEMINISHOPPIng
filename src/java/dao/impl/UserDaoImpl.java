package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import jdbc.DBContext;
import model.User;

public class UserDaoImpl extends DBContext implements UserDao {

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [User] WHERE username = ? ";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(Integer.parseInt(rs.getString("role_id")));
                user.setActive(rs.getBoolean("active"));
                return user;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM [User] WHERE id = ?";
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
    public void edit(User user) {
        String sql = "UPDATE [User] SET email = ? , username = ?, password = ?, avatar = ?, role_id = ?, active = ? WHERE id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAvatar());
            statement.setInt(5, user.getRoleId());
            statement.setBoolean(6, user.isActive());
            statement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO [User](email, username, password, avatar, role_id, active) VALUES (?,?,?,?,?,?)";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAvatar());
            statement.setInt(5, user.getRoleId());
            statement.setBoolean(6, true);
            //   System.out.println(user.isActive() + "HEllooo");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM [User]";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(Integer.parseInt(rs.getString("role_id")));
                user.setActive(rs.getBoolean("active"));
                userList.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM [User] WHERE id = ? ";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(Integer.parseInt(rs.getString("role_id")));
                user.setActive(rs.getBoolean("active"));
                return user;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> search(String keyword) {
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM [User] WHERE name LIKE ? ";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleId(Integer.parseInt(rs.getString("role_id")));
                user.setActive(rs.getBoolean("active"));
                userList.add(user);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userList;
    }

    public boolean checkExistUsername(String username) {
        Connection con = super.getConnection();
        try {
            String query = "select * from [User] where username = ?";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }
            statement.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean checkExistEmail(String email) {
        Connection con = super.getConnection();
        try {
            String query = "select * from [user] where email = ?";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
            statement.close();
            con.close();
        } catch (SQLException ex) {
        }
        return false;
    }

    @Override
    public void active(int id) {
        String sql = "update [user]\n"
                + "set active = 1 - active\n"
                + "where id = ?";
        Connection con = super.getConnection();

        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
