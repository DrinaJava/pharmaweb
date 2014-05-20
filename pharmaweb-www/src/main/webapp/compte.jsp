<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
    
<jsp:include page="includes/header.jsp"/>

<section>
	<h1>Mon compte</h1>
	
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Catégories</h3>
			</div>
			<div class="panel-body">
				<ul>
					<li><a href="Compte">Information personnelles</a></li>
					<li><a href="Commandes">Historique des commandes</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-md-8">	
		<form role="form" method="post">
		
				
			<div class="form-group">
				<label for="nom">Nom</label> 
				<input type="text" class="form-control" id="nom" name="nom" value="${client.nomClient}">
			</div>
	
			<div class="form-group">
				<label for="prenom">Prénom</label> 
				<input type="text" class="form-control" id="prenom" name="prenom" value="${client.prenomClient}">
			</div>
			<div class="form-group">
				<label for="telephone">Téléphone</label> 
				<input type="text" class="form-control" id="telephone" name="telephone" value="${client.numeroTelClient}">
			</div>
			
			
			<div class="form-group">
				<label for="adresse">Adresse</label> 
				<input type="text" class="form-control" id="adresse" name="adresse" value="${client.adresse.adresseAdresse}">
			</div>
			
			<div class="form-group">
				<label for="adresse">Complément d'adresse</label> 
				<textarea class="form-control" id="adresse2" name="adresse2"></textarea>
			</div>
			
			<div class="form-group">
				<label for="codePostal">Code Posal</label> 
				<input type="text" class="form-control" id="codePostal" name="codePostal"  value="${client.adresse.codePostalAdresse}">
			</div>
			
			<div class="form-group">
				<label for="ville">Ville</label> 
				<input type="text" class="form-control" id="ville" name="ville"  value="${client.adresse.villeAdresse}">
			</div>
			
			
			<div class="form-group">
				<label for="email">Adresse email</label> 
				<input type="email" class="form-control" id="email" name="email" value="${client.mailClient}">
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
				<button type="submit" class="btn btn-success">Enregistrer</button>
			</div>
		</form>
	</div>
</section>	
	
<jsp:include page="includes/footer.jsp"/>