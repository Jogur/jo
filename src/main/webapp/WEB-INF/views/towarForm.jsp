<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj Towar</title>
</head>
<body>
	<h1>
		Dodaj towar :)
	</h1>
	
	<div>
	<form:form method="POST" action="towarDodajAction">
	   <table border="1">
	    <tr>
	        <td><form:label path="nazwa">nazwa</form:label></td>
	        <td><form:input path="nazwa" required="true"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="cena">cena</form:label></td>
	        <td><form:input path="cena" required="true"/></td>
	    </tr>
	    <tr>
	        <td><form:label path="typ">Typ</form:label></td>
	        <td><form:input path="typ" required="true"/></td> 
	    </tr>
	     <tr>
	        <td><form:label path="pojemnosc">Pojemnosc</form:label></td>
	        <td><form:input path="pojemnosc" required="true" /></td> 
	    </tr>
	    <tr>
	        <td><form:label path="opis">opis</form:label></td>
	        <td><form:input path="opis" /></td> 
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