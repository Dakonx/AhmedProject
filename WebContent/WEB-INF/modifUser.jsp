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


<% 
	int idUser=Integer.parseInt(String.valueOf(request.getSession().getAttribute("idUserModif")));
	System.out.print(idUser);
	User user=UserBDD.getUserByID(idUser);
   	user.getId();


%>
<form method="post" action="modifuser">

<input type="hidden" name="iduser" value="<%=idUser%>" />

<input type="email" placeholder="email" name="modLogin" value="<%= user.getLogin() %>" />  Login<br><br>
<input type="text" placeholder="password" name="modPassword" value="<%= user.getPass() %>"/>  Password<br><br>
<input type="text" placeholder="nom" name="modNom" value="<%= user.getNom() %>"/>  Nom<br><br>
<input type="text" placeholder="prenom" name="modPrenom" value="<%= user.getPrenom() %>"/>  Prenom<br><br>
<input type="text" placeholder="societe" name="modSociete" value="<%= user.getSociete() %>"/>  Societe<br><br>
<input type="text" placeholder="telephone" name="modTelephone" value="<%= user.getTelephone() %>" />  Telephone<br><br>
<input type="radio" value="actif" name="modStatut" <%if(user.getStatut()){%>checked<%}%>/> actif <br><br>
<input type="radio" value="pasactif" name="modStatut" <%if(!user.getStatut()){%>checked<%}%>/> pas actif <br><br>
<input type="radio" value="delete" name="modStatut" /> Delete <br><br>

<input type="submit"/>
<input type="reset"/>


</form>
</body>
</html>