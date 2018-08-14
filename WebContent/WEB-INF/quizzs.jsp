<%@page import="java.util.ArrayList"%>
<%@page import="model.Question"%>
<%@page import="util.QuestionBDD"%>
<%@page import="util.CompetenceBDD"%>
<%@page import="model.Competence"%>
<%@page import="model.Quizz"%>
<%@page import="util.QuizzBDD"%>
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
<form action="quizzs" method="POST">
		<table border="1">
			<tr>
				<th>Sujet</th>
				<%
				List<Quizz> quizzList = QuizzBDD.getAllQuizz();
				List<Question> questionList = new ArrayList<>();
				for (int i = 0; i < quizzList.size(); i++) {
					Quizz quizz = quizzList.get(i);
				questionList = QuestionBDD.getQuestionByIDQuizz(quizzList.get(i).getId());}
				for(int j = 0; j<questionList.size(); j++){
				%>
				<th>Question<%=j+1%></th>
				<% 
				}
				
				%>
				<th>Selection</th>
			</tr>
			<%
				
				List<Competence> competenceList = CompetenceBDD.getAllCompetence();
				for (int i = 0; i < quizzList.size(); i++) {
					Quizz quizz = quizzList.get(i);
					questionList = QuestionBDD.getQuestionByIDQuizz(quizzList.get(i).getId());
				
			%>


			<tr>
				<td>
					<%
						out.println(quizz.getSujet().getSujet());
					%>
				</td>
				<% for(int j = 0; j<questionList.size(); j++){ %>
				<td>
					<%
						out.println(questionList.get(j).getIntitulé());
					%>
				</td>
				<%
				}
					%>
				
				<td><input type="radio" name="quizzAModifier" value="<%=quizz.getId()%>" />
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