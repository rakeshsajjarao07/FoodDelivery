package com.example.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.example.daoimplementation.OrderDaoImplementation;
import com.example.daoimplementation.OrderItemDaoImplementation;
import com.example.model.Cart;
import com.example.model.CartItem;
import com.example.model.Order;
import com.example.model.OrderItem;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class Checkout extends HttpServlet{
	

	
	private OrderDaoImplementation orderdao;
	private OrderItemDaoImplementation oidi;
	
	@Override
	public void init() throws ServletException {

		orderdao= new OrderDaoImplementation();
		 
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		HttpSession session = req.getSession();
		
		Cart cart =(Cart) session.getAttribute("cart");
		User user =(User) session.getAttribute("logedIn");
		
//		System.out.println("hi");
//		System.out.println(user);
		
		if(cart != null && user != null && !cart.getItems().isEmpty())
		{
			String paymentMethod = req.getParameter("paymentMethod");
			String address = req.getParameter("address");
			
			Order order = new Order();
			
			order.setAddress(address);
			order.setUserId(user.getUserId());
			order.setRestaurantId((int)session.getAttribute("resturantId"));
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setStatus("Pending");
			order.setPaymentMode(paymentMethod);
			
			double totalAmount=0;
			
			for(CartItem item :cart.getItems().values())
			{
				totalAmount += item.getPrice() * item.getQuantity();
			}
			
			order.setTotalAmount(totalAmount);
			
			//inserting the order
			int orderId = orderdao.addOrder(order);
			
			
			for(CartItem item :cart.getItems().values())
			{
				int itemId = item.getId();
				String name = item.getName();
				int price = item.getPrice();
				int quantity = item.getQuantity();
				
				
				double totalPrice =price *quantity;
				
				OrderItem orderItem = new OrderItem(orderId, itemId, quantity, totalAmount);
				
				 oidi = new OrderItemDaoImplementation();
				
				oidi.addOrderItem(orderItem);

			}
			
			session.removeAttribute("cart");
			session.setAttribute("order", order);
			
			resp.sendRedirect("order_confirm.jsp");
			
		}
		else {
			if(user == null)
			{
				resp.sendRedirect("signin.html");
			}
		}
	}
}
