<%@page import="model.Reponse"%>
<%@page import="util.ReponseBDD"%>
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
<form action="modifquizz" method="POST">
	<%
		Quizz quizz = QuizzBDD.getQuizzByIDQuizz(Integer.parseInt(String.valueOf(request.getSession().getAttribute("idQuizzModif"))));
		List<Competence> competenceList = CompetenceBDD.getAllCompetence();

		
			List<Question> questionList = QuestionBDD.getQuestionByIDQuizz(quizz.getId());
	%>
	<select name="sujet">
		<%
			for (int j = 0; j < competenceList.size(); j++) {
		%>
		<option
			<%if (competenceList.get(j).getSujet().equals(quizz.getSujet().getSujet())) {%>
			selected <%}%> value="<%=competenceList.get(j).getSujet()%>"><%=competenceList.get(j).getSujet()%></option>
		<%
			}
		%>
	</select>
	<%
		for (int i2 = 0; i2 < questionList.size(); i2++) {
				List<Reponse> reponseList = ReponseBDD.getReponseByIDQuestion(questionList.get(i2).getId());
				Question question = questionList.get(i2);
	%>
	<br>
	<input type="text" name="question<%=i2%>"
		value="<%=question.getIntitulé()%>" />Question<%=i2%><br>
	<%
		for (int i3 = 0; i3 < reponseList.size(); i3++) {
			Reponse reponse =reponseList.get(i3);
	%>
	<input type="radio" name="reponsecorrect<%=i2%>" value="<%= reponse.getId()%>" <%if(reponse.getId().equals(question.getReponseCorrect().getId())){%>checked<%} %>/>
	<input type="text" name="reponse<%=i3%>"
		value="<%=reponse.getReponse()%>" />Reponse<%=i3%>
	<br>
	<%
		} //fermeture du for par reponse
			} //fermeture du for par question
	%><br>
	<br>
	<input type="submit"/>
</form>
</body>
</html>