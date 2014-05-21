<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="includes/header.jsp"/>


<section>

	<h1>Historique de mes commandes</h1>

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
							<th>Numéro de commande</th>
							<th>Date</th>
							<th>Statut</th>
							<th>Prix total</th>	
						</tr>
					</thead>
					<tbody>
					<c:set var="count" value="0" scope="page" />
	
					<c:forEach var="commande" items="${commandes}">
						<tr>
							<td><a href="Commande?details=${commande.idCommandeClient}">${commande.numCommandeClient}</a></td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${commande.dateCommandeClient}" /></td>
							<td>${commande.statutCommandeClient}</td>
							<td><fmt:formatNumber value="${total[count]}" type="currency" currencySymbol="&euro;"/></td>
								
						</tr>	
						<c:set var="count" value="${count + 1}" scope="page"/>
					</c:forEach>		
					</tbody>
				</table>
			</div>
		</div>	
	</div>
</section>	
	
<jsp:include page="includes/footer.jsp"/>