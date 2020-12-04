<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	<h1>Inicio</h1>
	
	<!-- Cuando no esta logeado -->
	<security:authorize access="isAnonymous()">
		<a href="<c:url value='/login'/>">Iniciar sesión</a>
	</security:authorize>
	
	<!-- Cuando ya está logeado -->
	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal.username" var="usuario"/>
		<p>Hola <b>${usuario} }</b></p>|
		
		<security:authorize access="hasRole{'ESTUDIANTE'}">
			<a href="<c:url value='/estudiante'/>">Ir a estudiante</a>
		</security:authorize>
		
		<security:authorize access="hasRole{'DOCENTE'}">
			<a href="<c:url value='/docente'/>">Ir a estudiante</a>
		</security:authorize>
		
		|<a href="<c:url value='/logut'/>">Cerrar sesión</a>
	</security:authorize>
</body>
</html>