<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de java, Android, Iphone, PHP, Ruby e muito mais - Casa do código</title>
</head>
<body>
<h1>Lista de Produtos</h1>
<div>${sucesso }</div>
<table>
<tr>
<td>Título</td>
<td>Descricao</td>
<td>Páginas</td>
</tr>
<c:forEach items="${produtos }" var="produto">
<tr>
<a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>

<td>${produto.titulo }</td>
<td>${produto.descricao }</td>
<td>${produto.paginas }</td>
</tr>
</c:forEach>
</table>
</body>
</html>