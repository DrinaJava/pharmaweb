<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<jsp:include page="includes/header.jsp"/>

<section>

	<div class="panel panel-default">
		<div class="panel-body">
			
			<c:if test="${isempty}">
				<p>Votre panier est vide</p>
			</c:if>
			<c:if test="${not isempty}">
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
					<c:forEach var="cartline" items="${panier}">
						<tr>
							<td>${cartline.produit.nomProduit}</td>
							<td>${cartline.puht} €</td>
							<td>${cartline.quantite}</td>
							<td>${cartline.puht * cartline.quantite} €</td>
							
						</tr>	
					</c:forEach>		
					</tbody>
				</table>
				<div class="text-right">
					<b>Total : ${totalht} €</b>
				</div>					
			</c:if>	
	
		</div>
	</div>	
	<div class="text-right">
		<c:if test="${not isempty}"> 			
			<a href="Panier?vider=vider" class="btn btn-default">Vider mon panier</a>
			<a href="Commander?etape=livraison" class="btn btn-success">Continuer ma commande</a>
		</c:if>
		
	</div>
</section>	
	
<jsp:include page="includes/footer.jsp"/>