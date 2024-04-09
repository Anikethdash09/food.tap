package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.dao.UserDao;
import com.tap.daoImpl.UserDaoI;



public class LogInServlets extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		UserDaoI userDao = new UserDaoI();
		
		
		if(userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
			boolean authenticate = userDao.authenticate(userName, password);
			
			
			
			if(authenticate) {
				resp.sendRedirect("ResturantServlets");
			}
			else {
				resp.sendRedirect("Registration.jsp");
			}
		}else{
			resp.sendRedirect("Registration.jsp");
		}
	}
}
