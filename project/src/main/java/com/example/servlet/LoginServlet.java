package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.daoimplementation.UserDaoImplementation;
import com.example.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	int count=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
		
		try {
			User userDetails = userDaoImplementation.getUserDetails(username);
			
			if(userDetails.getUsername().equals(username) && userDetails.getPassword().equals(password))
			{
				HttpSession session = req.getSession();
				session.setAttribute("userId", userDetails.getUserId());
				session.setAttribute("name", userDetails.getName());
				session.setAttribute("username", userDetails.getUsername());
				session.setAttribute("email", userDetails.getEmail());
				session.setAttribute("phoneNumber", userDetails.getPhoneNumber());
				session.setAttribute("address", userDetails.getAddress());
				session.setAttribute("logedIn", userDetails);
				resp.setContentType("text/html");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/afterLogin");
				
				requestDispatcher.forward(req, resp);
			}
			else {
				if(count>1) {
					String message="login failed! please login again";
					HttpSession session = req.getSession();
					session.setAttribute("message", message);
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("/failedServlet");
					requestDispatcher.include(req, resp);
					count=count-1;
				}
				else
				{
					PrintWriter out = resp.getWriter();
					out.println("login falied. Try after some time");
					
				}
			}
			
		}
		catch (NullPointerException e) {
		  e.printStackTrace();
		  PrintWriter out = resp.getWriter();
			out.println("please enter valid details.");
		}
		catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = resp.getWriter();
			out.println("No User found. please enter valid details.");
		}
	}
}
