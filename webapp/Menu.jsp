<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.tap.model.Menu, java.util.List	"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<style>
		.menu-container{
			display: flex;
			flex-wrap: wrap;
		}
		.menu{
			width: 30%;
			margin: 1%;
			border: 1px, solid #ccc;
			padding: 10px;
			text-align: center;
		}
		.menu-img{
		max-width: 100%;
		height: auto;
		}
	</style>
	
	<div class = "menu-conatiner">
	<%List<Menu> menus = (List<Menu>) request.getAttribute("menu");
	for(Menu menu: menus){
	%>
	<div class = menu>
	<img src="<%= menu.getImagePath() %>" alt = "<%= menu.getName() %>"></img>
	<p> Name: <%= menu.getName() %></p>
	<p> Price: <%= menu.getPrice() %></p>
	<p> Available: <%= menu.getIsAvailable() %></p>
	<p> Rating: <%= menu.getRating() %></p>
	</div>
	<%} %>}
	</div>
	
	
</body>
</html>