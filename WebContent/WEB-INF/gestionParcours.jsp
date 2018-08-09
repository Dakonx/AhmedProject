<%@page import="util.UserBDD"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de parcours</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
	<form>
		<td><select name="user" size="1">
				<%
					List<User> users = UserBDD.rechercherToutLesUsers();
					for (int j = 0; j < users.size(); j++) {
						User us = users.get(j);
				%>
				<option value="<%=us.getLogin()%>"><%=us.getLogin()%></OPTION>
				<%
					}
				%>



		</select></td>
	</form>

</body>
</html>