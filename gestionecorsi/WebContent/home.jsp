
<%@page import="it.betacom.businesscomponent.model.CorsoCorsista"%>
<%@page import="it.betacom.businesscomponent.ClientFacade"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%
	String admin = (String) session.getAttribute("admin");

if (admin == null) {
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


	<div class="container">

		<div class="table-responsive">

			<table class="table table-hover" style="width: 100%;">

				<thead>
					<tr>

						<td style="width: 150px;">Codice</td>
						<td style="width: 200px;">Nome</td>
						<td style="width: 200px;">Cognome</td>
						<td style="width: 200px;">Precedenti formativi</td>
						<td style="width: 200px;">Codice corso</td>

					</tr>

				</thead>

				<tbody>
				
					<%
						
					Corsista[] corsisti = ClientFacade.getIstance().getCorsisti();
					CorsoCorsista[] corsiCorsisti = ClientFacade.getIstance().getCorsiCorsisti();
						
					for(Corsista c: corsisti){
						
					%>
				
					<tr>
						<td><%= c.getCodCorsista() %></td>
						<td><%= c.getNomeCorsista() %></td>
						<td><%= c.getCognomeCorsista() %></td>
						<td><%= c.getPrecedentiFormativi() %></td>

					<%
					
						}
					
						for(CorsoCorsista cc: corsiCorsisti){
							
					%>
						
						<td><%= cc.getCodCorso() %></td>
					
					<%
					
						}
					
					%>	
					</tr>
					
					

				</tbody>

			</table>

		</div>


	</div>



</body>
</html>

<%
	} else {

}
%>


