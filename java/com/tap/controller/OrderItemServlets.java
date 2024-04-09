package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tap.daoImpl.OrderItemDaoI;
import com.tap.model.OrderItem;

@WebServlet("/OrderItemServlets")
public class OrderItemServlets extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String itemname = req.getParameter("itemName");
		Double rating = Double.parseDouble(req.getParameter("rating"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		OrderItemDaoI orderItemDao = new OrderItemDaoI();
		OrderItem orderItem = new OrderItem(null, null, null, itemname, rating, quantity);
		orderItemDao.addUser(orderItem);
		
		RequestDispatcher res = req.getRequestDispatcher("OrderItem.jsp");
		res.forward(req, resp);
	}
}