<%@page import="model.Quizz"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="util.QuizzBDD"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choisir quizz</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
	<div align="center">
		<form method="POST" action="choisirquizz">
			<%
				List<Quizz> quizzs = QuizzBDD.getQuizzBySujet((String) request.getSession().getAttribute("sujet"));
				for (int i = 0; i < quizzs.size(); i++) {
			%>
			<input type="radio" name="quizz" value="<%=quizzs.get(i).getId() %>"><%= i+1%><br>
			<%
				}
			%>

			<input type="submit" />
			</form>
			</div>
</body>
</html>