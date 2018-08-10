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
<% User user=UserBDD.getUserByLogin(request.getParameter("user"));
   int iduser=user.getId();


%>
<form method="post" action="modifuser">

<input type="hidden" name="iduser" value="<%=iduser%>" />

<input type="email" placeholder="email" name="modLogin" value="<%= user.getLogin() %>" /><br><br>
<input type="text" placeholder="password" name="modPassword" value="<%= user.getPass() %>"/><br><br>
<input type="text" placeholder="nom" name="modNom" value="<%= user.getNom() %>"/><br><br>
<input type="text" placeholder="prenom" name="modPrenom" value="<%= user.getPrenom() %>"/><br><br>
<input type="text" placeholder="societe" name="modSociete" value="<%= user.getSociete() %>"/><br><br>
<input type="text" placeholder="telephone" name="modTelephone" value="<%= user.getTelephone() %>" /><br><br>
<input type="radio" value="actif" name="modStatut" <%if(user.getStatut()){%>checked<%}%>/> actif <br><br>
<input type="radio" value="pasactif" name="modStatut" <%if(!user.getStatut()){%>checked<%}%>/> pas actif <br><br>

<input type="submit"/>
<input type="reset"/>


</form>
</body>
</html>