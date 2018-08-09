<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation Quizz</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
<div align ="center">
<h1>CREATION DE QUIZZ</h1>
<form method="POST" action="creationquizz">

<input type="radio" name="sujet" value="maths">Maths<br>
<input type="radio" name="sujet" value="francais">français<br>
<input type="radio" name="sujet" value="philo">philo<br><hr/><br>





<input type="text" name="question1" placeholder="question 1"/><br>
<input type="text" name="reponse1q1" placeholder="reponse 1"/><input type="radio" name="reponseq1" value="1"><br>
<input type="text" name="reponse2q1" placeholder="reponse 2"/><input type="radio" name="reponseq1" value="2"><br>
<input type="text" name="reponse3q1" placeholder="reponse 3"/><input type="radio" name="reponseq1" value="3"><br>

<br><hr><br>
<input type="text" name="question2" placeholder="question 2"/><br>
<input type="text" name="reponse1q2" placeholder="reponse 1"/><input type="radio" name="reponseq2" value="1"><br>
<input type="text" name="reponse2q2" placeholder="reponse 2"/><input type="radio" name="reponseq2" value="2"><br>
<input type="text" name="reponse3q2" placeholder="reponse 3"/><input type="radio" name="reponseq2" value="3"><br>

<br><hr><br>
<input type="text" name="question3" placeholder="question 3"/><br>
<input type="text" name="reponse1q3" placeholder="reponse 1"/><input type="radio" name="reponseq3" value="1"><br>
<input type="text" name="reponse2q3" placeholder="reponse 2"/><input type="radio" name="reponseq3" value="2"><br>
<input type="text" name="reponse3q3" placeholder="reponse 3"/><input type="radio" name="reponseq3" value="3"><br>


<input type="submit">






</form>
</div>
</body>
</html>