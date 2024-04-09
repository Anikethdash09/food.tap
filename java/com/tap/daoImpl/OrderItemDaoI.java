package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.model.OrderItem;

public class OrderItemDaoI implements com.tap.dao.OrderItemDao {
	static final String INSERT_QUERY = "INSERT INTO orderitems(`orderItemId`, `userId`, `menuId`, `itemNane`, `rating`, `quantity`)VALUE(?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM orderitems WHERE `orderItemId` = ?";
	static final String UPDATE_QUERY = "UPADTE orderitems SET `userId` = ?, menuId = ?, `itemNane` =?, `rating` =?, `quantity` = ?? WHERE `orderItemId` = ?";
	static final String DELETE_QUERY = "DELETE FROM orderitems WHERE `orderItemId`= ?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM orderitems";
	

	private Connection con;
	private List<OrderItem> orderItemList;
	
	

	public OrderItemDaoI(){

		String url = "jdbc:mysql://localhost:3306/tapfood";
		String username = "root";
		String password = "iwillwinthisworld09";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void addUser(OrderItem orderItem) {
		try {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setInt(1, orderItem.getOrderId());
			statement.setInt(2, orderItem.getUserId());
			statement.setInt(3, orderItem.getMenuId());
			statement.setString(4, orderItem.getItemNane());
			statement.setDouble(5, orderItem.getRating());
			statement.setInt(6, orderItem.getQuantity());

			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public OrderItem getUser(int orderItemId) {
		OrderItem orderItem = null;
		ResultSet res = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SELECT_QUERY);
			statement.setInt(1, orderItem.getOrderId());
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemNane = res.getString("itemNane");
				Double rating = res.getDouble("rating");
				int quantity = res.getInt("quantity");

				orderItem = new OrderItem(orderItemId, userId, menuId, itemNane, rating, quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderItem;
	}

	@Override
	public List<OrderItem> getAll() {
		Statement statement = null;
		ResultSet res = null;
		OrderItem orderItem = null;

		try {
			statement = con.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);

			ArrayList<OrderItem> usersList = new ArrayList<OrderItem>();

			while (res.next()) {

				int orderItemId = res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemNane = res.getString("itemNane");
				Double rating = res.getDouble("rating");
				int quantity = res.getInt("quantity");

				orderItem = new OrderItem(orderItemId, userId, menuId, itemNane, rating, quantity);
				orderItemList.add(orderItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Override
	public void updateUser(OrderItem orderItem) {
		PreparedStatement statement = null;

		try {
			statement.setInt(1, orderItem.getOrderId());
			statement.setInt(2, orderItem.getUserId());
			statement.setInt(3, orderItem.getMenuId());
			statement.setString(4, orderItem.getItemNane());
			statement.setDouble(5, orderItem.getRating());
			statement.setInt(6, orderItem.getQuantity());

			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int orderItemId) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(DELETE_QUERY);

			statement.setInt(1, orderItemId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
