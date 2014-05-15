<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/header.jsp" />

<section>

	<table class="table table-striped">
		<c:forEach var="medicine" items="${results}">
			<tr>
				<td>${medicine.nomProduit}</td>
				<td>${medicine.decriptionProduit}</td>
			</tr>
		</c:forEach>
	</table>


</section>

<jsp:include page="includes/footer.jsp" />