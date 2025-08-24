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
import jakarta.servlet.http.HttpSession;

@WebServlet("/afterLogin")
public class AfterLoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			RestaurantDaoImplementation restaurantDaoImplementation = new RestaurantDaoImplementation();
			//get all the resturants  present in the database
			List<Restaurant> allRestaurants = restaurantDaoImplementation.getAllRestaurants();
			
			//to pass the resturants to the jsp file
			req.setAttribute("allRestaurants", allRestaurants);
			
			//then the control goes to the home page after login
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("after.jsp");
			requestDispatcher.forward(req, resp);

		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
