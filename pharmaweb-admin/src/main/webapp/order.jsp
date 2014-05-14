<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Détail de la commande</h1>
	
<div class="row">


	<div class="col-md-6">
	
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">Informations client</div>
	

  <!-- Table -->
	  <table class="table">
	  <tbody>
	   <tr>
		<td><b>N° client</b></td>
		<td>009</td>
	  </tr>
	  <tr>
		<td><b>Nom</b></td>
		<td>Mevetmont</td>
	  </tr>
	  <tr>
		 <td><b>Pr&eacute;nom</b></td>
		 <td>Jean-Phil</td>
	  </tr>
	  <tr>
		 <td><b>M&eacute;decin traitant</b></td>
		 <td>Gr&eacute;gory House</td>
	  </tr>
	  <tr>
		  <td><b>Date de naissance</b></td>
		  <td>10/02/1980</td>
	  </tr>
	  <tr>
		  <td><b>Téléphone</b></td>
		  <td>0610278949</td>
	  </tr>
	  <tr>
		  <td><b>Email</b></td>
		  <td>jpmevetmont@hotmail.com</td>
	  </tr>
	  <tr>
		  <td><b>Localité</b></td>
		  <td>Toulon</td>
	  </tr>
	  <tr>
		  <td><b>Allergies</b></td>
		  <td>
		  	<ul>
		  		<li>Crustac&eacute;s</li>
		  		<li>Cacahuetes</li>
		  	</ul>
		  </td>
	  </tr>  
	  </tbody>
	  </table>
	</div>
	
	</div>
	
	<div class="col-md-6">
		<div class="row">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nom produit</th>
					<th>Classe pharma</th>
					<th>Fabriquant</th>
					<th>N° de lot</th>
					<th>Sur ordonnance</th>
					<th>Prix unitaire</th>
					<th>Quantit&eacute;</th>
					<th>Prix total</th>	
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>DAFALGAN CODEINE</td>
					<td>Antalgiques</td>
					<td>Nom fabriquant</td>
					<td>0123</td>
					<td>OUI</td>
					<td>2,47 €</td>
					<td>2</td>
					<td>4,94 €</td>
					
				</tr>	
				
				<tr>
					<td>XANAX</td>
					<td>Neurologie</td>
					<td>Nom fabriquant</td>
					<td>0222</td>
					<td>OUI</td>
					<td>4 €</td>
					<td>1</td>
					<td>4 €</td>
					
				</tr>		
			</tbody>
		</table>
	</div>
			</div>
			<div class="row">
			<div class="col-sm-6 col-md-4">
			    <div class="thumbnail">
			      <img data-src="holder.js/300x200" alt="...">
			      <div class="caption">
			        <h3>DAFALGAN CODEINE</h3>
			        <p>DAFALGAN CODÉINE 500 mg/30 mg : comprimé pelliculé (blanc) ; boîte de 16 </br>
			       	   Excipient commun : Povidone </br>
			       	   Sur ordonnance - Remboursable à 65 % - Prix : 2,47 €.</p>
			        <p><a href="#" class="btn btn-primary" role="button">Notice</a> </p>
			      </div>
			    </div>
			  </div>
			</div>	
</div>
	

<div class ="row">
		<div class="text-right">
			<a href="" class="btn btn-default">Consulter l'ordonnance</a>
			<a href="#" class="btn btn-default" role="button">Contacter le client</a>
			<a href="Orders" class="btn btn-success">Valider la commande</a>
		</div>
</div>


</section>

<jsp:include page="includes/footer.jsp" />