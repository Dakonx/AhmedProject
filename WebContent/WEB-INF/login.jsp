<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>






</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">


	<form method="post" action="login">

		<fieldset>
		
			<legend>Se connecter</legend>
			
			
			<label>Login: <input type="email" name="login" placeholder="votre E-mail" scope ="session"  /></label><br> <br>
			<label>Password <input type="password" name="password" placeholder="votre mot de passe" scope ="session" /></label><br> <br>
			
			<br><input type="radio" name="admin" value="admin" checked/> Vous êtes un Admin
			<input type="radio" name="admin" value="user"  />Vous êtes un Péon <br>
			
			<br>
			<input type="submit" /> <input type="reset" /><br> <br>

			
			<a href ="/ahmedProject/inscription" > Pas encore inscrit, Clic ici ! </a>  <br>

		</fieldset>
	</form>

</body>
</html>