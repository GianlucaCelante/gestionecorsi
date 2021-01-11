<%
	String admin = (String) session.getAttribute("admin");

if (admin != null) {
%>
<%@page import="it.betacom.businesscomponent.CorsistaBC"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.model.CorsoCorsista"%>
<%@page import="it.betacom.businesscomponent.ClientFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>


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

						<td style="width: 150px;"><b>Codice</b></td>
						<td style="width: 200px;"><b>Nome</b></td>
						<td style="width: 200px;"><b>Cognome</b></td>
						<td style="width: 200px;"><b>Precedenti formativi</b></td>
						<td style="width: 200px;"><b>Corso</b></td>

					</tr>

				</thead>

				<tbody>

					<%
					

					CorsoCorsista[] cc = ClientFacade.getIstance().getCorsiCorsisti();

					for(int i = 0; i < cc.length; i++){
						
						Corsista corsista = ClientFacade.getIstance().getCorsista(cc[i].getCodCorsista());
						Corso corso = ClientFacade.getIstance().getCorsoById(cc[i].getCodCorso());

					%>

					<tr>
					
						<td><%= corsista.getCodCorsista() %></td>
						<td><%= corsista.getNomeCorsista() %></td>
						<td><%= corsista.getCognomeCorsista() %></td>
						<td><%= corsista.getPrecedentiFormativi() %></td>
						<td><%= corso.getNomeCorso() %></td>

					</tr>

					<%
						
						}
						
					%>

				</tbody>

			</table>
			
			<input type="button" value="Nuovo corsista" onclick="window.location='registra.jsp'" >

		</div>

	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>

<%
	} else {

		response.sendRedirect("accessonegato.jsp");
}
%>


