package com.tap.model;

public class OrderItem {
	int orderItemId;
	int userId;
	int menuId;
	String itemNane;
	Double rating;
	int quantity;
	
	
	public OrderItem() {

	}


	public OrderItem(int orderId, int userId, int menuId, String itemNane, Double rating, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.userId = userId;
		this.menuId = menuId;
		this.itemNane = itemNane;
		this.rating = rating;
		this.quantity = quantity;
	}


	public int getOrderId() {
		return orderItemId;
	}


	public void setOrderId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public String getItemNane() {
		return itemNane;
	}


	public void setItemNane(String itemNane) {
		this.itemNane = itemNane;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
