<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="CDN.html"%>
		<link rel="stylesheet" href="css/style.css">
		<title>Registrazione</title>
	</head>
	<body class="text-center">
		<jsp:include page="header.jsp"/>
		<div class="wrapper">
			<h1 class="h3 font-weight-normal">Effettua la registrazione</h1>
			<form class="form-signin" style="margin-top: 0%!important;">
				<label class="text-left">Nome</label>
				<input type="text" id="nome" class="form-control" placeholder="Nome" required autofocus>
				<label class="text-left">Cognome</label>
				<input type="text" id="cognome" class="form-control" placeholder="Cognome" required autofocus>
				<label class="text-left">Precedenti formativi</label>
				<div class="form-group d-flex">
					<div class="form-check" style="width:50%">
						<input class="form-check-input" type="radio" name="radio" id="radioSi" value="Si">
						<label class="form-check-label" for="radioSi">Si</label>
					</div>
					<div class="form-check" style="width:50%">
						<input class="form-check-input" type="radio" name="radio" id="radioNo" value="No" checked>
						<label class="form-check-label" for="radioNo">No</label>
					</div>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Registrati</button> 
			</form>
		</div>
		<jsp:include page="footer.jsp"/>
	</body>
</html>