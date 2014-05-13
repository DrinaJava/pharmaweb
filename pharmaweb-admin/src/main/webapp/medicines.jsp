<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Médicaments</h1>

	<div class="text-right">
		<a href="Medicine" class="btn btn-success">Nouveau médicament</a>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">

			<table class="table table-striped" id="medicinesTable">
				<thead>
					<tr>
						<th>Column 1</th>
						<th>Column 3</th>
						<th>&Eacute;dition</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a href="Medicine?edit=0">Row 1 Data 1</a></td>
						<td>Row 1 Data 2</td>
						<td class="edit"><a href="Medicine?edit=0"><i
								class="fa fa-pencil fa-2x"></i></a> <a href="Medicine?del=0"><i
								class="fa fa-trash-o fa-2x"></i></a></td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>

	<div class="text-right">
		<a href="Medicine" class="btn btn-success">Nouveau médicament</a>
	</div>

</section>

<jsp:include page="includes/footer.jsp" />