<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moderação</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/blog-home.css" rel="stylesheet">
<!-- For new browsers - multisize ico  -->
<link rel="icon" type="image/x-icon" sizes="16x16 32x32" href="img/favicon-16x16.png">
</head>
<body>
<div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
<div class="container">
<a class="navbar-brand" href="Index"><img id="iconehome" src="img/business-and-finance.svg"> LGPD</a>

<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-
controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">

<span class="navbar-toggler-icon"></span>
</button>
<div class="col-md-6" id="">
<a class="idmenu" href="LogoutServlet">Logout</a>
<a class="idmenu" href="testePostagem.jsp">Criar postagem</a>
<a class="idmenu" href="AprovacaoPostagem">Moderação de postagem</a>

</div>
</div>
</nav>
</div>
<br>

<br>
<div class="telamoderacao">
<h1 class="bemvindo">Tela de Moderação</h1>
</div>
<!-- Footer -->
<footer class="py-5 bg-dark">
<div class="container">
<p class="m-0 text-center text-white">Desenvolvido por Alunos da USJT - Santana &copy; 2020</p>
</div>
<!-- /.container -->
</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>

	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>