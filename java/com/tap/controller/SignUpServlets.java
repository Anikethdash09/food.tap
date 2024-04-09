package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.UserDaoI;
import com.tap.model.User;



@WebServlet("/SignUpServlets")
public class SignUpServlets extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		int phoneNo = Integer.parseInt(req.getParameter("phoneNo"));
		
		
		UserDaoI userDao = new UserDaoI();
		User user = new User(1, name, email, phoneNo,null, userName, password, null);
		
		userDao.addUser(user);
		
		RequestDispatcher res = req.getRequestDispatcher("Resturant.jsp");
		res.forward(req, resp);
	}
}
