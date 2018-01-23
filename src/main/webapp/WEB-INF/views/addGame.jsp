<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
				<h1>Gry</h1>
				<p>Dodaj gry</p>
							</div>

			<a href="<spring:url value="/"/>" class="btn btn-danger btn-mini pull-right">Strona główna</a>
			<a href="<spring:url value="/games"/>" class="btn btn-danger btn-mini pull-right">Wszystkie gry</a>
			<a href="<spring:url value="/games/xboxone"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX ONE</a>
			<a href="<spring:url value="/games/ps4"/>" class="btn btn-danger btn-mini pull-right">Gry PS4</a>
			<a href="<spring:url value="/games/xbox360"/>" class="btn btn-danger btn-mini pull-right">Gry XBOX 360</a>
			<a href="<spring:url value="/games/ps3"/>" class="btn btn-danger btn-mini pull-right">Gry PS3</a>
		</div>
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-right">
				
			<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href=<c:url value="/users/list" />><span
							class="glyphicon glyphicon-log-in"></span> Lista uzytkownikow</a></li>
			</sec:authorize>
					
			<sec:authorize access="isAuthenticated()">
						<li><a href=<c:url value="/j_spring_security_logout" />><span
								class="glyphicon glyphicon-log-in"></span> Wyloguj</a></li>
					</sec:authorize>
		</ul>
	</div>
</nav>
	</section>
	<section class="container">
		<form:form modelAttribute="newGame" class="form-horizontal" enctype="multipart/form-data">
				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<fieldset>
				<legend>Dodaj nową grę</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="gameId">
					<spring:message code="addGame.form.gameId.label"/>
					</label>
					<div class="col-lg-10">
						<form:input id="gameId" path="gameId" type="text" class="form:input-large" />
						<form:errors path="gameId" cssClass="text-danger"/>
					</div>
					
				</div>		
				
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="gameName">Nazwa</label>
					<div class="col-lg-10">
						<form:input id="gameName" path="gameName" type="text" class="form:input-large" />
						<form:errors path="gameName" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="gamePrice">Cena</label>
					<div class="col-lg-10">		
						<form:input id="gamePrice" path="gamePrice" type="text" class="form:input-large" />
						<form:errors path="gamePrice" cssClass="text-danger"/>
					</div>
				</div>
				
					<div class="form-group">
					<label class="control-label col-lg-2" for="gamePlatform">Platforma Gry</label>
					<div class="col-lg-10">
						<form:radiobutton path="gamePlatform" value="PS4" />
						Playstation 4
						<form:radiobutton path="gamePlatform" value="XBOX ONE" />
						Xbox One
						<form:radiobutton path="gamePlatform" value="PS3" />
						Playstation 3
						<form:radiobutton path="gamePlatform" value="XBOX 360" />
						Xbox 360
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="gameCategory">Kategoria</label>
					<div class="col-lg-10">
						<form:input id="gameCategory" path="gameCategory" type="text" class="form:input-large" />
						<form:errors path="gameCategory" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="gamesInStock">Liczba gier w magazynie</label>
					<div class="col-lg-10">		
					<form:input id="gamesInStock" path="gamesInStock" type="text" class="form:input-large" />
					<form:errors path="gamesInStock" cssClass="text-danger"/>
					</div>	
				</div>	
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="gameDescription">Opis</label>
					<div class="col-lg-10">
						<form:textarea id="gameDescription" path="gameDescription" rows="2"/>
						<form:errors path="gameDescription" cssClass="text-danger"/>
					</div>
				</div>
			
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Stan</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						Nowy
						<form:radiobutton path="condition" value="Old" />
						Używany
					</div>
				</div>
				<div class="form-group">
				<label class="control-label col-lg-2" for="gameImage">
				<spring:message code="addProdcut.form.gameImage.label"/>
				</label>
				<div class="col-lg-10">
				<form:input id="gameImage" path="gameImage" type="file" class="form:input-large" />
				</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>