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

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<form action="DetalhePostagemServlet" method="post">
		<c:forEach var="post" items="${allPosts}">
    
${post.id}
<a href="ExibirDetalhePostagem?&ID_POSTAGEM=${post.id }">${post.titulo}</a>

<a href="ExcluirPostagem?ID_POSTAGEM=${post.id}" class="btn btn-primary">Excluir</a>
<a href="AlterarStatus?ID_POSTAGEM=${post.id}&EXIBIR=true" class="btn btn-primary">Liberar</a>
<a href="AlterarStatus?ID_POSTAGEM=${post.id}&EXIBIR=false" class="btn btn-primary">Bloquear</a>
<br>

</c:forEach>
	</form>

</body>

</html>

