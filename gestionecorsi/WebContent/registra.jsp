<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="CDN.html"%>
		<link rel="stylesheet" href="css/style.css">
		<title>Registrazione</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="container">
			<div class="page-header">
				<h3>Registrazione utente</h3>
			</div>
			
			<form action="/<%= application.getServletContextName()%>/salvautente" class="form-horizontal" method="post" id="userForm">
				<%-- Nome --%>
				<div class="form-group">
					<label class="col-md-1 control-label">Nome</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
							<input type="text" name="nome" id="nome" placeholder="Inserire il nome" class="form-control" autocomplete="off">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoNome"></div>
				</div>
				<%-- Cognome --%>
				<div class="form-group">
					<label class="col-md-1 control-label">Cognome</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon">
								<i class="glyphicon glyphicon-user"></i>
							</span>
							<input type="text" name="cognome" id="cognome" placeholder="Inserire il cognome" class="form-control" autocomplete="off">
						</div>
					</div>
					<div class="col-md-7 control-label" id="infoCognome"></div>
				</div>
				<%-- Formazione Precedente --%>
				<div class="form-group">
					<label class="col-md-1 control-label" style="max-width:100%;">Precedente formazione</label>
					<div class="col-md-4 inputGroupContainer" style="display:flex;">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="radio" id="precFormSi">
							<label class="form-check-label" for="precFormSi">Si</label>
						</div>
						<div class="ml-5 form-check">
							<input class="form-check-input" type="radio" name="radio" id="precFormNo" checked>
							<label class="form-check-label" for="precFormNo">No</label>
						</div>
					</div>
				</div>
				<%-- Bottone Registra --%>
				<div class="row">
					<div class="clo-md-4 col-md-offeset-1" style="margin-left:30px;">
						<button type="submit" class="btn btn-primary">Registrati&nbsp;<span class="glyphicon glyphicon-send"></span></button>
					</div>
				</div>
			</form>
		</div>
		<!--<jsp:include page="footer.jsp"/>-->
	</body>
</html>