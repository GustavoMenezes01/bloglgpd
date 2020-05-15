<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Postagem</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/blog-home.css" rel="stylesheet">
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<div class="col-md-6" id="">
					<a class="navbar-brand" href="index.jsp">Postagem</a>
				</div>
				<div class="col-md-6 menu" id="">
					<a href="LogoutServlet">Logout</a> <a href="ProfileServlet">Perfil</a>
					<a href="PostagemServlet">Postagem</a>
				</div>
			</div>
		</nav>
	</div>
	<br>
	<br>
	<section class="divPostagem">

		<div class=" container logout">
			<div class="form1">
				<form action="PostagemServlet" method="post">
					<label>Autor:</label> <input type="text" name="AUTOR_POSTAGEM"><br>
					<label>Título:</label> <input type="text" name="TITULO_POSTAGEM"
						value="<%=request.getParameter("titulo")%>"><br>

					<label>Referencia:</label> <input type="text" name="REFERENCIA"
						value="<%=request.getParameter("referencia")%>"><br>

					<br>
					<textarea id="texto" name="MENSAGEM_POSTAGEM" rows="4" cols="50"></textarea>
					<br>
					<%--Data:<input type="text" name="DATA_POSTAGEM" placeholder="dd/MM/aaaa HH:mm">

<br> --%>

					<%
						Date data = new Date();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						out.print(sdf.format(data));
					%>
					<input type="submit" value="Enviar">

				</form>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Desenvolvido por Alunos da
				USJT - Santana &copy; 2020</p>
		</div>
		<!-- /.container -->
	</footer>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>

	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>