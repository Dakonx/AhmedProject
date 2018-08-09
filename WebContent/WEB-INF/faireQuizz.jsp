<%@page import="model.Reponse"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<%@page import="util.QuestionBDD"%>
<%@page import="util.ReponseBDD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vous faites un quizz</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
<form action="fairequizz" method="post">
<font color="be24ca">
<br>
<% List<Question> quests = QuestionBDD.getQuestionByIDQuizz(Integer.parseInt((String)request.getSession().getAttribute("idQuizzSelect")));

for (int i=0;i<quests.size();i++){
%><fieldset> <h2><%
out.println("       " + "       " +quests.get(i).getIntitulé());
List<Reponse> reponses = ReponseBDD.getReponseByIDQuestion(quests.get(i).getId());
 %><br></h2>
 <% 
for (int j=0;j<reponses.size();j++){ 
	String nameR="choixQ"+i;
	%><input type="radio" name="<%=nameR%>" value="<%=reponses.get(j).getId()%>"/><%
	out.println("       " + reponses.get(j).getReponse());
	%> <br><%
}
%><br></fieldset><br>


<%
}
%>
<input type="submit" />
</font>
</form>
</body>
</html>