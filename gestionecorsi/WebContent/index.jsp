<%
	String admin = (String) session.getAttribute("admin");
	if(admin == null){
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="CDN.html"%>
		<link rel="stylesheet" href="css/style.css">
		<title>Login</title>
	</head>
<body class="text-center">
	<div class="wrapper">
		<form class="form-signin" action = "/<%= application.getServletContextName() %>/login" method="post" id="loginForm">
			<%
				if(session.getAttribute("tentativi") != null){
			%>	<div class="alert-warning"> 
						<p> Codice o password errata! Hai ancora <%= session.getAttribute("tentativi") %> tentativi! </p>
				</div>
			<% }%>
			<h1 class="h3 font-weight-normal">Effettua il login</h1>
			<label for="codice" class="sr-only">Codice</label>
			<input type="text" name="codice" class="form-control" placeholder="Codice admin" required autofocus />
			<label for="password" class="sr-only">Codice</label>
			<input type="password"  name="password" class="form-control" placeholder="Password" required autofocus />
			<button class="btn btn-lg btn-primary btn-block" type="submit"> Login </button> 
		</form>
	</div>
</body>
</html>
<% }else {
	response.sendRedirect("home.jsp");
} %>