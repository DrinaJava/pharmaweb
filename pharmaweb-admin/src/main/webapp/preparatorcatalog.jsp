<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h4>Acces pr&eacute;parateur</h4>
	
	<div class="row">
		<div class="col-md-12">
			<div class="text-right">
			<a href="PreparatorCatalog?new=1" class="btn btn-success"> Nouveau m&eacute;dicament </a>
			</div>
		</div>
	</div>
	
	<div class="row">
	
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1> Stock de produits</h1>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Nom produit</th>
									<th>Fabriquant</th>
									<th>Description</th>
									<th>Classe Pharmaceutique</th>
									<th>TVA</th>
									<th>Taux de remboursement</th>
									<th>Requiert ordonnance</th>
									<th>Notice du produit</th>
									<th>Image du produit</th>
									<th>Edition</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="stockLine" items="${stockLines}">
								<tr>
									<td>
										${stockLine.nomProduit}
									</td>

									<td>
									${stockLine.nomFabriquantProduit}
									</td>
									<td>
									${stockLine.decriptionProduit}
									</td>
									<td>
									${stockLine.classePharmaceutique.libelleClassePharmaceutique}
									</td>
									<td>
									${stockLine.tva.tauxTva}
									</td>
									<td>
									${stockLine.typeDeRemboursement.libelleTypeDeRemboursement}
									</td>
									<td>
									<c:if test="${stockLine.requiereOrdonnanceProduit == 0}"> 
										<i class="fa fa-check-circle fa-2x"></i>
										</c:if>
										<c:if test="${stockLine.requiereOrdonnanceProduit == 1}"> 
										<i class="fa fa-times fa-2x"></i>
										</c:if> 
									</td>
																		<td>
										<a href="${stockLine.noticeProduit}">Lien vers la notice</a>
									</td>
									<td>
										<a href="${stockLine.imageProduit}">Lien vers l'image</a>
									</td>
									<td class="edit">
										<a href="PreparatorCatalog?edit=${stockLine.idProduit}"><i class="fa fa-pencil fa-2x"></i></a>
										<a href="PreparatorCatalog?del=${stockLine.idProduit}"><i class="fa fa-trash-o fa-2x"></i></a>
									</td>
									
								</tr>
							</c:forEach>
							</tbody>
						</table>
				</div>
			
			</div>
		</div>
	</div>
	
		<div class="row">
			<div class="col-md-12">
				<div class="text-right">
				<a href="PreparatorCatalog?new=1" class="btn btn-success"> Nouveau m&eacute;dicament </a>
				</div>
			</div>
		</div>
	


</section>

<jsp:include page="includes/footer.jsp" />