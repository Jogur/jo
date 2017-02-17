<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uzytkownicy</title>
</head>
<body>
	<h1>
		Zarejtruj się :)
	</h1>
	
	<div>
	<form:form method="POST" action="rejestracjaAction">
	   <table border="1">
	    <tr>
	        <td><form:label path="login">Login</form:label></td>
	        <td><form:input path="login" required="true"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="haslo">Hasło</form:label></td>
	        <td><form:input type="password" path="haslo" required="true"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="email">Email</form:label></td>
	        <td><form:input type="email" path="email" required="true"/></td>
	    </tr>
		<tr>
	        <td><form:label path="imie">Imie</form:label></td>
	        <td><form:input path="imie" required="true" /></td>
	    </tr>
	   	<tr>
	        <td><form:label path="nazwisko">Nazwisko</form:label></td>
	        <td><form:input path="nazwisko" required="true"/></td>
	    </tr>
	    <tr>
	    	<td><a href="/jo"><button>Menu główne</button></a></td>
	        <td ><input type="submit" value="Dodaj"/></td>
	    </tr>
		</table>  
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form:form>
	</div>
</body>
</html>