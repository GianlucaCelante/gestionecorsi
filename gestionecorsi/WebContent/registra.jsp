<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.ClientFacade"%>
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
		<div class="wrapper" style="margin-top:7%;">
			<h1 class="h3 font-weight-normal">Effettua la registrazione</h1>
			<form class="form-signin" style="margin-top: 0%!important; margin-bottom: 0%!important;" action="/<%=application.getServletContextName()%>/registra" method="post">
				<label class="text-left">Nome</label>
				<input type="text" id="nome" name="nomeCorsista" class="form-control" placeholder="Nome" autocomplete="off" required autofocus>
				<label class="text-left">Cognome</label>
				<input type="text" id="cognome" name="cognomeCorsista" class="form-control" placeholder="Cognome" autocomplete="off" required autofocus>
				<label class="text-left">Seleziona il corso</label>
				<br>
				<select class="custom-select" name="corso" id="corsi">
					<option value="0">-- Seleziona --</option>
					<%
						Corso[] corsi = ClientFacade.getIstance().getCorsi();
						for(int i = 0; i<corsi.length; i++){
							%><option value="<%= corsi[i].getCodCorso() %>"><%= corsi[i].getNomeCorso() %></option><%
						}
					%>
				</select>
				<br>
				<label class="text-left">Precedenti formativi</label>
				<div class="form-group d-flex">
					<div class="form-check" style="width:50%">
						<input class="form-check-input" type="radio" name="radio" id="radioSi" value="1">
						<label class="form-check-label" for="radioSi">Si</label>
					</div>
					<div class="form-check" style="width:50%">
						<input class="form-check-input" type="radio" name="radio" id="radioNo" value="0" checked>
						<label class="form-check-label" for="radioNo">No</label>
					</div>
				</div>
				<button class="btn btn-lg btn-primary btn-block" style="margin-top:5%;" type="submit">Registrati</button> 
			</form>
		</div>
		<!--<jsp:include page="footer.jsp"/>-->
	</body>
</html>