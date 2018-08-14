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
<title>Insert title here</title>
</head>
<body>
<form action="users" method="POST">
		<table border="1">
			<tr>
				<th>Login</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Societe</th>
				<th>Telephone</th>
				<th>Statut</th>
				<th>Selection</th>
			</tr>
			<%
				List<User> users = UserBDD.rechercherToutLesUsers();
				
				for (int i = 0; i < users.size(); i++) {
					User user = users.get(i);
					
				
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
				<td>
					<%
						out.println(user.getSociete());
					%>
				</td>
				<td>
					<%
						out.println(user.getTelephone());
					%>
				</td>
				<td>
					<%
						out.println(user.getStatut());
					%>
				</td>
				<td><input type="radio" name="userAModifier" value="<%=user.getId()%>" />
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