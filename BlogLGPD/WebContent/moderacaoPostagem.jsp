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
		<div class="wrap"></div>

		<div class="modal fade bs-example-modal-new" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">

			<div class="modal-dialog">

				<!-- Modal Content: begins -->
				<div class="modal-content">

					<!-- Modal Body -->
					<div class="modal-body">
						<div class="body-message">${post.id} ${post.autor}
							${post.titulo} ${post.texto} ${post.data}</div>
					</div>

					<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
					</div>

				</div>
				<!-- Modal Content: ends -->

			</div>

		</div>

		<div class="menu-postagem">
			<form class="divForm" action="DetalhePostagemServlet" method="post">
				<c:forEach var="post" items="${allPosts}">
					<div class="number">
						<c:if test="${post.referencia == 0}">
						${post.id} <a class="title"
								href="ExibirDetalhePostagem?&ID_POSTAGEM=${post.id }">${post.titulo}</a>
						</c:if>
						<c:if test="${post.referencia > 0}">
						${post.id} Resposta do post:
							<a class="title"
								href="ExibirDetalhePostagem?&ID_POSTAGEM=${post.id }">${post.titulo}</a>
						</c:if>
					</div>

					<a href="ExcluirPostagem?ID_POSTAGEM=${post.id}"
						class="btn btn-danger">Excluir</a>
					<c:if test="${post.exibir}">
						<a href="AlterarStatus?ID_POSTAGEM=${post.id}&EXIBIR=false"
							class="btn btn-warning">Bloquear</a>
					</c:if>
					<c:if test="${not post.exibir}">
						<a href="AlterarStatus?ID_POSTAGEM=${post.id}&EXIBIR=true"
							class="btn btn-success">Liberar</a>
					</c:if>
					<br>

				</c:forEach>

			</form>
		</div>

		<div id="actions" class="row">
			<div class="col-md-12 buttonvoltar">
				<input type="button" value="Voltar"
					onclick="openPage('moderacao.jsp')">
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

