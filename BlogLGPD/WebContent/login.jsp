<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
<h1>Logar na Área Reservada</h1>
<a href="LogoutServlet">Logout</a>
<a href="ProfileServlet">Perfil</a>
<br>
<br>
<form action="LoginServlet" method="post">  
Name:<input type="text" name="name"><br><br>  
Password:<input type="password" name="password"><br><br><br>  
<input type="submit" value="login">  
</form>  
</body>
</html>