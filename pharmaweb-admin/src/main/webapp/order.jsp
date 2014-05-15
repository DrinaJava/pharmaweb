<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Détail de la commande n° ${commande.numCommandeClient}</h1>
	
<div class="row">


	<div class="col-md-6">
	
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">Informations client</div>
	

  <!-- Table -->
	  <table class="table">
	  <tbody>
	   <tr>
		<td><b>N° client</b></td>
		<td>${commande.client.numeroClient}</td>
	  </tr>
	  <tr>
		<td><b>Nom</b></td>
		<td>${commande.client.nomClient}</td>
	  </tr>
	  <tr>
		 <td><b>Pr&eacute;nom</b></td>
		 <td>${commande.client.prenomClient}</td>
	  </tr>
	  <tr>
		 <td><b>M&eacute;decin traitant</b></td>
		 <td>${commande.client.medecin.nomMedecin} ${commande.client.medecin.prenomMedecin}</td>
	  </tr>
	  <tr>
		  <td><b>Date de naissance</b></td>
		  <td>${commande.client.dateNaissanceClient}</td>
	  </tr>
	  <tr>
		  <td><b>N° de sécurité sociale</b></td>
		  <td>${commande.client.numeroSecuClient}</td>
	  </tr>
	  <tr>
		  <td><b>N° d'adhérent mutuelle</b></td>
		  <td>${commande.client.numeroAdherentMutuClient}</td>
	  </tr>
	  <tr>
		  <td><b>Téléphone</b></td>
		  <td>${commande.client.numeroTelClient}</td>
	  </tr>
	  <tr>
		  <td><b>Email</b></td>
		  <td>${commande.client.mailClient}</td>
	  </tr>
	  <tr>
		  <td><b>Localité</b></td>
		  <td>${commande.client.adresse.ville}</td>
	  </tr>
	  <tr>
		  <td><b>Allergies</b></td>
		  <td>${commande.client.allergiesConnuesClient}</td>
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
					<th>Fabriquant</th>
					<th>N° de lot</th>
					<th>Sur ordonnance</th>
					<th>Prix unitaire</th>
					<th>Quantit&eacute;</th>
					<th>Prix total</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach var="ligneCommande" items="${lignesCommande}">
				<tr>
					<td>${ligneCommande.lotProduit.produit.nomProduit}</td>
					<td>${ligneCommande.lotProduit.produit.classePharmaceutique.libelleClassePharmaceutique}</td>
					<td>${ligneCommande.lotProduit.produit.nomFabriquantProduit}</td>
					<td>${ligneCommande.lotProduit.numLotProduit}</td>
					<td>
					<c:if test="${ligneCommande.lotProduit.produit.requiereOrdonnanceProduit == 0}"> 
					<i class="fa fa-check-circle fa-2x"></i>
					</c:if>
					<c:if test="${ligneCommande.lotProduit.produit.requiereOrdonnanceProduit == 1}"> 
					<i class="fa fa-circle fa-2x"></i>
					</c:if>
					</td>
					<td>${ligneCommande.prixUnitaireProduitCommande}</td>
					<td>${ligneCommande.quantiteCommande}</td>
					<td>${ligneCommande.prixUnitaireProduitCommande * ligneCommande.quantiteCommande}</td>
					
				</tr>	
			</c:forEach>		
			</tbody>
		</table>
	</div>
			</div>
			<div class="row">
			<div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			    <c:forEach var="ligneCommande" items="${lignesCommande}">
			    <div class="row">
			      <img data-src="${ligneCommande.lotProduit.produit.imageProduit}" alt="${ligneCommande.lotProduit.produit.nomProduit}">
			      <div class="caption">
			        <h3>${ligneCommande.lotProduit.produit.nomProduit}</h3>
			        <p>${ligneCommande.lotProduit.produit.decriptionProduit} </br>
			       	  Fabriqué par ${ligneCommande.lotProduit.produit.nomFabriquantProduit} </br>
			       	  ${ligneCommande.lotProduit.produit.classePharmaceutique.libelleClassePharmaceutique}</p>
			        <p><a href="${ligneCommande.lotProduit.produit.noticeProduit}" class="btn btn-primary" role="button">Notice</a> </p>
			       </div>
			      </div>
			     </c:forEach>
			    </div>
			  </div>
			</div>	
</div>
	

<div class ="row">
		<div class="text-right">
			<a href="" class="btn btn-default">Consulter l'ordonnance</a>
			<a href="#" class="btn btn-default" role="button">Contacter le client</a>
			<a href="Orders" class="btn btn-success">Valider la commande</a>
		</div>
</div>


</section>

<jsp:include page="includes/footer.jsp" />