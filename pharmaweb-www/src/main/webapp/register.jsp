<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<jsp:include page="includes/header.jsp" />

<section>

	${idClient}

	<form role="form" method="post">
	
			
		<div class="form-group">
			<label for="nom">Nom</label> 
			<input type="text" class="form-control" id="nom" name="nom">
		</div>

		<div class="form-group">
			<label for="prenom">Prénom</label> 
			<input type="text" class="form-control" id="prenom" name="prenom">
		</div>

		<div class="form-group">
			<label for="email">Adresse email</label> 
			<input type="email" class="form-control" id="email" name="email">
		</div>
		
		<div class="form-group">
			<label for="password">Mot de passe</label> 
			<input type="password" class="form-control" id="password" name="password">
		</div>
		
		<label for="classe">Statut</label>
		<select class="form-control" id="statut" name="statut">
			<c:forEach var="statut" items="${statuts}">
				<option value="${statut.idStatut}">${statut.libelleStatut}</option>
			</c:forEach>
		</select>
		<br>
		<div class="text-right">
			<button type="submit" class="btn btn-success">S'enregistrer</button>
		</div>
	</form>

</section>

<jsp:include page="includes/footer.jsp" />