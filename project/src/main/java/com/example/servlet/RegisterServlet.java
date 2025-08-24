package com.example.servlet;

import java.io.IOException;

import com.example.daoimplementation.UserDaoImplementation;
import com.example.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signupForm")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			String name = req.getParameter("name");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String phonenumber = req.getParameter("phoneNumber");
			String address = req.getParameter("address");
			String role = req.getParameter("role");
			
			User userdetails = new User(name, username, password, email, phonenumber, address, role);
			
			UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
			// To add the user into the database
			userDaoImplementation.addUser(userdetails);
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("username", username);
			session.setAttribute("email", email);
			session.setAttribute("phonenumber", phonenumber);
			session.setAttribute("address", address);
            //after that control goes to the after login servlet directly
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/afterLogin");
			requestDispatcher.forward(req, resp);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
