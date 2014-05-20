<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<jsp:include page="includes/header.jsp"/>

<section>
	<h1>Pharmacies</h1>
	
		<div class="panel panel-default">
		<div class="panel-body">

			<table class="table table-striped" id="pharmacyTable">
				<thead>
					<tr>
						
						<th>Nom</th>
						<th><i class="fa fa-phone fa-2x"></i></th>
						<th>Mail</th>
						<th>Adresse</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="pharmacie" items="${pharmacies}">
					<tr>
						
						<td>${pharmacie.nomPharmacie}</td>
						<td>${pharmacie.telephonePharmacie}</td>
						<td>${pharmacie.mailPharmacie}</td>
						<td>${pharmacie.adresse.adresseAdresse} ${pharmacie.adresse.complementAdresse} ${pharmacie.adresse.codePostalAdresse} ${pharmacie.adresse.villeAdresse}</td>
						<td class="pharmacyInfo"><a href="Pharmacy?info=${pharmacie.idPharmacie}"><i
								class="fa fa-search-plus fa-2x"></i></a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</section>	
	
<jsp:include page="includes/footer.jsp"/>