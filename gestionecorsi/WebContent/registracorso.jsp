<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.ClientFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String admin = (String) session.getAttribute("admin");
if (admin != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<title>Registrazione corso</title>
</head>
<body style="margin-top: 100px; margin-bottom: 200px">
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Registrazione corso</h3>
		</div>

		<form action="/<%=application.getServletContextName()%>/salvacorso"
			class="form-horizontal" method="post" id="corsoForm">
			
			<%------------------codDocente-----------------%>
			<div class="form-group">
				<label class="col-md-1 control-label">Docente</label>
				<div class="col-md-4 inputGroupContainer">
				<% Docente[] docenti = ClientFacade.getIstance().getDocenti();%>
					<select name="coddocente" id="coddocente" class="form-control">
					<%for (int i = 0; i < docenti.length; i++) { %>
						<option value="<%=docenti[i].getCodDocente()%>"><%=docenti[i].getNomeDocente()%> <%=docenti[i].getCognomeDocente()%></option>
					<%} %>
					</select>
				</div>
			</div>
			
			<%----------------Nome --------------%>
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="text" name="nome" id="nome" class="form-control" placeholder="Nome">
					</div>
				</div>
				<%String errorNome = (String) session.getAttribute("errorNomeCorso"); 
				if(errorNome != null){%>
				<div class="col-md-7 control-label" id="infoNome" style="color: red;"><%=errorNome%></div>
				<%}%>
			</div>

			<%----------------Data inizio --------------%>
			<div class="form-group">
				<label class="col-md-2 control-label">Inizio corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="dp1">
						<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
						</span>
						<input type="text" name="inizio" id="inizio" class="form-control" placeholder="DD/MM/YYYY">
					</div>
				</div>
				<%String errorData = (String) session.getAttribute("errorDataCorso"); 
				if(errorData != null){%>
				<div class="col-md-7 control-label" id="infoInizio" style="color: red;"><%=errorData%></div>
				<%} %>
			</div>
			<script>
				$(function() {
					$('#dp1').datepicker({
						format : 'dd/mm/yyyy',
						autoclose : true,
						startDate : '01/01/1900',
						endDate : '31/12/2999'
					}).on(
							'changeDate',
							function(e) {
								$('#corsoForm').bootstrapValidator(
										'revalidateField', 'inizio');
							});
				});
			</script>

			<%----------------Data fine --------------%>
			<div class="form-group">
				<label class="col-md-2 control-label">Fine corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="dp2">
						<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-calendar"></i>
						</span>
						<input type="text" name="fine" id="fine" class="form-control" placeholder="DD/MM/YYYY">
					</div>
				</div>
				<%String errorData2 = (String) session.getAttribute("errorDataCorso"); 
				if(errorData2 != null){%>
				<div class="col-md-7 control-label" id="infoInizio" style="color: red;"><%=errorData2%></div>
				<%} %>
			</div>
			<script>
				$(function() {
					$('#dp2').datepicker({
						format : 'dd/mm/yyyy',
						autoclose : true,
						startDate : new Date(),
						endDate : '31/12/2999'
					}).on(
							'changeDate',
							function(e) {
								$('#corsoForm').bootstrapValidator(
										'revalidateField', 'fine');
							});
				});
			</script>
			
			<%----------------Costo --------------%>
			<div class="form-group">
				<label class="col-md-1 control-label">Costo</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-eur"></i>
						</span>
						<input type="text" name="costo" id="costo" class="form-control" placeholder="EUR">
					</div>
				</div>
				<%String errorCosto = (String) session.getAttribute("errorCostoCorso"); 
				if(errorCosto != null){%>
				<div class="col-md-7 control-label" id="infoInizio" style="color: red;"><%=errorCosto%></div>
				<%}%>
			</div>

			<%----------------Commenti --------------%>
			<div class="form-group">
				<label class="col-md-1 control-label">Commento</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<textarea name="commenti" id="commenti" placeholder="Commento" class="form-control" style="resize: none"></textarea>
					</div>
				</div>
				<%String errorCommento = (String) session.getAttribute("errorCommentoCorso"); 
				if(errorCommento != null){%>
				<div class="col-md-7 control-label" id="infoInizio" style="color: red;"><%=errorCommento%></div>
				<%} %>
			</div>

			<%----------------Aula --------------%>
			<div class="form-group">
				<label class="col-md-1 control-label">Aula</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> 
							<i class="glyphicon glyphicon-lock"></i>
						</span> 
						<input type="text" name="aula" id="aula" class="form-control" placeholder="Aula">
					</div>
				</div>
				<%String errorAula = (String) session.getAttribute("errorAulaCorso"); 
				if(errorAula != null){%>
				<div class="col-md-7 control-label" id="infoInizio" style="color: red;"><%=errorAula%></div>
				<%} %>
			</div>
			
			<div class="row">
				<div class="col-md-4 col md-offset-1">
					<button type="submit" class="btn btn-primary">
						Registrati&nbsp;<span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>
			
			
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
<%
session.removeAttribute("errorNomeCorso");
session.removeAttribute("errorDataCorso");
session.removeAttribute("errorCostoCorso");
session.removeAttribute("errorCommentoCorso");
session.removeAttribute("errorAulaCorso");

} else {
	response.sendRedirect("accessonegato.jsp");
}
%>