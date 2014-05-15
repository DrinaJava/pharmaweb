<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Détail de la commande n° ${commande.numCommandeFournisseur}</h1>
	
<div class="row">


	<div class="col-md-6">
	
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">Pharmacie cliente</div>
	

  <!-- Table -->
	  <table class="table">
	  <tbody>
	  <tr>
		<td><b>Nom</b></td>
		<td>${commande.pharmacie.nomPharmacie}</td>
	  </tr>
	  <tr>
		  <td><b>Téléphone</b></td>
		  <td>${commande.pharmacie.telephonePharmacie}</td>
	  </tr>
	  <tr>
		  <td><b>Email</b></td>
		  <td>${commande.pharmacie.mailPharmacie}</td>
	  </tr>
	  <tr>
		  <td><b>Adresse</b></td>
		  <td>${commande.pharmacie.adresse.adresseAdresse} ${commande.pharmacie.adresse.complementAdresse}</td>
	  </tr>
	  <tr>
		  <td><b>CP</b></td>
		  <td>${commande.pharmacie.adresse.codePostalAdresse}</td>
	  </tr> 
	  <tr>
		  <td><b>Ville</b></td>
		  <td>${commande.pharmacie.adresse.villeAdresse}</td>
	  </tr>  
	  </tbody>
	  </table>
	</div>
	
	</div>
	
	<div class="col-md-6">
		<div class="row">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom produit</th>
					<th>Classe pharma</th>
					<th>TVA</th>
					<th>Quantit&eacute;</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="ligneCommande" items="${lignesCommande}">
				<tr>
					<td>${ligneCommande.lotProduit.produit.nomProduit}</td>
					<td>${ligneCommande.lotProduit.produit.classePharmaceutique.libelleClassePharmaceutique}</td>
					<td>${ligneCommande.tvaFournisseur}</td>
					<td>${ligneCommande.quantite}</td>	
				</tr>	
			</c:forEach>		
			</tbody>
		</table>
	</div>
</div>
			
	

<div class ="row">
		<div class="text-right">
			<a href="OrdersToSupplier" class="btn btn-success">Valider la commande</a>
		</div>
</div>


</section>

<jsp:include page="includes/footer.jsp" />