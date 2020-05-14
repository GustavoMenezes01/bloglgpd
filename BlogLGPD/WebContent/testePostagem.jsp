<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Postagem</title>
</head>
<body>
	<h1>Postagem</h1>
	<a href="LogoutServlet">Logout</a>
	<a href="ProfileServlet">Perfil</a>
	<a href="PostagemServlet">Postagem</a>
	<br>
	<br>
	<form action="PostagemServlet" method="post">
		Autor:<input type="text" name="AUTOR_POSTAGEM" ><br>
		Título:<input type="text" name="TITULO_POSTAGEM" value="<%= request.getParameter("titulo")%>"><br>
		Referencia:<input type="text" name="REFERENCIA" value="<%= request.getParameter("referencia")%>"><br>
		<br>
		<textarea id="texto" name="MENSAGEM_POSTAGEM" rows="4" cols="50"></textarea><br>
		<%--Data:<input type="text" name="DATA_POSTAGEM" placeholder="dd/MM/aaaa HH:mm"><br> --%>
		
		<%
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		out.print(sdf.format(data));
		%>
		<input type="submit" value="Enviar">
		
	</form>
</body>
</html>