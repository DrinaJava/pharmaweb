<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Détail de la ${pharmacie.nomPharmacie}</h1>
	
<div class="row">


	<div class="col-md-12">
	
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">Informations de l'établissement</div>
	

  <!-- Table -->
	  <table class="table">
	  <tbody>
	   <tr>
		<td><b>Nom</b></td>
		<td>${pharmacie.nomPharmacie}</td>
	  </tr>
	  <tr>
		<td><b>Mail</b></td>
		<td>${pharmacie.mailPharmacie}</td>
	  </tr>
	  <tr>
		 <td><b>N° de t&eacute;l&eacute;phone</b></td>
		 <td>${pharmacie.telephonePharmacie}</td>
	  </tr>
	  <tr>
		 <td><b>Adresse</b></td>
		 <td>${pharmacie.adresse.adresseAdresse}</td>
	  </tr>
	  <tr>
		  <td><b>Adresse 2</b></td>
		  <td>${pharmacie.adresse.complementAdresse}</td>
	  </tr>
	  <tr>
		  <td><b>Code Postal</b></td>
		  <td>${pharmacie.adresse.codePostalAdresse}</td>
	  </tr>
	  <tr>
		  <td><b>Commune</b></td>
		  <td>${pharmacie.adresse.villeAdresse}</td>
	  </tr>
	   <tr>
		  <td><b>Employés de cette pharmacie :</b></td>
			<td>
				<ul>
					<c:forEach var="employe" items="${employes}">	
						<c:if test="${employe.statutEmploye == 0}">
						<li>Pharmacien</li>
						</c:if>
						<c:if test="${employe.statutEmploye != 0}">
						<li>Pr&eacute;parateur</li>
						</c:if>
					</c:forEach>
				</ul>
			</td>
	  </tr>
	  <tr>
		  <td><b>Stock</b></td>
			<td>
				<ul>
					<c:forEach var="stockLine" items="${stockLines}">
						<li>${stockLine.lotProduit.produit.nomProduit} par ${stockLine.lotProduit.produit.nomFabriquantProduit} / Quantité : ${stockLine.quantiteStockProduit}</li>
					</c:forEach>
				</ul>
			</td>
	  </tr>
	  </tbody>
	  </table>
	</div>
	
	</div>
</div>
	




</section>

<jsp:include page="includes/footer.jsp" />