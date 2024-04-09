package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.MenuDao;
import com.tap.model.Menu;


public class MenuDaoI implements MenuDao {

	static final String INSERT_QUERY = "INSERT INTO menu(`menuId`, `name`, `price`, `description`, `imagePath`, `isAvailable`, `resturantId`, `rating`)VALUE(?,?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `menu` WHERE `menuId` = ?";
	static final String UPDATE_QUERY = "UPADTE `menu` SET `name` = ?, price = ?, `description` =?, `imagePath` =?, `isAvailable` = ?, `resturantId` = ?, `rating` = ? WHERE `menuId` = ?";
	static final String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId`= ?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `menu`";
	static final String SELECT_ALL_RESTID_QUERY = "SELECT * FROM `menu` where `resturantId`=?";

	private Connection con = null;
	private List<Menu> menuList;

	public MenuDaoI() {

		String url = "jdbc:mysql://localhost:3306/tapfood";
		String username = "root";
		String password = "iwillwinthisworld09";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addMenu(Menu menu) {
		try {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setInt(1, menu.getMenuId());
			statement.setString(2, menu.getName());
			statement.setDouble(3, menu.getPrice());
			statement.setString(4, menu.getDescription());
			statement.setString(5, menu.getImagePath());
			statement.setString(6, menu.getIsAvailable());
			statement.setInt(7, menu.getResturantId());
			statement.setDouble(8, menu.getRating());
			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Menu getMenu(int menuId) {
		Menu menu = null;
		ResultSet res = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SELECT_QUERY);
			statement.setInt(1, menu.getMenuId());
			res = statement.executeQuery();

			if (res.next()) {
				int id = res.getInt("menuId");
				String name = res.getString("name");
				Double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				int resturantId = res.getInt("resturantId");
				Double rating = res.getDouble("rating");

				menu = new Menu(menuId, name, price, description, imagePath, isAvailable, resturantId, rating);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public List<Menu> getAll() {
		Statement statement = null;
		ResultSet res = null;

		try {
			statement = con.createStatement();
			res = statement.executeQuery(SELECT_ALL_QUERY);
			Menu menu = null;

			ArrayList<Menu> menuList = new ArrayList<Menu>();

			while (res.next()) {

				int id = res.getInt("menuId");
				String name = res.getString("name");
				Double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				int resturantId = res.getInt("resturantId");
				Double rating = res.getDouble("rating");

				menu = new Menu(id, name, price, description, imagePath, isAvailable, resturantId, rating);
				menuList.add(menu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;

	}

	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement statement = null;

		try {
			statement.setInt(1, menu.getMenuId());
			statement.setString(2, menu.getName());
			statement.setDouble(3, menu.getPrice());
			statement.setString(4, menu.getDescription());
			statement.setString(5, menu.getImagePath());
			statement.setString(6, menu.getIsAvailable());
			statement.setInt(7, menu.getResturantId());
			statement.setDouble(8, menu.getRating());

			statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteMenu(int menuId) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(DELETE_QUERY);

			statement.setInt(1, menuId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMennuByRestId(int resturantId) {
		Menu menu = null;
		ResultSet res = null;
		PreparedStatement statement = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			statement = con.prepareStatement(SELECT_ALL_RESTID_QUERY);
			statement.setInt(1, menu.getResturantId());
			res = statement.executeQuery();

			if (res.next()) {
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				Double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				int Id = res.getInt("resturantId");
				Double rating = res.getDouble("rating");

				menu = new Menu(menuId, name, price, description, imagePath, isAvailable, resturantId, rating);
				menuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuList;
		
	}

}

