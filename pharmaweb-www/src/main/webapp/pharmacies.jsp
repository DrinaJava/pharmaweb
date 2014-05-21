<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
    
<jsp:include page="includes/header.jsp"/>

<section>
	<ul>
		<c:forEach var="pharmacie" items="${pharmacies}">
			<li><a href="Pharmacies?pharmacie=${pharmacie.idPharmacie}">${pharmacie.nomPharmacie}</a></li>
		</c:forEach>
	</ul>
</section>	
	
<jsp:include page="includes/footer.jsp"/>