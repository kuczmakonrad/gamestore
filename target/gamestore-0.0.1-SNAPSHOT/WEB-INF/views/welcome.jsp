<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Sklep Gamestore</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${tagline}</p>		
			<a href="<spring:url value="/games"/>" class="btn btn-danger btn-mini pull-right">Wszystkie gry</a>
			<a href="<spring:url value="/games/xboxone"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX ONE</a>
			<a href="<spring:url value="/games/ps4"/>" class="btn btn-danger btn-mini pull-right">Gry PS4</a>
			<a href="<spring:url value="/games/xbox360"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX 360</a>
			<a href="<spring:url value="/games/ps3"/>" class="btn btn-danger btn-mini pull-right">Gry PS3</a>
			
				
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

</div>
			
		</div>		
		<h1>Projekt aplikacji webowej sklepu z grami na konsole.</h1>
		<h1>Zapraszamy do rejestracji oraz kupna gier lub odwiedzenia naszej placówki.</h1>	
		<h1>Adres sklepu stacjonarnego to: ul. 18-go Stycznia 50A, 98-300 Wielun.</h1>
		<h1>Wykonanie: Konrad Kuczma.</h1>
		
	</section>
</body>
</html>