<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uzytkownicy</title>
</head>
<body>
	<h1>
		Uzytkownicy apteki
	</h1>
	<table border="1">
		<tr>
			<th>Login</th>
			<th>Hasło</th>
			<th>Email</th>
			<th>Imie</th>
			<th>Nazwisko</th>
		</tr>
		<c:forEach var="uzytownik" items="${uzytkownicy}">
				<tr>
					<td align="center">${uzytownik.login}</td>
					<td align="center">${uzytownik.haslo}</td>
					<td align="center">${uzytownik.email}</td>
					<td align="center">${uzytownik.imie}</td>
					<td align="center">${uzytownik.nazwisko}</td>
				</tr>
		</c:forEach>
	</table><br />
</body>
</html>