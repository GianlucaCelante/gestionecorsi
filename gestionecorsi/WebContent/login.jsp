<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="CDN.html"%>
		<link rel="stylesheet" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body class="text-center">
		<form class="form-signin">
			<h1 class="h3 mb-3 font-weight-normal">Effettua il login</h1>
			<label for="codice" class="sr-only">Codice</label>
			<input type="text" id="codice" class="form-control" placeholder="Codice admin" required autofocus>
			<label for="password" class="sr-only">Codice</label>
			<input type="password" id="password" class="form-control" placeholder="Password" required autofocus>
			<button class="btn btn-lg btn-primary btn-block" type="submit"> Login </button> 
		</form>
	</body>
</html>