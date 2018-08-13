<%@page import="java.util.ArrayList"%>
<%@page import="util.ParcoursBDD"%>
<%@page import="model.Parcour"%>
<%@page import="model.User"%>
<%@page import="util.UserBDD"%>
<%@page import="model.Quizz"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="util.QuizzBDD"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choisir quizz</title>
</head>
<body
	background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
	<div align="center">
		<form method="POST" action="choisirquizz">
			<%
				List<Quizz> quizzs = QuizzBDD.getQuizzBySujet((String) request.getSession().getAttribute("sujet"));// récupérer tous les quizz qui ont pour sujet le sujet sélectionné
				String loginUser = String.valueOf(request.getSession().getAttribute("login"));
				User user = UserBDD.getUserByLogin(loginUser);
				List<Parcour> parcours = ParcoursBDD.getParcoursByIDUser(user.getId());// récuperer tous les parcours déjà réalisé par ce user
				List<Quizz> quizzList = new ArrayList<Quizz>();
				for (Parcour p : parcours) {

					quizzList.add(p.getQuizz());

				}

				if (!quizzs.isEmpty()) {
					int compteur=0;
					for (int i = 0; i < quizzs.size(); i++) {
						if (!quizzList.contains(quizzs.get(i))) {
							System.out.println("je suis dans le if contains");
							compteur++;
			%>
			<input type="radio" name="quizz" value="<%=quizzs.get(i).getId()%>"><%=compteur%><br>
			<%
				}
					}
					int b = 0;
					for (int i = 0; i < quizzs.size(); i++) {
						if (quizzList.contains(quizzs.get(i))) {
							b++;
						}
					}
					if (b != quizzs.size()) {
			%>

			<input type="submit" />

			<%
				}
					if (b == quizzs.size()) {
			%>

			<h2>Vous avez effectué tout les quizzs de cette matière</h2>
			<a href="/ahmedProject/choisirsujet">retour</a>
			<%
				}
				} else {
			%>

			<h2>il n'y a pas de quizz</h2>
			<a href="/ahmedProject/choisirsujet">retour</a>

			<%
				}
			%>
		
</body>
</html>