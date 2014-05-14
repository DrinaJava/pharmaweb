<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<jsp:include page="includes/header.jsp"/>

<section>
	<h1>&Eacute;dition d'un m&eacute;dicament</h1>

	<form role="form" method="post">
	
		<div class="form-group">
			<label for="name">Nom</label>
			<input type="text" class="form-control" id="name" name="name" value="${produit.nomProduit}">
		</div>
		
		<div class="form-group">
			<label for="manufacter">Fabricant</label> 
			<input type="text" class="form-control" id="manufacter"name="manufacter" value="${produit.nomFabriquantProduit}"/>
		</div>
		
		<div class="form-group">
			<label for="description">Description</label> 
			<textarea class="form-control" id="description"name="description">${produit.decriptionProduit}</textarea>
		</div>
		
		<label for="classe">Classe pharmaceutique</label>
		<select class="form-control" id="classe" name="classe">
			<c:forEach var="classe" items="${classes}">
				<option value="${classe.idClassePharmaceutique}">${classe.libelleClassePharmaceutique}</option>
			</c:forEach>
		</select>
	
	
		<label for="tva">TVA</label>
		<select class="form-control" id="tva" name="tva">
			<c:forEach var="tva" items="${tvas}">
				<option value="${tva.idTva}">${tva.tauxTva}</option>
			</c:forEach>
		</select>
		
		<label for="remboursement">Taux de remboursement</label>
		<select class="form-control" id="remboursement" name="remboursement">
			<c:forEach var="remboursement" items="${remboursements}">
				<option value="${remboursement.idTypeDeRemboursement}">${remboursement.libelleTypeDeRemboursement}</option>
			</c:forEach>
		</select>		
		
		<div class="checkbox">
			<label>
				<input type="checkbox" name="ordonance" value="1"> Uniquement sur ordonnace
			</label>
		</div>
		
		<div class="form-group">
			<label for="picture"></label> 
			<input type="file" id="picture">
			<p class="help-block">Photo du produit</p>
		</div>
		
		<div class="form-group">
			<label for="notice"></label> 
			<input type="file" id="notice">
			<p class="help-block">Notice du médicament</p>
		</div>	
		<input type="submit" class="btn btn-primary" value="Enregister"/>
		<a href="Medicines" class="btn btn-danger" >Annuler</a>
	</form>


</section>	
	
<jsp:include page="includes/footer.jsp"/>