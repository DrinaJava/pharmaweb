<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
    
<jsp:include page="includes/header.jsp"/>

<section>

	<h1>Contacter ce client</h1>
	  <p>Concernant la commande num&eacute;ro : 001 (DAFALGAN CODEINE, XANAX) du client Jean-Phil Mevetmont</p>
	
	<div class="row">
		<form class="form-horizontal" role="form">
			  <div class="form-group">
			
			    <label for="topic" class="col-sm-2 control-label">Objet :</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="topic" placeholder="Objet de la prise de contact">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="body" class="col-sm-2 control-label">Contenu du message :</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3"></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox"> Envoyer également ce message par email
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">Envoyer le message</button>
			    </div>
			  </div>
		</form>
	</div>
	
	
	
	
	
</section>	
	
<jsp:include page="includes/footer.jsp"/>