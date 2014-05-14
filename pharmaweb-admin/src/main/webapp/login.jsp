<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<title>Administration Pharmaweb</title>
</head>
<body>

	<div class="panel panel-default loginForm">
		<div class="panel-body">


			<c:if test="${not empty message}">
				<div class="alert alert-danger">
					<c:out value="${message}"></c:out>
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

				<input type="submit" class="btn btn-primary" value="Se connecter" />
			</form>
		</div>
	</div>

</body>
</html>