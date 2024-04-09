package com.tap.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.ResturantDao;
import com.tap.model.Menu;
import com.tap.model.Resturant;
import com.tap.model.User;

public class ResturantDoaI implements ResturantDao {

	static final String INSERT_QUERY = "INSERT INTO resturant(`resturantID`, `resturantName`, `imagepath`, `rating`, `eta`, `cousineType`, `resturantAddress`, `inActive`, `resturantOwnersID`)VALUE(?,?,?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM resturant WHERE `resturantID` = ?";
	static final String UPDATE_QUERY = "UPADTE resturant SET `resturantName` = ?, imagepath = ?, `rating` =?, `eta` = ?, `cousineType` = ?, `resturantAddress` = ?, `inActive` = ?, `resturantOwnersID` = ? WHERE `resturantID` = ?";
	static final String DELETE_QUERY = "DELETE FROM resturant WHERE `resturantID`= ?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM resturant";
	
	private Connection con;
	private List<Resturant> resturantList;
	
	

	public ResturantDoaI() {
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
	public void addResturant(Resturant resturant) {
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(INSERT_QUERY);
			statement.setInt(1, resturant.getResturantID());
			statement.setString(2, resturant.getResturantName());
			statement.setString(4, resturant.getImagepath());
			statement.setDouble(6, resturant.getRating());
			statement.setTime(3, resturant.getEta());
			statement.setString(9, resturant.getCousineType());
			statement.setString(5, resturant.getResturantAddress());
			statement.setString(7, resturant.getInActive());
			statement.setInt(8, resturant.getResturantOwnersID());

			statement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Resturant getResturant(int resturantID) {
		Resturant resturant = null;
		ResultSet res = null;
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SELECT_QUERY);
			statement.setInt(1, resturant.getResturantID());
			res = statement.executeQuery();

			if (res.next()) {
				int resturantID1 = res.getInt("resturantID");
				String resturantName = res.getString("resturantName");
				String imagepath = res.getString("imagepath");
				Double rating = res.getDouble("rating");
				Time eta = res.getTime("eta");
				String cousineType = res.getString("cousineType");
				String resturantAddress = res.getString("resturantAddress");
				String inActive = res.getString("inActive");
				int resturantOwnersID = res.getInt("resturantOwnersID");

				resturant = new Resturant(resturantID1, resturantName, imagepath, rating, eta, cousineType,
						resturantAddress, inActive, resturantOwnersID);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resturant;
	}

	@Override
	public List<Resturant> getAll() {
		Statement statement = null;
		ResultSet res = null;
		ArrayList<Resturant> resturantList = new ArrayList<Resturant>();

		try {
			statement = con.createStatement();
			Resturant resturant = null;
			res = statement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int resturantID = res.getInt("resturantID");
				String resturantName = res.getString("resturantName");
				String imagepath = res.getString("imagepath");
				Double rating = res.getDouble("rating");
				Time eta = res.getTime("eta");
				String cousineType = res.getString("cousineType");
				String resturantAddress = res.getString("resturantAddress");
				String inActive = res.getString("inActive");
				int resturantOwnersID = res.getInt("resturantOwnersID");

				resturant = new Resturant(resturantID, resturantName, imagepath, rating, eta, cousineType,
						resturantAddress, inActive, resturantOwnersID);

				resturantList.add(resturant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resturantList;
	}

	@Override
	public void updateResturant(Resturant resturant) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(UPDATE_QUERY);
			statement.setInt(1, resturant.getResturantID());
			statement.setString(2, resturant.getResturantName());
			statement.setTime(3, resturant.getEta());
			statement.setString(4, resturant.getImagepath());
			statement.setString(5, resturant.getResturantAddress());
			statement.setDouble(6, resturant.getRating());
			statement.setString(7, resturant.getInActive());
			statement.setInt(8, resturant.getResturantOwnersID());
			statement.setString(9, resturant.getCousineType());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteResturant(int resturantID) {
		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(DELETE_QUERY);

			statement.setInt(1, resturantID);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
