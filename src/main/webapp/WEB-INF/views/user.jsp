<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>User Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Dodaj uzytkownika</h1>
			</div>
			 <a
				href="<spring:url value="/games/xboxone"/>"
				class="btn btn-danger btn-mini pull-right">Gry XBOX ONE</a> <a
				href="<spring:url value="/games/ps4"/>"
				class="btn btn-danger btn-mini pull-right">Gry PS4</a> <a
				href="<spring:url value="/games/xbox360"/>"
				class="btn btn-danger btn-mini pull-right">Gry XBOX 360</a> <a
				href="<spring:url value="/games/ps3"/>"
				class="btn btn-danger btn-mini pull-right">Gry PS3</a> <a
				href="<spring:url value="/"/>"
				class="btn btn-danger btn-mini pull-right">Strona Glowna</a>
		</div>
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-right">
				
			<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href=<c:url value="/users/list" />><span
							class="glyphicon glyphicon-log-in"></span> Lista uzytkownikow</a></li>
			</sec:authorize>
					
			<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href=<c:url value="/games/add" />><span
								class="glyphicon glyphicon-log-in"></span> Dodaj gre </a></li>
			</sec:authorize>
					
			<sec:authorize access="isAuthenticated()">
						<li><a href=<c:url value="/j_spring_security_logout" />><span
								class="glyphicon glyphicon-log-in"></span> Wyloguj</a></li>
					</sec:authorize>
			
			<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
						<li><a href=<spring:url value="/login" />><span
								class="glyphicon glyphicon-log-in"></span> Logowanie</a></li>
			</sec:authorize>
		</ul>
	</div>
</nav>
		
	</section>
	<c:url var="addAction" value="/user/add"></c:url>

	<form:form action="${addAction}" commandName="user">
		<table>
			<c:if test="${!empty user.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /> <form:errors
							path="id" cssClass="text-danger" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Imie" />
					</form:label></td>
				<td><form:input path="name" /> <form:errors path="name"
						cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="surname">
						<spring:message text="Nazwisko" />

					</form:label></td>
				<td><form:input path="surname" /> <form:errors path="surname"
						cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="street">
						<spring:message text="Ulica" />
					</form:label></td>
				<td><form:input path="street" /> <form:errors path="street"
						cssClass="text-danger" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="houseNumber">
						<spring:message text="Numer domu" />
					</form:label></td>
				<td><form:input path="houseNumber" /> <form:errors
						path="houseNumber" cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="cityId">
						<spring:message text="Kod pocztowy" />
					</form:label></td>
				<td><form:input path="cityId" /> <form:errors path="cityId"
						cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message text="Miasto" />
					</form:label></td>
				<td><form:input path="city" /> <form:errors path="city"
						cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="country">
						<spring:message text="Panstwo" />
					</form:label></td>
				<td><form:input path="country" /> <form:errors path="country"
						cssClass="text-danger" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="phoneNumber">
						<spring:message text="Numer telefonu" />
					</form:label></td>
				<td><form:input path="phoneNumber" /> <form:errors
						path="phoneNumber" cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="emailAdress">
						<spring:message text="E-mail" />
					</form:label></td>
				<td><form:input path="emailAdress" /> <form:errors
						path="emailAdress" cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="userLogin">
						<spring:message text="Login" />

					</form:label></td>
				<td><form:input path="userLogin" /> <form:errors
						path="userLogin" cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td><form:label path="userPassword">
						<spring:message text="Haslo" />
					</form:label></td>
				<td><form:input path="userPassword" /> <form:errors
						path="userPassword" cssClass="text-danger" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty user.name}">
						<input type="submit"
							value="<spring:message text="Edytuj uzytkownika"/>" />
					</c:if> <c:if test="${empty user.name}">
						<input type="submit"
							value="<spring:message text="Dodaj uzytkownika"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	
</body>
</html>