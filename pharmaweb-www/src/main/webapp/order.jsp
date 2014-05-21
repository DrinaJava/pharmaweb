<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<jsp:include page="includes/header.jsp"/>

<section>
	
	<h2>Commande n°${commande.numCommandeClient}</h2>

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
		<div class="panel panel-default">
			<div class="panel-body">
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
				<div class="text-right">
					<b>Total : ${totalht} €</b>
				</div>					
			</div>
		</div>
	</div>
</section>	
	
<jsp:include page="includes/footer.jsp"/>