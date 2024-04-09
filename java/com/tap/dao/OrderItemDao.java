package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItem;


public interface OrderItemDao {
	
	void addUser(OrderItem orderItem);

	OrderItem getUser(int orderItemId);

	List<OrderItem> getAll();

	void updateUser(OrderItem orderItem);

	void deleteUser(int orderItemId);
}
