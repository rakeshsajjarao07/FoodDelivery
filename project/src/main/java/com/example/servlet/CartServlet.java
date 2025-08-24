package com.example.servlet;

import java.io.IOException;

import com.example.daoimplementation.MenuDaoImplementation;
import com.example.daoimplementation.OrderItemDaoImplementation;
import com.example.model.Cart;
import com.example.model.CartItem;
import com.example.model.Menu;
import com.example.model.OrderItem;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {
			HttpSession session = req.getSession();


			Cart cart = (Cart)session.getAttribute("cart");



			Integer oldResturantId =(Integer) session.getAttribute("resturantID");

			int newResturantId = Integer.parseInt(req.getParameter("resturantId"));


			if(cart == null || oldResturantId != newResturantId)
			{
				cart = new Cart();


				session.setAttribute("cart", cart);
				
				
				
				
				session.setAttribute("resturantID", newResturantId);
			}
			
			
			
			String action = req.getParameter("action");

			if(action.equalsIgnoreCase("add"))
			{
				addItemToCart(req,cart);
			}
			else if(action.equalsIgnoreCase("update"))
			{
				updateCartItem(req,cart);
			}
			else if(action.equalsIgnoreCase("remove"))
			{
				deleteItemFromCart(req, cart);
			}
			else if(action.equalsIgnoreCase("clear"))
			{
				clearAllItems(req,cart);
				
				resp.sendRedirect("clear.jsp");
			}
			
			double totalPrice=0;
			for(CartItem item :cart.getItems().values())
			{
				
				int itemId = item.getId();
				String name = item.getName();
				int price = item.getPrice();
				
				
				System.out.println("hi");
				System.out.println(price);
				
				int quantity = item.getQuantity();
				
				
				  totalPrice +=price *quantity;
				
				
				

				session.setAttribute("totalAmount", totalPrice);
			}
			

			RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private void clearAllItems(HttpServletRequest req, Cart cart) {

		cart.clearAllItems();

	}


	//Adding item to the cart

	private void addItemToCart(HttpServletRequest req, Cart cart) {

		int menuId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int resturantId = Integer.parseInt(req.getParameter("resturantId"));

		MenuDaoImplementation menuDaoImplementation = new MenuDaoImplementation();

		Menu menu = menuDaoImplementation.getMenuById(menuId);

		if(menu != null)
		{
			CartItem cartItem = new CartItem(menuId, 
					resturantId,
					menu.getItemName(),
					menu.getPrice(),
					quantity);

			cart.addItem(cartItem);

		}
	}


	private void updateCartItem(HttpServletRequest req, Cart cart) {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
//		System.out.println(menuId);
		int quantity = Integer.parseInt(req.getParameter("quantity"));
//		System.out.println(quantity);
		cart.updateItem(menuId,quantity);



	}

	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {

		int menuId = Integer.parseInt(req.getParameter("itemId"));
		cart.deleteItem(menuId);

	}



}
