package com.tap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.ResturantDoaI;
import com.tap.model.Resturant;



@WebServlet("/ResturantServlet")
public class ResturantServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResturantDoaI resturantDoaI = null;
		List<Resturant> all = resturantDoaI.getAll();
		
		req.setAttribute("resturants", all);
		RequestDispatcher rd = req.getRequestDispatcher("resturant.jsp");
		rd.forward(req, resp);
		
		
		
	}

}
