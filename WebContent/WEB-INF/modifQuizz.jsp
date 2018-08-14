<%@page import="model.Question"%>
<%@page import="util.QuestionBDD"%>
<%@page import="model.Competence"%>
<%@page import="util.CompetenceBDD"%>
<%@page import="model.Quizz"%>
<%@page import="java.util.List"%>
<%@page import="util.QuizzBDD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un Quizz</title>
</head>
<body>
<%
List<Quizz> quizzList = QuizzBDD.getAllQuizz();
List<Competence> competenceList = CompetenceBDD.getAllCompetence();


for(int i=0;i<quizzList.size();i++){
List<Question> questionList= QuestionBDD.getQuestionByIDQuizz(quizzList.get(i).getId());
for(int i2=0;i2<questionList.size();i2++){

%>
<selected name="sujet" size"<%=competenceList.size()%>">
<% 
for(int j=0;j<competenceList.size();j++){
%>
<option><%=competenceList.get(j).getSujet()%></option>
<%
} 
%>
</selected>

<input />
<%
}//fermeture du for par question
}//fermeture du for general
%>

</body>
</html>