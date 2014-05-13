<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Commandes en cours</h1>
	
		<div class="text-right">
			<a href="" class="btn btn-default">Tout cocher</a>
			<a href="Orders" class="btn btn-success">Valider la sélection</a>
		</div>
	

	<div class="panel panel-default">
		<div class="panel-body">

			<table class="table table-striped" id="ordersTable">
				<thead>
					<tr>
						<th>S&eacute;lection</th>
						<th>Client</th>
						<th>M&eacute;decin traitant</th>
						<th>Date</th>
						<th>N° de commande</th>
						<th>Quantit&eacute;</th>
						<th>Prix total</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="order" value="selected"></td>
						<td><a href="Client?infos">Jean-Phil Mevetmont</a></td>
						<td>Gr&eacute;gory House</td>
						<td>15/05/2014</td>
						<td>001</td>
						<td>7 Médicaments</td>
						<td>78euros</td>
						<td class="orderinfo"><a href="Order"><i
								class="fa fa-search-plus fa-2x"></i></a></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	
	
		<div class="text-right">
			<a href="" class="btn btn-default">Tout cocher</a>
			<a href="Orders" class="btn btn-success">Valider la sélection</a>
		</div>
	


</section>

<jsp:include page="includes/footer.jsp" />