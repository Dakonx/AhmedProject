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

<script>
	function testJS() {
		//console.log(request.getParameter("userselect"));
		var e = document.getElementById("userselect");
		console.log(e.options[e.selectedIndex].value);
	}
</script>

<body>
<td><select id="userselect" size="1"> 
				<% 
 					List<User> users = UserBDD.rechercherToutLesUsers();
 					for (int j = 0; j < users.size(); j++) {
 						User us = users.get(j);
 				%> 
 			 	<option value="<%=us.getLogin()%>"  onclick="testJS()"><%=us.getLogin()%></OPTION>
 				<% 
 					}
 					
 				%> 
</select></td>

<%-- <% User user=UserBDD.getUserByLogin("l.monchau@laposte.net"); --%>
//    int iduser=user.getId();
<%-- %> --%>
</body>
</html>