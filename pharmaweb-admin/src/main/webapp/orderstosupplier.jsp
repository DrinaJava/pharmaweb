<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Commandes des pharmacies</h1>
	

	<div class="panel panel-default">
		<div class="panel-body">

			<table class="table table-striped" id="ordersTable">
				<thead>
					<tr>
						
						<th>N° de commande</th>
						<th>Pharmacie</th>
						<th><i class="fa fa-phone fa-2x"></i></th>
						<th>Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="commande" items="${commandesFournisseur}">
					<tr>
						
						<td>${commande.numCommandeFournisseur}</td>
						<td>${commande.pharmacie.nomPharmacie}</td>
						<td>${commande.pharmacie.telephonePharmacie}</td>
						<td>${commande.dateCommandeFournisseur}</td>
						<td class="orderToSupplierInfo"><a href="OrderToSupplier?info=${commande.idCommandeFournisseur}"><i
								class="fa fa-search-plus fa-2x"></i></a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	
	
	


</section>

<jsp:include page="includes/footer.jsp" />