<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Gry</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Gamestore</h1>
				<p>Lista gier w naszym sklepie</p>
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
						<li><a href=<c:url value="/users/list" />><span
							class="glyphicon glyphicon-log-in"></span> Lista uzytkownikow</a></li>
			</sec:authorize>
					
			<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href=<c:url value="/games/add" />><span
								class="glyphicon glyphicon-log-in"></span> Dodaj gre </a></li>
			</sec:authorize>
			
					<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
						<li><a href=<spring:url value="/users" />><span
								class="glyphicon glyphicon-user"></span> Rejestracja</a></li>
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

	<section class="container">
		<div class="row">
			<c:forEach  items="${games}" var="game">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resource/images/${game.gameId}.jpg"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${game.gameName}</h3>
							<p>${game.gameDescription}</p>
							<p>${game.gamePrice} PLN</p>
							<p>Pozostało: ${game.gamesInStock}</p>
							<p>
								<a
									href=" <spring:url value="/games/game?id=${game.gameId}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Szczegóły
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>
