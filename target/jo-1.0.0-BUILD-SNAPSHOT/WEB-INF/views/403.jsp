<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error 403</title>
</head>
<body>

	<h1>HTTP Status 403 - Odmowa dostępu</h1>

	<c:choose>
		<c:when test="${empty login}">
		  <h2>Nie masz dostępu do tej strony!</h2>
		</c:when>
		<c:otherwise>
		  <h2>User : ${login} <br/>
                    Nie masz dostępu do tej strony!</h2>
		</c:otherwise>
	</c:choose>
	<a href="/jo"><button type="button">Homepage</button></a>
</body>
</html>