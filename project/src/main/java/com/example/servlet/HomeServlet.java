package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.daoimplementation.RestaurantDaoImplementation;
import com.example.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDaoImplementation restaurantDaoImplementation = new RestaurantDaoImplementation();
		List<Restaurant> allRestaurants = restaurantDaoImplementation.getAllRestaurants();
		req.setAttribute("allRestaurants", allRestaurants);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(req, resp);
		
		
	}

}
