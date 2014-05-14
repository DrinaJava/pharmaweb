<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Boite de réception</h1>
	
		<div class="text-right">
			<a href="" class="btn btn-default">Tout cocher</a>
			<a href="Orders" class="btn btn-primary">Marquer comme lu</a>
			<a href="Orders" class="btn btn-warning">Archiver</a>
			<a href="Orders" class="btn btn-danger">Supprimer</a>
			
		</div>
	

	<div class="panel panel-default">
		<div class="panel-body">

			<table class="table table-striped" id="ordersTable">
				<thead>
					<tr>
						<th>S&eacute;lection</th>
						<th>Client</th>
						<th>N° Commande</th>
						<th>Objet</th>
						<th>Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="order" value="selected"></td>
						<td><a href="Client?infos">Jean-Phil Mevetmont</a></td>
						<td>001</td>
						<td>DAFALGAN = CODOLIPRANE ?</td>
						<td>15/05/2014</td>
						<td class="orderinfo"><a href="Order"><i
								class="fa fa-search-plus fa-2x"></i></a></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
	
	
		<div class="text-right">
			<a href="" class="btn btn-default">Tout cocher</a>
			<a href="Orders" class="btn btn-primary">Marquer comme lu</a>
			<a href="Orders" class="btn btn-warning">Archiver</a>
			<a href="Orders" class="btn btn-danger">Supprimer</a>
			
		</div>
	


</section>

<jsp:include page="includes/footer.jsp" />