<%@page import="java.util.ArrayList"%>
<%@page import="util.UserBDD"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des Users</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
	<form action="gestionparcours" method="POST">
 		

	<input type="radio" name="acti" value="delete" checked/>Delete
	<input type="radio" name="acti" value="desactiver"/>Desactiver
		<table border="1">
			<tr>
				<th>Login</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Selection</th>
			</tr>
			<%
				List<User> users2 = UserBDD.rechercherToutLesUsers();
				List<User> usersi = new ArrayList<>();
				for (int i = 0; i < users2.size(); i++) {
					User user1 = users2.get(i);
					if (user1.getStatut())
						usersi.add(user1);
				}
				for (int i = 0; i < usersi.size(); i++) {
					User user = usersi.get(i);
			%>


			<tr>
				<td>
					<%
						out.println(user.getLogin());
					%>
				</td>
				<td>
					<%
						out.println(user.getNom());
					%>
				</td>
				<td>
					<%
						out.println(user.getPrenom());
					%>
				</td>
				<td><input type="checkbox" name="userSelected" value="<%=user.getId()%>" />
				</td>

			</tr>
			<%
				}
			%>
		</table>
		<input type="Submit">
	</form>

</body>
</html>