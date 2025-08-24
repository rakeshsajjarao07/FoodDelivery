package com.example.dao;

import java.util.List;

import com.example.model.OrderItem;

public interface OrderItemDao {

	 void addOrderItem(OrderItem orderItem);
	    OrderItem getOrderItemById(int orderItemId);
	    List<OrderItem> getAllOrderItems();
	    void updateOrderItem(OrderItem orderItem);
	    void deleteOrderItem(int orderItemId);
}
