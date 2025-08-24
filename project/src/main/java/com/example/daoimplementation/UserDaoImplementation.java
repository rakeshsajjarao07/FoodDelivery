package com.example.daoimplementation;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.UserDao;
import com.example.model.User;

public class UserDaoImplementation implements UserDao {
    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rakeshyadav@07";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Add new user (Registration)
    @Override
    public void addUser(User user) {
        final String sql = """
            INSERT INTO user
            (name, username, password, email,
             phoneNumber, address, role,
             createDate, lastLoginDate)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getRole());
            stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(9, new Timestamp(System.currentTimeMillis())); // lastLoginDate set to NULL on registration

            int rows = stmt.executeUpdate();
            System.out.println("Inserted " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateLastLoginDate(String username) {
        String sql = "UPDATE user SET lastLoginDate = CURRENT_TIMESTAMP WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ lastLoginDate updated");
            } else {
                System.out.println("⚠️ User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Get user by ID
    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM user WHERE userId = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToUser(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all users
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(mapResultSetToUser(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Update user
    @Override
    public void updateUser(User user) {
        String sql = """
            UPDATE user SET
            name = ?, username = ?, password = ?, email = ?,
            phoneNumber = ?, address = ?, role = ?,
            createDate = ?, lastLoginDate = ?
            WHERE userId = ?
            """;

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhoneNumber());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getRole());

            stmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
            stmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
            stmt.setInt(10, user.getUserId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete user
    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM user WHERE userId = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to User object
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phoneNumber"));
        user.setAddress(rs.getString("address"));
        user.setRole(rs.getString("role"));
        user.setCreateDate(rs.getTimestamp("createDate"));
        user.setLastLoginDate(rs.getTimestamp("lastLoginDate"));
        return user;
    }
    
    @Override
    public User getUserDetails(String username) {
    	String sql="SELECT * FROM user WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setString(1, username);
               try (ResultSet rs = stmt.executeQuery()) {
                   if (rs.next()) {
                       return mapResultSetToUser(rs);
                   }
               }

           } catch (SQLException e) {
               e.printStackTrace();
           }
           return null;
    	
    }
}
