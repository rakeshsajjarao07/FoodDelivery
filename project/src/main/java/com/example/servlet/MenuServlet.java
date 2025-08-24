package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.daoimplementation.MenuDaoImplementation;
import com.example.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try
		{
			int resturantId = Integer.parseInt(req.getParameter("resturantId"));
			HttpSession session = req.getSession();
			session.setAttribute("resturantId", resturantId);
//			System.out.println(resturantId);
			
			//to interact with the database. all the methods present in this class 
			 MenuDaoImplementation menuDaoImplementation = new MenuDaoImplementation();
			 
			 //all the menu items present in the particular resturant
			 List<Menu> menuByResturantId = menuDaoImplementation.getMenuByResturantId(resturantId);
			 
			 req.setAttribute("allmenu", menuByResturantId);
			 
			 //control goes to the menu.jsp file
			 RequestDispatcher requestDispatcher = req.getRequestDispatcher("menu.jsp");
			 requestDispatcher.forward(req, resp);
		}
		catch (Exception e) {

			e.printStackTrace();
		}
		
	}

}
