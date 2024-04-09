<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.tap.model.Resturant, java.util.List	"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<style>
		.resturant-container{
			display: flex;
			flex-wrap: wrap;
		}
		.resturant{
			width: 30%;
			margin: 1%;
			border: 1px, solid #ccc;
			padding: 10px;
			text-align: center;
		}
		.resturant-img{
		max-width: 100%;
		height: auto;
		}
	</style>
	
	<div class = "resturant-conatiner">
	<%List<Resturant> resturants = (List<Resturant>) request.getAttribute("resturant");
	for(Resturant resturant: resturants){
	%>
	<div class = menu>
	<img src="<%= resturant.getImagepath() %>" alt = "<%= resturant.getResturantName() %>"></img>
	<p> Name: <%= resturant.getResturantName() %></p>
	<p> Cousine-Type: <%= resturant.getCousineType() %></p>
	<p> Active: <%= resturant.getInActive() %></p>
	<p> Rating: <%= resturant.getRating() %></p>
	<p> ETA<%= resturant.getEta() %></p>
	</div>
	<%} %>}
	</div>
</body>
</html>