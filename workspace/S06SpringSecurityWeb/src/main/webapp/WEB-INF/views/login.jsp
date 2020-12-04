<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- libreria JSTL core -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form name="form" method="post" action="/cabos/login">
	
		<!-- token de seguridad -->
		<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}" />
	
		<c:if test="${param.error != null}" >
			<p style="color:red;">¡Error, usuario y/o contraseña incorrecto!</p>
		</c:if>
		
		<c:if test="${param.logout != null}" >
			<p style="color:green;">¡Usted a cerrado sesión!</p>
		</c:if>
	
		Usuario: <input type="text" name="txt_user"/><br>
		Contraseña: <input type="password" name="txt_pass"/><br>
		<br>
		<button type="submit">Iniciar sesión</button>
	</form>
</body>
</html>
