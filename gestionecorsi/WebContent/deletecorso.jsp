<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%
	String admin = (String) session.getAttribute("admin");
	if (admin != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="it.betacom.businesscomponent.ClientFacade" %>
	<%@page import="it.betacom.businesscomponent.model.Corso" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<link rel="stylesheet" href="css/style.css">
<title>Delete Corso</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container" style="margin-top: 100px;">
		<div class="page-header"">
			<h3>Corsi attualmente disponibili</h3>
		</div>
		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 200px">Codice Corso</th>
						<th style="width: 200px">Nome Corso</th>
						<th style="width: 200px">Data Inizio</th>
						<th style="width: 200px">Data Fine</th>
						<th style="width: 200px">Aula</th>
						<th style="width: 200px">Codice Docente</th>
						<th style="width: 200px">Rimuovi</th>
					</tr>
				</thead>
				<tbody>
					<%
					Locale locale = request.getLocale();
					DateFormat formato = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
						Corso[] corsi = ClientFacade.getIstance().getCorsiAttivi();
						for(int i = 0; i<corsi.length; i++){
					%>
					<tr>
						<td><%= corsi[i].getCodCorso() %></td>
						<td><%= corsi[i].getNomeCorso() %></td>
						<td><%= formato.format(corsi[i].getDataInizioCorso()) %></td>
						<td><%= formato.format(corsi[i].getDataFineCorso()) %></td>
						<td><%= corsi[i].getAulaCorso() %></td>						
						<td><%= corsi[i].getCodDocente() %></td>
						<td>
							<form action="/<%=application.getServletContextName()%>/rimuovi?codCorso=<%=corsi[i].getCodCorso()%>"
								method="post">
								<input type="hidden" name="codCorso" value="<%= corsi[i].getCodCorso() %>"/>
								<button type="submit" class="btn btn-danger btn-xs">Rimuovi</button>
							</form>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		
		<%
			}else{
				response.sendRedirect("index.jsp");
			}
		%>
	</div>
	

</body>
</html>