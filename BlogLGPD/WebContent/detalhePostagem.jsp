<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Postagens</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/blog-home.css" rel="stylesheet" type="text/css">
<!-- For new browsers - multisize ico  -->
<link rel="icon" type="image/x-icon" sizes="16x16 32x32"
	href="img/favicon-16x16.png">

</head>

<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="Index"><img id="iconehome"
					src="img/business-and-finance.svg"> LGPD</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria- controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">

					<span class="navbar-toggler-icon"></span>

				</button>
				<div class="col-md-6" id="">
					<a class="idmenu" href="LogoutServlet">Logout</a> <a class="idmenu"
						href="testePostagem.jsp">Postagem</a> <a class="idmenu"
						href="AprovacaoPostagem">Moderação de postagem</a>

				</div>
			</div>
		</nav>

		<section class="divLogout">
		<div class=" container formpost">
			<div class="form">
			<label>Id: ${post.id} </label>
			<label>Autor: ${post.autor} </label>
			<label>Título: ${post.titulo} </label>
			<label>Mensagem: ${post.texto} </label>
			<label>Data/Hora: ${post.data} </label>
			<br>
			</div>
			</div>
			<div id="actions" class="row">
			<div class="col-md-12 buttonvoltar">
				<input type="button" value="Voltar"
					onclick="openPage('AprovacaoPostagem')">
			</div>
		</div>
		</div>

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

		<script src="js/script.js"></script>
</body>

</html>