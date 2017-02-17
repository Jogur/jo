<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista samochodow</title>
</head>
<body>
	<h1>
		Lista samochodow
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
				</tr>
		</c:forEach>
	</table><br />
</body>
</html>