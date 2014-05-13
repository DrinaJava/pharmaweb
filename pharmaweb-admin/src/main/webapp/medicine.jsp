<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<jsp:include page="includes/header.jsp"/>

<section>
	<h1>&Eacute;dition d'un m&eacute;dicament</h1>

	<form role="form">
	
		<div class="form-group">
			<label for="name">Nom</label>
			<input type="text" class="form-control" id="name" name="name">
		</div>
		
		<div class="form-group">
			<label for="manufacter">Fabricant</label> 
			<input type="text" class="form-control" id="manufacter"name="manufacter"/>
		</div>
		
		<div class="form-group">
			<label for="description">Description</label> 
			<textarea class="form-control" id="description"name="description"></textarea>
		</div>
		
		<label for="classe">Classe pharmaceutique</label>
		<select class="form-control" id="classe" name="classe">
		</select>
		
		<div class="checkbox">
			<label>
				<input type="checkbox" name="ordonance"> Uniquement sur ordonnace
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
		<input type="submit" class="btn btn-danger" value="Annuler"/>
	</form>


</section>	
	
<jsp:include page="includes/footer.jsp"/>