<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Commandes en cours</h1>
	

	<div class="panel panel-default">
		<div class="panel-body">

			<table class="table table-striped" id="ordersTable">
				<thead>
					<tr>
						
						<th>N° de commande</th>
						<th>Client</th>
						<th>M&eacute;decin traitant</th>
						<th>Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="commande" items="${commandes}">
					<tr>
						
						<td>${commande.numCommandeClient}</td>
						<td><a href="Client?infos">${commande.client.nomClient}</a></td>
						<td>${commande.client.medecin.nomMedecin}</td>
						<td>${commande.client.dateNaissanceClient}</td>
						<td class="orderinfo"><a href="Order?info=${commande.idCommandeClient}"><i
								class="fa fa-search-plus fa-2x"></i></a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	
	
	


</section>

<jsp:include page="includes/footer.jsp" />