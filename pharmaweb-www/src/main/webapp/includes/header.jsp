<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/fonts.css" type="text/css" rel="stylesheet" />
<link href="css/font-awesome.min.css" type="text/css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/styles.css" type="text/css" rel="stylesheet" />

<title>Pharmaweb</title>
</head>

<body>
	<div id="wrap">
		<div id="account">
				<div class="contentWrapper">
				
				<c:if test="${sessionScope.idClient != null}">
						<a href="Compte">MON COMPTE</a> 			
				</c:if>
				<c:if test="${sessionScope.idClient == null}">
						<a href="Connexion">CONNEXION</a>			
				</c:if>				
				 <a href="Panier"><i class="fa fa-shopping-cart"></i> MON PANIER</a>  
				</div>
		</div>
		<header id="full">
			<div class="contentWrapper">
			<a class="logo" href="Home">Pharmaweb</a>
			<div class="headersearch">
				<form action="Recherche" class="search" method="get" name="search">
					<label for="s" class="search-label"><span class="fa-search"></span></label>
					<input id="s" name="search" placeholder="Rechercher ..."
						type="text" />
				</form>
			</div>
			</div>
			<nav>
				<div class="contentWrapper">
					<a class="book" href="Catalog?cat=1">PHARMACIE</a> <a href="Catalog?cat=2">PARAPHARMACIE</a>
				</div>
			</nav>

		</header>

		<div id="main">