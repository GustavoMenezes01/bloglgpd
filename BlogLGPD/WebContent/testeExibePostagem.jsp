<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Postagem"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Postagem</title>
</head>
<body>
<%Postagem postagem=(Postagem)request.getAttribute("postagem"); %>
	<h1>Postagem</h1>
	<br>
	<br>
	<div class="row">
		<div class="col-md-12">
			<p>
				<strong>Título</strong>
			</p>
			<p>
				<%=postagem.getTitulo()%>
			</p>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<p>
				<strong>Texto</strong>
			</p>
			<p>
				<%=postagem.getTexto()%>
			</p>
		</div>
	</div>
</body>
</html>