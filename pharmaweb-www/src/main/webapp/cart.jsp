<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<jsp:include page="includes/header.jsp"/>

<section>

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
		</div>
	</div>	
	<div class="text-right">
		 <a href="Commander?etape=livraison" class="btn btn-success">Continuer ma commande</a>
	</div>
</section>	
	
<jsp:include page="includes/footer.jsp"/>