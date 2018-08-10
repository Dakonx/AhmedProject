<%@page import="util.UserBDD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello User.</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
	<br>
	<div align="center">
		<h1>
			<font color="red">Bonjour
			<%=
			UserBDD.getUserByLogin((String) request.getSession().getAttribute("login")).getPrenom()
		%>
		</font></h1>
		<br>
	</div>
	<div align="center">
		<h2>tu as été reconnu dans la base de données, que souhaite tu
			faire.</h2>
	</div>
	<br>
	<div align="center">
		<a href="/ahmedProject/parcours"> Vos Parcours </a>
	</div>

	<div align="center">
		<a href='/ahmedProject/choisirsujet'> Faire un quizz </a>
	</div>
</body>
</html>