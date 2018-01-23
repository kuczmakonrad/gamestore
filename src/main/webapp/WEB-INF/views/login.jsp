<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Gry</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Gamestore</h1>
				<p>Zaloguj się lub załóż konto</p>
			</div>
			<a href="<spring:url value="/"/>" class="btn btn-danger btn-mini pull-right">Strona główna</a>
			<a href="<spring:url value="/games"/>" class="btn btn-danger btn-mini pull-right">Wszystkie gry</a>
			<a href="<spring:url value="/games/xboxone"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX ONE</a>
			<a href="<spring:url value="/games/ps4"/>" class="btn btn-danger btn-mini pull-right">Gry PS4</a>
			<a href="<spring:url value="/games/xbox360"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX 360</a>
			<a href="<spring:url value="/games/ps3"/>" class="btn btn-danger btn-mini pull-right">Gry PS3</a>
		</div>
	</section>
<div class="container">
    <div class="row">
		<div class="col-md-4 col-md-offset-4">
    		<div class="panel panel-default">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">Panel logowania</h3>

			 	</div>
			  	<div class="panel-body">
			  	<c:if test="${not empty error}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br />
					</div>
				</c:if>
			    	<form method="post" action="<c:url value="/j_spring_security_check"></c:url>" >
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Nazwa użytkownika" name='j_username' type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Hasło" name='j_password' type="password" value="">
			    		</div>
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Zaloguj się">
			    		<a href="<spring:url value="/users"/>" input class="btn btn-lg btn-success btn-block"> 
			    		Zarejestruj się</a>
			    		
			    	</fieldset>
			      	</form>
			    </div>
			</div>
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
			
		</ul>
	</div>
</nav>
</div>
</body>
