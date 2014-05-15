<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<jsp:include page="includes/header.jsp"/>

<section>
	<h1>MÉDICAMENTS</h1>
</section>	

<div class="row">

	<div class="col-md-3">
	
		<div class="panel panel-default">
		  <div class="panel-heading">
		    <h3 class="panel-title">Catégories</h3>
		  </div>
		  <div class="panel-body">
		  <ul></ul>
		  </div>
		</div>
	
	</div>
	<div class="col-md-9">
		<div class="row">
		<div class="text-center">
			<ul class="pagination">
				<li><a href="">«</a></li>
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">»</a></li>
			</ul>
		</div>
		</div>
		<div class="row">
		<c:forEach var="produit" items="${produits}">
			<div class="col-6 col-sm-6 col-lg-4">
				<h2>${produit.nomProduit}</h2>
				<img src="${produit.imageProduit}" alt="${produit.nomProduit}">
				<p>${produit.decriptionProduit} </p>
				<p>${produit.nomFabriquantProduit}</p>
				<p>${produit.classePharmaceutique.libelleClassePharmaceutique}</p>
				<p>${produit.classePharmaceutique.classePharmaceutique.libelleClassePharmaceutique}</p>
				<p><a class="btn btn-sm btn-default" href="#" role="button"> <i class="fa fa-plus-circle fa-2x"> </i> Ajouter au panier</a>
				<a class="btn btn-sm btn-default" href="${produit.noticeProduit}" role="button"> <i class="fa fa-file-text fa-2x"> </i> Voir notice</a></p>
			</div>
		</c:forEach>
		</div>
		
	</div>

</div>
	
<jsp:include page="includes/footer.jsp"/>