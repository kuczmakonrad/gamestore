<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
	<script src="/gamestore/resource/js/controllers.js"></script>
<title>Gamestore gry</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Gry</h1>
			</div>
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
	<section class="container" ng-app="cartApp">
		<div class="row">
		<div class="col-md-5">
	<img src="<c:url value="/resource/images/${game.gameId}.jpg"></c:url>" alt="image"  style = "width:100%"/>
</div>
		
			<div class="col-md-5">
				<h3>${game.gameName}</h3>
				<p>${game.gameDescription}</p>
				<p>
					<strong>Id gry: </strong><span class="label label-warning">${game.gameId}</span>
				</p>
				<p>
					<strong>Platforma</strong>: ${game.gamePlatform}
				</p>
				<p>
					<strong>Kategoria</strong>: ${game.gameCategory}
				</p>
				<p>
					<strong>Stan</strong>: ${game.condition}
				</p>
				<p>
					<strong>Pozostało</strong>: ${game.gamesInStock}
				</p>
				<h4>${game.gamePrice} PLN</h4>
				<p ng-controller="cartCtrl">
					<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${game.gameId}')"> 
<span class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz </a>
<a href="<spring:url value="/cart" />" class="btn btn-default">
	<span class="glyphicon-hand-right glyphicon"></span> Koszyk
</a>

 <a href="<spring:url value="/games" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Wstecz
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>
