<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<jsp:include page="includes/header.jsp" />

<section>

	<c:if test="${param.etape == 'livraison' }">

		<h1>Livraison</h1>
	
		<h3>Adresse de facturation</h3>
		<p>${client.nomClient} ${client.prenomClient}</p>
		<p>${client.adresse.adresseAdresse}</p>
		<p>${client.adresse.codePostalAdresse} ${client.adresse.villeAdresse}</p>
		
		
		<h3>Point de retrait</h3>
		<p></p>
		<p></p>
		<p></p>
		
		<div class="text-right">
			<a href="Commander?etape=recapitulatif" class="btn btn-success">Continuer</a>
		</div>
	</c:if>
	
	<c:if test="${param.etape == 'recapitulatif' }">	
		<h1>Récapitulatif de la commande</h1>
		
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nom produit</th>
				<th>Prix unitaire</th>
				<th>Quantit&eacute;</th>
				<th>Prix total</th>	
			</tr>
		</thead>
		<tbody>
		<c:forEach var="line" items="${produits}">
			<tr>
				<td>${line.lotProduit.produit.nomProduit}</td>
				<td>${line.prixUnitaireProduitCommande} €</td>
				<td>${line.quantiteCommande}</td>
				<td>${line.prixUnitaireProduitCommande * line.quantiteCommande} €</td>
				
			</tr>	
		</c:forEach>		
		</tbody>
	</table>
		
		<a href="Commander?etape=fin" class="btn btn-success">Continuer</a>
	</c:if>
	
	<c:if test="${param.etape == 'paiement' }">

		<h1>Paiement</h1>
	
		<h3>Mode de paiement</h3>
		
		<form role="form" method="post" action="Commander?etape=fin">

			<div class="radio">
			  <label>
			    <input type="radio" name="paiement" id="paiement" value="pharmacie" checked>
			    Paiement au retrait
			  </label>
			</div>
			<div class="radio">
			  <label>
			    <input type="radio" name="paiement" id="paiement" value="carte">
			    Paiement en ligne par carte bancaire
			  </label>
			</div>			
			<div class="radio">
			  <label>
			    <input type="radio" name="paiement" id="paiement" value="paypal">
			    Paiement en ligne avec PayPal
			  </label>
			</div>
		  <button type="submit" class="btn btn-default">Continuer</button>
		</form>

	</c:if>
	
	<c:if test="${param.etape == 'fin' }">	
		<h1>Commande terminée</h1>
		
		<div class="alert alert-success">Votre commande à bien été prise en compte.
		 Vous pouvez retrouvez votre commande dans la page <a href="Compte">Mon Compte</a></div>
	</c:if>

</section>

<jsp:include page="includes/footer.jsp" />