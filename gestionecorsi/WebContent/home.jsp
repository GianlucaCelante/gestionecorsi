
<%@page import="it.betacom.businesscomponent.CorsistaBC"%>
<%@page import="it.betacom.architecture.dao.CorsistaDAO"%>
<%@page import="it.betacom.architecture.dao.CorsoDAO"%>
<%@page import="java.util.Date"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.model.CorsoCorsista"%>
<%@page import="it.betacom.businesscomponent.ClientFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%
	String admin = (String) session.getAttribute("admin");

if (admin != null) {
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="CDN.html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>

<meta name="viewport" content="width = device-width, initial-scale = 1">
<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div class="container" style="margin-top: 100px;">

		<div class="table-responsive">

			<table class="table table-hover">

				<thead>
					<tr>

						<td style="width: 150px;">Codice</td>
						<td style="width: 200px;">Nome</td>
						<td style="width: 200px;">Cognome</td>
						<td style="width: 200px;">Precedenti formativi</td>
						<td style="width: 200px;">Corso</td>

					</tr>

				</thead>

				<tbody>

					<%
					
					int[] codCorsistiAttivi = ClientFacade.getIstance().getCodCorsisti();
					
					for(int i = 0; i < codCorsistiAttivi.length; i++){
						
						Corsista corsista = ClientFacade.getIstance().getCorsista(codCorsistiAttivi[i]);
						
					%>


					<tr>
					
						<td><%= corsista.getCodCorsista() %></td>
						<td><%= corsista.getNomeCorsista() %></td>
						<td><%= corsista.getCognomeCorsista() %></td>
						<td><%= corsista.getPrecedentiFormativi() %></td>

					</tr>

					<%
						
						}
						
					%>
				

				</tbody>

			</table>
			
			
			<button class="btn btn-info">
			<a href="registra.jsp">Nuovo corsista</a>
			</button>

		</div>


	</div>



</body>
</html>

<%
	} else {

		response.sendRedirect("accessonegato.jsp");

}
%>


