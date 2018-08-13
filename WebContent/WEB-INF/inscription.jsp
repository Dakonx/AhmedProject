<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body background="https://i2.wp.com/www.odilesacoche.be/wp-content/uploads/2016/04/WALLPAPER-UNICORN-DESKTOP-PC.jpg">
<form method="post" action="inscription">

<input type="email" placeholder="email" name="insLogin" required/><br><br>
<input type="password" placeholder="password" name="insPassword" required /><br><br>
<input type="text" placeholder="nom" name="insNom" required/><br><br>
<input type="text" placeholder="prenom" name="insPrenom" required/><br><br>
<input type="text" placeholder="societe" name="insSociete" required/><br><br>
<input type="text" placeholder="telephone" name="insTelephone" required/><br><br>
<input type="checkbox" value="admin" name="insAdmin"/> cochez si admin <br><br>
<input type="submit"/>
<input type="reset"/>


</form>

</body>
</html>