<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ESTUDIANTE</title>
</head>
<body>
	<h1>¡Bienvenido ESTUDIANTE!</h1>
	
	<security:authentication property="principal.username" var="usuario"></security:authentication>
	
	<p>Estimado ${usuario}, le damos la bienvenida a ESTUDIANTE.</p>
	<a href="<c:url value='/index'/>">Inicio</a>
	<a href="<c:url value='/logout'/>">Cerrar sesión</a>
</body>
</html>