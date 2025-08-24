package com.example.dao;

import java.util.List;

import com.example.model.Restaurant;

public interface RestaurantDao {

	 void addRestaurant(Restaurant restaurant);
	    Restaurant getRestaurantById(int restaurantId);
	    List<Restaurant> getAllRestaurants();
	    void updateRestaurant(Restaurant restaurant);
	    void deleteRestaurant(int restaurantId);
}
