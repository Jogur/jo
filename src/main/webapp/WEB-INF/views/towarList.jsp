<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista towarow</title>
</head>
<body>
	<h1>
		Lista towarow
	</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Cena</th>
			<th>Typ</th>
			<th>Pojemność</th>
			<th>Dostępny</th>
			
			<sec:authorize access="hasRole('ROLE_USER')">
				<th>Kup</th>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_DEALER')">
				<th>Edytuj</th>
			</sec:authorize>
		</tr>
		<c:forEach var="towar" items="${towary}">
				<tr>
					<td align="center">${towar.id}</td>
					<td align="center">${towar.nazwa}</td>
					<td align="center">${towar.opis}</td>
					<td align="center">${towar.cena}</td>
					<td align="center">${towar.typ}</td>
					<td align="center">${towar.pojemnosc}</td>
					<td align="center">
					<c:choose>
					    <c:when test="${towar.dostepnosc}">
					        TAK
					    </c:when>
					    <c:otherwise>
					        NIE
					    </c:otherwise>
					</c:choose>
					</td>
					<sec:authorize access="hasRole('ROLE_USER')">
						<td><a href="/jo/kupTowar?id=${towar.id}">Kup</a></td>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_DEALER')">
						<td>Edytuj</td>
						<td><a href="/jo/usunTowar?id=${towar.id}&temp=1">Usun</a></td>
					</sec:authorize>
					
				</tr>
		</c:forEach>
	</table>

	<sec:authorize access="hasRole('ROLE_DEALER')">
		<div>
			<a href="/jo/towarForm"><button>Dodaj towar </button></a>
		</div>
	</sec:authorize>



	<div>
		<a href="/jo"><button>Strona glowna </button></a>
	</div>

<script>
function showFormDodaj() {
	document.getElementById("towarForm").style.display = "block";
}

</script>
</body>
</html>