<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transakcje</title>
</head>
<body>
	<h1>
		Transakcje
	</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Marka</th>
			<th>Model</th>
		</tr>
		<c:forEach var="transakcja" items="${transakcje}">
				<tr>
					<td align="center"></td>
					<td align="center"></td>
					<td align="center"></td>
				</tr>
		</c:forEach>
	</table><br />
</body>
</html>