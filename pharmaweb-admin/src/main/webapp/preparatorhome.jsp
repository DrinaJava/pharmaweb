<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<script src="js/medicines.js" type="text/javascript"></script>

<section>
	<h1>Acces pr&eacute;parateur</h1>
	
	<div class="row">
	
		<div class="col-lg-3">
			<div class="navbar-default navbar-static-side" role="navigation">
				<div class="sidebar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Recherche"/>
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
									<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</li>
						<li>
						<a href="">
							Commande fournisseur
						</a>
						</li>
						<li>
						<a href="">
							Commandes client
						</a>
						</li>
						<li>
						<a href="">
							Gestion du catalogue
						</a>
						</li>
					
					</ul>
				</div>
			</div>
		</div>
	
	</div>	
	


</section>

<jsp:include page="includes/footer.jsp" />