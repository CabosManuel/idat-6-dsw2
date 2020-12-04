<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>¡Error!</title>
</head>
<body>
	<h1>¡Error!</h1>
	
	<security:authentication property="principal.username" var="usuario"/>
	<p>Estimado <b>${usuario}</b>, no tiene permiso para acceder a esta página</p>
</body>
</html>