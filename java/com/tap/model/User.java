package com.tap.model;

import java.util.Date;

public class User {
	
	private int userId;
	private String name;
	private String email;
	private int phoneNo;
	private String address;
	private String userName;
	private String password;
//	private String createData;
//	private String lastLogin;
	private String role;
	
	public User() {
	
	}

	public User(int userId, String name, String eamil, int phoneNo, String address, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = eamil;
		this.phoneNo = phoneNo;
		this.address = address;
		this.userName = userName;
		this.password = password;
//		this.createData = createData;
//		this.lastLogin = lastLogin;
		this.role = role;
	}

//	public String getCreateData() {
//		return createData;
//	}
//
//	public void setCreateData(String createData) {
//		this.createData = createData;
//	}
//
//	public String getLastLogin() {
//		return lastLogin;
//	}
//
//	public void setLastLogin(String lastLogin) {
//		this.lastLogin = lastLogin;
//	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String eamil) {
		this.email = eamil;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

