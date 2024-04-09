package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDao;
import com.tap.model.Order;
import com.tap.model.User;

public class OrderDaoI implements OrderDao {
	static final String INSERT_QUERY = "INSERT INTO order(`orderId`, `resturantId`, `userId`, `totalAmount`, `modeOfPayment`, `status`)VALUE(?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `order` WHERE `orderId` = ?";
	static final String UPDATE_QUERY = "UPADTE `order` SET `resturantId` = ?, userId = ?, `totalAmount` =?, `modeOfPayment` =?, `status` = ?WHERE `orderId` = ?";
	static final String DELETE_QUERY = "DELETE FROM `order` WHERE `orderId`= ?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `order`";

	private Connection con;
	private List<Order> orderList;

	public OrderDaoI() throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/tapfood";
		String username = "root";
		String password = "iwillwinthisworld09";

		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, username, password);

	}

	@Override
	public void addOrder(Order order) {
		try {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getResturantId());
			statement.setInt(3, order.getUserId());
			statement.setDouble(4, order.getTotalAmount());
			statement.setString(5, order.getModeOfPayment());
			statement.setString(6, order.getStatus());

			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Order getOrder(int orderId) {
		Order order = null;
		ResultSet res = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SELECT_QUERY);
			statement.setInt(1, order.getOrderId());
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("orderId");
				int resturantId = res.getInt("resturantId");
				int userId = res.getInt("userId");
				Double totalAmount = res.getDouble("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");

				order = new Order(id, resturantId, userId, totalAmount, modeOfPayment, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public List<Order> getAll() {
		Statement statement = null;
		ResultSet res = null;

		try {
			statement = con.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);
			Order order = null;

			ArrayList<User> usersList = new ArrayList<User>();

			while (res.next()) {

				int id = res.getInt("orderId");
				int resturantId = res.getInt("resturantId");
				int userId = res.getInt("userId");
				Double totalAmount = res.getDouble("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");

				order = new Order(id, resturantId, userId, totalAmount, modeOfPayment, status);

				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public void updateOrder(Order order) {
		PreparedStatement statement = null;
		try {
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getResturantId());
			statement.setInt(3, order.getUserId());
			statement.setDouble(4, order.getTotalAmount());
			statement.setString(5, order.getModeOfPayment());
			statement.setString(6, order.getStatus());

			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(int orderId) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(DELETE_QUERY);

			statement.setInt(1, orderId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
