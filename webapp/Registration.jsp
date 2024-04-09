<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration</title>
<link rel="stylesheet" href="Registration.css">
</head>
<body>
	<section>
        <form action ="SignUpServlets">
            <h1>Register</h1>
            <div class="inputbox">
                <input type="username" required>
                <label for="">Username</label>
            </div>
            <div class="inputbox">
                <input type="email" required>
                <label for="">Email</label>
            </div>
            <div class="inputbox">
                <input type="password" required>
                <label for="">Password</label>
            </div>
            <div class="inputbox">
                <input type="cpassword" required>
                <label for="">Confirm Password</label>
            </div>
            <button>Submit</button>

            <div class="forget">
                <a href="#">Forget Password</a>
            </div>
                   
        </form>
    </section>
</body>
</html>