package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoImpl.MenuDaoI;
import com.tap.model.Menu;


@WebServlet("/menuServlet")

public class menuServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int resID = Integer.parseInt("resturantId");
	
	MenuDaoI menuD = new MenuDaoI();
	List<Menu> allMennuByRestId = menuD.getAllMennuByRestId(resID);
	req.setAttribute("menu", allMennuByRestId);
	RequestDispatcher reqDis = req.getRequestDispatcher("Menu.jsp");
	reqDis.forward(req, resp);
	
	
	
	}	
}
