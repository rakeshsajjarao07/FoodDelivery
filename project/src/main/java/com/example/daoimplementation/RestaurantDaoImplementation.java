package com.example.daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dao.RestaurantDao;
import com.example.model.Restaurant;

public class RestaurantDaoImplementation implements RestaurantDao {
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

    
    // Add Restaurant
    @Override
    public void addRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO Restaurant (name, address, phoneNumber, cuisineType, deliveryTime, adminUserId, rating, isActive, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getAddress());
            stmt.setString(3, restaurant.getPhoneNumber());
            stmt.setString(4, restaurant.getCuisineType());
            stmt.setString(5, restaurant.getDeliveryTime());
            stmt.setInt(6, restaurant.getAdminUserId());
            stmt.setString(7, restaurant.getRating());
            stmt.setString(8, restaurant.getIsActive());
            stmt.setString(9, restaurant.getImagePath());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get Restaurant by ID
    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        String sql = "SELECT * FROM Restaurant WHERE restaurantId = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, restaurantId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Restaurant restaurant = new Restaurant();
                    restaurant.setRestaurantId(rs.getInt("restaurantId"));
                    restaurant.setName(rs.getString("name"));
                    restaurant.setAddress(rs.getString("address"));
                    restaurant.setPhoneNumber(rs.getString("phoneNumber"));
                    restaurant.setCuisineType(rs.getString("cuisineType"));
                    restaurant.setDeliveryTime(rs.getString("deliveryTime"));
                    restaurant.setAdminUserId(rs.getInt("adminUserId"));
                    restaurant.setRating(rs.getString("rating"));
                    restaurant.setIsActive(rs.getString("isActive"));
                    restaurant.setImagePath(rs.getString("imagePath"));
                    return restaurant;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get All Restaurants
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM Restaurant";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(rs.getInt("restaurantId"));
                restaurant.setName(rs.getString("name"));
                restaurant.setAddress(rs.getString("address"));
                restaurant.setPhoneNumber(rs.getString("phoneNumber"));
                restaurant.setCuisineType(rs.getString("cuisineType"));
                restaurant.setDeliveryTime(rs.getString("deliveryTime"));
                restaurant.setAdminUserId(rs.getInt("adminUserId"));
                restaurant.setRating(rs.getString("rating"));
                restaurant.setIsActive(rs.getString("isActive"));
                restaurant.setImagePath(rs.getString("imagePath"));
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    // Update Restaurant
    @Override
    public void updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurant SET name=?, address=?, phoneNumber=?, cuisineType=?, deliveryTime=?, adminUserId=?, rating=?, isActive=?, imagePath=? WHERE restaurantId=?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getAddress());
            stmt.setString(3, restaurant.getPhoneNumber());
            stmt.setString(4, restaurant.getCuisineType());
            stmt.setString(5, restaurant.getDeliveryTime());
            stmt.setInt(6, restaurant.getAdminUserId());
            stmt.setString(7, restaurant.getRating());
            stmt.setString(8, restaurant.getIsActive());
            stmt.setString(9, restaurant.getImagePath());
            stmt.setInt(10, restaurant.getRestaurantId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Restaurant
    @Override
    public void deleteRestaurant(int restaurantId) {
        String sql = "DELETE FROM Restaurant WHERE restaurantId = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, restaurantId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
