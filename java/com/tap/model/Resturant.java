package com.tap.model;

import java.sql.Time;

public class Resturant {
	
	private int resturantID;
	private String resturantName;
	private String imagepath;
	private Double rating;
	private Time eta;
	private String cousineType;
	private String resturantAddress;
	private String inActive;
	private int resturantOwnersID;
	
	
	public Resturant() {
	
	}


	public Resturant(int resturantID, String resturantName, String imagepath, Double rating, Time eta,
			String cousineType, String resturantAddress, String inActive, int resturantOwnersID) {
//		super();
		this.resturantID = resturantID;
		this.resturantName = resturantName;
		this.imagepath = imagepath;
		this.rating = rating;
		this.eta = eta;
		this.cousineType = cousineType;
		this.resturantAddress = resturantAddress;
		this.inActive = inActive;
		this.resturantOwnersID = resturantOwnersID;
	}


	public int getResturantID() {
		return resturantID;
	}


	public void setResturantID(int resturantID) {
		this.resturantID = resturantID;
	}


	public String getResturantName() {
		return resturantName;
	}


	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public Time getEta() {
		return eta;
	}


	public void setEta(Time eta) {
		this.eta = eta;
	}


	public String getCousineType() {
		return cousineType;
	}


	public void setCousineType(String cousineType) {
		this.cousineType = cousineType;
	}


	public String getResturantAddress() {
		return resturantAddress;
	}


	public void setResturantAddress(String resturantAddress) {
		this.resturantAddress = resturantAddress;
	}


	public String getInActive() {
		return inActive;
	}


	public void setInActive(String inActive) {
		this.inActive = inActive;
	}


	public int getResturantOwnersID() {
		return resturantOwnersID;
	}


	public void setResturantOwnersID(int resturantOwnersID) {
		this.resturantOwnersID = resturantOwnersID;
	}
	
	
}

