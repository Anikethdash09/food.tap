package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoI implements UserDao {

	static final String INSERT_QUERY = "INSERT INTO user(userId, `name`, `email`, `phoneNo`, `address`, `username`, `password`)VALUE(?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `user` WHERE `userID` = ?";
	static final String UPDATE_QUERY = "UPADTE `user` SET `name` = ?, email = ?, `phoneNo` =?, `address` =?, `username` = ?, `password` = ?, `role` = ? WHERE `userId` = ?";
	static final String DELETE_QUERY = "DELETE FROM `user` WHERE `userID`= ?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `user`";
	static final String AUTHENTICATE_USER_QUERY = "SELECT * FROM `user` where `username` = ?, `password`=?";

	private Connection con;
	private List<User> usersList;

	public UserDaoI() {

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
	public void addUser(User user) {
		try {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getPhoneNo());
			statement.setString(5, user.getAddress());
			statement.setString(6, user.getUserName());
			statement.setString(7, user.getPassword());
			statement.setString(8, user.getRole());
			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUser(int userId) {

		User user = null;
		ResultSet res = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SELECT_QUERY);
			statement.setInt(1, user.getUserId());
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				int phoneNo = res.getInt("phoneNo");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
//				Date createdate = res.getDate("createDate");
//				Date lastlogin = res.getDate("lastLogin");

				user = new User(userId, name, email, phoneNo, address, userName, password, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<User> getAll() {
		Statement statement = null;
		ResultSet res = null;

		try {
			statement = con.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);

			ArrayList<User> usersList = new ArrayList<User>();

			while (res.next()) {

				int userid = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				int phoneNo = res.getInt("phoneNo");
				String address = res.getString("address");
				String username = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
//				Date createdate = res.getDate("createDate");
//				Date lastlogin = res.getDate("lastLogin");

				User user = new User(userid, name, email, phoneNo, address, username, password, role);
				usersList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Override
	public void updateUser(User user) {

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(UPDATE_QUERY);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getName());
			statement.setInt(6, user.getPhoneNo());
//			statement.setString(7, user.getCreateData());
//			statement.setString(8, user.getLastLogin());
			statement.setString(9, user.getRole());

			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int userId) {

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(DELETE_QUERY);

			statement.setInt(1, userId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean authenticate(String userName, String password) {
		ResultSet ptsmt = null;
		PreparedStatement statement = null;
		
		try {
			statement = con.prepareStatement(AUTHENTICATE_USER_QUERY);
			statement.setString(1, userName);
			statement.setString(2, password);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			return ptsmt.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;

}


}
