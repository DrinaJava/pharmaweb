<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<jsp:include page="includes/header.jsp"/>

<section>
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
					<td>€</td>
					<td>${cartline.quantite}</td>
					<td>€</td>
					
				</tr>	
			</c:forEach>		
			</tbody>
		</table>
</section>	
	
<jsp:include page="includes/footer.jsp"/>