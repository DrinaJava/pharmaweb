<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<jsp:include page="includes/header.jsp"/>

<section>
	<h1>&Eacute;dition du stock</h1>

<c:if test="${param.edit != null}">
	<table class="table table-striped">
		<tr>
			<th>Référence</th>
			<th>Prix Unitaire HT</th>
			<td>Quantité en stock</td>
			<td>Date d'expiration</td>
		</tr>
		<c:forEach var="stock" items="${stocks}">
			<tr>
				<td><a href="PreparatorCatalog?edit=${stock.lotProduit.produit.idProduit}&lot=${stock.lotProduit.idLotProduit}">
				${stock.lotProduit.numLotProduit}</a></td>
				<td>${stock.prixUnitaireProduit}</td>
				<td>${stock.quantiteStockProduit}</td>
				<td>${stock.lotProduit.dateExpirationLotProduit}</td>
			</tr>
		</c:forEach>
		
	</table>

	<form role="form" method="post">
	
		<h3>Edition d'un lot</h3>
		
		<div class="form-group">
			<label for="numlot">Numéro du lot</label> 
			<input type="text" class="form-control" id="numlot"name="numlot" value="${stock.lotProduit.numLotProduit}"/>
		</div>
		
		<div class="form-group">
			<label for="puht">Prix Unitaire HT</label> 
			<input type="text" class="form-control" id="puht"name="puht" value="${stock.prixUnitaireProduit}"/>
		</div>	
			
		<div class="form-group">
			<label for="qte">Quantité en stock</label> 
			<input type="text" class="form-control" id="qte"name="qte" value="${stock.quantiteStockProduit}"/>
		</div>	
		<div class="form-group">
			<label for="prixachat">Prix d'achat</label> 
			<input type="text" class="form-control" id="prixachat"name="prixachat" value="${stock.lotProduit.prixDAchatLotProduit}"/>
		</div>	
		<div class="form-group">
			<label for="expiredate">Date d'expiration</label> 
			<input type="text" class="form-control" id="expiredate"name="expiredate" value="${stock.lotProduit.dateExpirationLotProduit}"/>
		</div>	
				
		<input type="submit" class="btn btn-primary" value="Enregister"/>
		<a href="PreparatorCatalog" class="btn btn-danger" >Annuler</a>
	</form>
</c:if>
<c:if test="${param.edit == null}">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Ajout médicament</h3>
		</div>
		<div class="panel-body">
			<form method="post">

				<div class="form-group">
				<label for="produit">Produit</label> 
					<select id="produit" name="produit">
						<c:forEach var="produit" items="${produits}">
							<option value="${produit.idProduit}">${produit.nomProduit}</option>
						</c:forEach>
					</select>
				</div>	
				
				<div class="form-group">
					<label for="numlot">Numéro du lot</label> 
					<input type="text" class="form-control" id="numlot"name="numlot" value="${stock.lotProduit.numLotProduit}"/>
				</div>
				
				<div class="form-group">
					<label for="puht">Prix Unitaire HT</label> 
					<input type="text" class="form-control" id="puht"name="puht" value="${stock.prixUnitaireProduit}"/>
				</div>	
					
				<div class="form-group">
					<label for="qte">Quantité en stock</label> 
					<input type="text" class="form-control" id="qte"name="qte" value="${stock.quantiteStockProduit}"/>
				</div>	
				<div class="form-group">
					<label for="prixachat">Prix d'achat</label> 
					<input type="text" class="form-control" id="prixachat"name="prixachat" value="${stock.lotProduit.prixDAchatLotProduit}"/>
				</div>	
				<div class="form-group">
					<label for="expiredate">Date d'expiration</label> 
					<input type="text" class="form-control" id="expiredate"name="expiredate" value="${stock.lotProduit.dateExpirationLotProduit}"/>
				</div>				
				
				<input type="submit" class="btn btn-primary" value="Enregister"/>
				<a href="PreparatorCatalog" class="btn btn-danger">Annuler</a>
			</form>
		</div>
	</div>
</c:if>
</section>	
	
<jsp:include page="includes/footer.jsp"/>
