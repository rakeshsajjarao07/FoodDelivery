package com.example.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.MenuDao;
import com.example.model.Menu;

public class MenuDaoImplementation implements MenuDao {
	
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL = "jdbc:mysql://localhost:3306/project";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rakeshyadav@07";

    @Override
    public void addMenu(Menu menu) {
        String sql = "INSERT INTO Menu (restaurantId, itemName, description, price, isAvailable, ratings, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getItemName());
            stmt.setString(3, menu.getDescription());
            stmt.setDouble(4, menu.getPrice());
            stmt.setInt(5, menu.getIsAvailable());
            stmt.setString(6, menu.getRatings());
            stmt.setString(7, menu.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenuById(int menuId) {
        String sql = "SELECT * FROM Menu WHERE menuId = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, menuId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Menu menu = new Menu();
                    menu.setMenuId(rs.getInt("menuId"));
                    menu.setRestaurantId(rs.getInt("restaurantId"));
                    menu.setItemName(rs.getString("itemName"));
                    menu.setDescription(rs.getString("description"));
                    menu.setPrice(rs.getInt("price"));
                    menu.setIsAvailable(rs.getInt("isAvailable"));
                    menu.setRatings(rs.getString("ratings"));
                    menu.setImagePath(rs.getString("imagePath"));
                    return menu;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM Menu";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setMenuId(rs.getInt("menuId"));
                menu.setRestaurantId(rs.getInt("restaurantId"));
                menu.setItemName(rs.getString("itemName"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getInt("price"));
                menu.setIsAvailable(rs.getInt("isAvailable"));
                menu.setRatings(rs.getString("ratings"));
                menu.setImagePath(rs.getString("imagePath"));
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    @Override
    public void updateMenu(Menu menu) {
        String sql = "UPDATE Menu SET restaurantId=?, itemName=?, description=?, price=?, isAvailable=?, ratings=?, imagePath=? WHERE menuId=?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, menu.getRestaurantId());
            stmt.setString(2, menu.getItemName());
            stmt.setString(3, menu.getDescription());
            stmt.setDouble(4, menu.getPrice());
            stmt.setInt(5, menu.getIsAvailable());
            stmt.setString(6, menu.getRatings());
            stmt.setString(7, menu.getImagePath());
            stmt.setInt(8, menu.getMenuId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId) {
        String sql = "DELETE FROM Menu WHERE menuId = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, menuId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Menu> getMenuByResturantId(int restaurantId) {
        List<Menu> menus = new ArrayList<>();
        
        // Validate input
        if (restaurantId <= 0) {
            throw new IllegalArgumentException("Restaurant ID must be positive");
        }
        
        String sql = "SELECT * FROM menu WHERE restaurantId = ? ORDER BY itemName";
        
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, restaurantId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setMenuId(rs.getInt("menuId"));
                    menu.setRestaurantId(rs.getInt("restaurantId"));
                    menu.setItemName(rs.getString("itemName"));
                    menu.setDescription(rs.getString("description"));
                    menu.setPrice(rs.getInt("price"));
                    menu.setIsAvailable(rs.getInt("isAvailable"));
                    menu.setRatings(rs.getString("ratings"));
                    menu.setImagePath(rs.getString("imagePath"));
                    menus.add(menu);
                }
            }
            
        } catch (SQLException e) {
            // Log the error properly
            System.err.println("Error retrieving menu for restaurant ID: " + restaurantId);
            e.printStackTrace();
            // Optionally re-throw as a custom exception
            throw new RuntimeException("Failed to retrieve menu items", e);
        }
        
        return menus;
    
    }
}
