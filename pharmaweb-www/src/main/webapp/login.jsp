<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<section class="login">
	<c:if test="${message != null}">
		<div class="alert alert-${message.style}">
			<c:out value="${message.text}"></c:out>
		</div>
	</c:if>

	<form role="form" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Nom d'utilisateur</label> <input
				type="text" class="form-control" name="username">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Mot de passe</label> <input
				type="password" class="form-control" name="password">
		</div>

		<div class="text-right">
			<a href="Inscription">M'inscrire</a>
			<input type="submit" class="btn btn-success" value="Se connecter" />
		</div>
	</form>
</section>
<jsp:include page="includes/footer.jsp" />