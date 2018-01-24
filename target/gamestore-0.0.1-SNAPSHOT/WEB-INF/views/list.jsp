<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Lista użytkowników Gamestore</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Gamestore</h1>
				<p>Jako administrator zarządzaj użytkownikami</p>
			</div>
			<a href="<spring:url value="/games"/>" class="btn btn-danger btn-mini pull-right">Wszystkie gry</a>
			<a href="<spring:url value="/games/xboxone"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX ONE</a>
			<a href="<spring:url value="/games/ps4"/>" class="btn btn-danger btn-mini pull-right">Gry PS4</a>
			<a href="<spring:url value="/games/xbox360"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX 360</a>
			<a href="<spring:url value="/games/ps3"/>" class="btn btn-danger btn-mini pull-right">Gry PS3</a>
			<a href="<spring:url value="/"/>" class="btn btn-danger btn-mini pull-right">Strona Główna</a>
		</div>	
				
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href=<c:url value="/games/add" />><span
								class="glyphicon glyphicon-log-in"></span> Dodaj gre </a></li>
			</sec:authorize>			
			<sec:authorize access="isAuthenticated()">
						<li><a href=<c:url value="/j_spring_security_logout" />><span
								class="glyphicon glyphicon-log-in"></span> Wyloguj</a></li>
					</sec:authorize>
		</ul>
	</div>
</nav>
		
	</section>
<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Imię</th>
					<th>Nazwisko</th>
					<th>Miejscowość</th>
					<th>Telefon</th>
					<th>Email</th>
					<th>Login</th>
					<th>Usuń</th>
				</tr>
			</thead>
			<c:forEach items="${user}" var="user">
				<tbody>
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.surname}</td>
						<td>${user.country}</td>
						<td>${user.phoneNumber}</td>
						<td>${user.emailAdress}</td>
						<td>${user.userLogin}</td>
						<td><a
						
							href=<spring:url value="/users/list/delete/user?id=${user.id}" />
							class="btn btn-warning" role="button">Usuń</a></td>
					</tr>
					</tbody>
			</c:forEach>
		</table>
	</div>
	</body>
	</html>
	