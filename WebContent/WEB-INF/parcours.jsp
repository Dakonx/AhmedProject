<%@page import="model.User"%>
<%@page import="util.UserBDD"%>
<%@page import="model.Reponse"%>
<%@page import="util.ChoixBDD"%>
<%@page import="model.Question"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Competence"%>
<%@page import="util.ParcoursBDD"%>
<%@page import="model.Quizz"%>
<%@page import="model.Parcour"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parcours</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
<br><br>
	<%
		String login=(String)request.getSession().getAttribute("login");
		User user=UserBDD.getUserByLogin(login);
		List<Parcour> parcours = ParcoursBDD.getParcoursByIDUser(user.getId());
		for(int j=0;j<parcours.size();j++){
			Parcour parcour=parcours.get(j);
		Quizz quizz = parcour.getQuizz();
		Competence competence = quizz.getSujet();
		List<Question> quests = quizz.getQuestion();
		float tempsSeconde = parcour.getTemps()/1000;
	%><br><h2><%
	%><font color ="#3368d8"><%out.println("Parcour numero :  "+(j+1)+"   --   Score :  " + parcour.getScore() + "     --     Sujet :  " + competence.getSujet() + "    --     Temps mis à faire ce quizz: "+ tempsSeconde+" secondes");%></font><%
	%></h2>
	<%
		if (!quests.isEmpty()) {
			%><br><%
			for (int i = 0; i < quests.size(); i++) {
				Question question = quests.get(i);
	
				Reponse choix = ChoixBDD.getChoixByIDQuestionAndParcour(question.getId(), parcour.getId());

				out.println("question     " + (i + 1) + "   :   " + question.getIntitulé() + "       reponse :     " + choix.getReponse());
				if (choix.getReponse().equals(question.getReponseCorrect().getReponse())) {
					%><font color =" #069e5e "><% out.println("       -  -      reponse correct   ");%></font><%
				} else {
					%><font color ="red"><% out.println("      -  -      reponse incorrect   ");%></font><%

				}
	%><br>
	<%
		}
		}%><br><br><%
	}
	%>

</body>
</html>