<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="includes/header.jsp"/>


<section>

	<div class="panel panel-default">
		<div class="panel-body">
			
			<h1>Historique de mes commandes</h1>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Date</th>
						<th>Numéro de commande</th>
						<th>Statut</th>
						<th>Prix total</th>	
					</tr>
				</thead>
				<tbody>
				<c:forEach var="commande" items="${commandes}">
					<tr>
						<td>
						<fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${commande.dateCommandeClient}" /></td>
						<td>${commande.numCommandeClient}</td>
						<td>${commande.statutCommandeClient}</td>
						<td><fmt:formatNumber value="${total}" type="currency" currencySymbol="&euro;"/> €</td>
							
					</tr>	
				</c:forEach>		
				</tbody>
			</table>
				
	
		</div>
	</div>	

</section>	
	
<jsp:include page="includes/footer.jsp"/>