<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@page session="true"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>

	<div>
		<button onclick="showSection(1)">Sprzedawcy</button>
		<button onclick="showSection(2)">Towary</button>
		<button onclick="showSection(3)">Uzytkownicy</button>
		<button onclick="showSection(4)">Nowy sprzedawca</button>
	</div>
	
	<div id="sprzedawcy" style="display: none;">
		<table border="1">
		<tr>
			<th>Imie</th>
			<th>Naywisko</th>
			<th>Email</th>
			<th>Usun</th>
		</tr>
		<c:forEach var="sprzedawca" items="${sprzedawcy}">
				<tr>
					<td align="center">${sprzedawca.imie}</td>
					<td align="center">${sprzedawca.nazwisko}</td>
					<td align="center">${sprzedawca.email}</td>
					<td><a href="/jo/usunUzytkownika?login=${sprzedawca.login}">Usun</a></td>
				</tr>
		</c:forEach>
	</table>
	</div>
	
	<div id="towary" style="display: none;">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nazwa</th>
				<th>Opis</th>
				<th>Cena</th>
				<th>Typ</th>
				<th>Pojemność</th>
				<th>Dostępny</th>
				<th>Usun</th>
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
					<td><a href="/jo/usunTowar?id=${towar.id}">Usun</a></td>
				</tr>
		</c:forEach>
		</table>
	</div>
	
	<div id="uzytkownicy" style="display: none;"> 
		<table border="1">
			<tr>
				<th>Login</th>
				<th>Hasło</th>
				<th>Email</th>
				<th>Imie</th>
				<th>Nazwisko</th>
				<th>Usun</th>
			</tr>
			<c:forEach var="uzytownik" items="${uzytkownicy}">
					<tr>
						<td align="center">${uzytownik.login}</td>
						<td align="center">${uzytownik.haslo}</td>
						<td align="center">${uzytownik.email}</td>
						<td align="center">${uzytownik.imie}</td>
						<td align="center">${uzytownik.nazwisko}</td>
						<td><a href="/jo/usunUzytkownika?login=${uzytownik.login}">Usun</a></td>
					</tr>
			</c:forEach>
		</table>
	</div>
	
	<div id="formSprzedawca" style="display: none;">
		<p>Dodaj sprzedawce </p>
		<form:form method="POST" action="nowySprzedawcaAction">
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
		        <td ><input type="submit" value="Dodaj"/></td>
		    </tr>
			</table>  
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</div>
	
	<script>
		function showSection(sekcja) {
		    document.getElementById("sprzedawcy").style.display = "none";
		    document.getElementById("towary").style.display = "none";
		    document.getElementById("uzytkownicy").style.display = "none";
		    document.getElementById("formSprzedawca").style.display = "none";
		    switch(sekcja) {
			    case 1:
			    	document.getElementById("sprzedawcy").style.display = "block";
			        break;
			    case 2:
			    	document.getElementById("towary").style.display = "block";
			        break;
			    case 3:
			    	document.getElementById("uzytkownicy").style.display = "block";
			        break;
			    case 4:
			    	document.getElementById("formSprzedawca").style.display = "block";
			        break;
			    default:
			    	document.getElementById("sprzedawcy").style.display = "block";
			} 
		}
	
	</script>
	
</body>
</html>