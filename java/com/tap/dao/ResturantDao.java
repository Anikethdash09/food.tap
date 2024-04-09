package com.tap.dao;

import java.util.List;

import com.tap.model.Resturant;
import com.tap.model.User;

public interface ResturantDao {
	
	void addResturant(Resturant resturant);

	Resturant getResturant(int resturantId);

	List<Resturant> getAll();

	void updateResturant(Resturant resturant);

	void deleteResturant(int resturantId);


}
