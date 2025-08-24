package com.example.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/failedServlet")
public class FailedServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		HttpSession session = req.getSession();
		String message =(String)session.getAttribute("message");
		resp.setContentType("text/html");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("signin.jsp");
		requestDispatcher.include(req, resp);
		
	}

}
