<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SignIn</title>
<link rel="stylesheet" href="SignIn.css">

</head>
<body>
	<section>
        <form>
            <h1>LOGIN</h1>
            <div class="inputbox">
                <ion-icon name = "mail-outline"></ion-icon>
                <input type="email" required>
                <label for="">Email</label>
            </div>
            <div class="inputbox">
                <ion-icon name = "lock-closed-outline"></ion-icon>
                <input type="password" required>
                <label for="">Password</label>
            </div>
            <div class="forget">
                <label for=""><input type="checkbox">Remember Me</label>
                <a href="#">Forget Password</a>
            </div>
            <button>Log in</button>
            <div class="register">
                <p>Don't have a account <a href="Registration.jsp">Register</a></p>
            </div>            
        </form>
    </section>
</body>
</html>