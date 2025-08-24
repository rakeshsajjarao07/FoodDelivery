package com.example.dao;

import java.util.List;

import com.example.model.Order;

public interface OrderDao {

	   int addOrder(Order order);
	    Order getOrderById(int orderId);
	    List<Order> getAllOrders();
	    void updateOrder(Order order);
	    void deleteOrder(int orderId);

}
