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
<title>Gestion Statut</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">

	<form action="gestionstatut" method="POST">
	<input type="radio" name="activ" value="activer" checked/>Activer
	<input type="radio" name="activ" value="desactiver"/>Desactiver
		<table border="1">
			<tr>
				<th>Login</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Selection</th>
			</tr>
			<%
				List<User> users = UserBDD.rechercherToutLesUsers();
				List<User> usersi = new ArrayList<>();
				for (int i = 0; i < users.size(); i++) {
					User user1 = users.get(i);
					if (user1.getStatut() == false)
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
				<td><input type="checkbox" name="userAValider" value="<%=user.getId()%>" />
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