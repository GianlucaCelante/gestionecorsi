<%@page import="it.betacom.businesscomponent.model.Docente"%>
<%@page import="it.betacom.businesscomponent.model.Corsista"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.betacom.businesscomponent.model.Corso"%>
<%@page import="it.betacom.businesscomponent.ClientFacade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="CDN.html"%>
<link rel="stylesheet" href="css/style.css">
<title>Statistiche</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
	<h1 class="page-header">Statistiche generali</h1>
	
	<h3>Numero corsisti totali:</h3>
	<%
		int nCorsisti = ClientFacade.getIstance().getNumeroCorsisti();
	%>
	<div class="card card-body bg-light">
	<%= nCorsisti %>
	</div>
	<h3>Corso pi&ugrave; frequentato:</h3>
		<%
			String[] nomiCorsi = ClientFacade.getIstance().getNomeCorsoPiuFrequentato();
			for(int i = 0; i<nomiCorsi.length; i++){
		%>
		<div class="card card-body bg-light">
		<p>Corso più frequentato: <%= nomiCorsi[i] %></p>
		<%
			}
		%>
	</div>
	<h3>Data inizio ultimo corso:</h3>
		<%
			String[] ultimiCorsi = ClientFacade.getIstance().getDataInizioUltimoCorso();
			for(int i = 0; i<nomiCorsi.length; i++){
		%>
	<div class="card card-body bg-light">
		<p>Ultimo corso: <%=ultimiCorsi[i] %></p>
		<p>Data ultimo corso: <%=ultimiCorsi[i+1] %></p>
		<%
			i++;
			}
		%>
	</div>
	<h3>Durata media dei corsi (in giorni lavorativi):</h3>
	<div class="card card-body bg-light">
	</div>
	<h3>Numero di commenti presenti:</h3>
	<div class="card card-body bg-light">
		<%
			int nCommenti = ClientFacade.getIstance().getNumeroCommenti();
		%>
		<p>Numero totale di commmenti: <%=nCommenti %></p>
	</div>
	<h3>Elenco corsisti:</h3>
	<div class="card card-body bg-light">
		<%
			Corsista[] corsisti = ClientFacade.getIstance().getCorsisti();
			for(int i = 0; i<corsisti.length; i++){
		%>
		<p>Nome: <%=corsisti[i].getNomeCorsista() %></p>
		<p>Cognome: <%=corsisti[i].getCognomeCorsista() %></p>
		<p>Codice: <%=corsisti[i].getCodCorsista() %></p>
		<p>Precedenti formativi: 
		</p> <% if(corsisti[i].getPrecedentiFormativi() == 1){%><p>Si</p><%}else{ %><p>No</p><%}}%>
	</div>
	<h3>Docenti di pi&ugrave; corsi:</h3>
	<div class="card card-body bg-light">
	<%
		Docente[] docenti = ClientFacade.getIstance().getDocentePiuCorsi();
		for(int i = 0; i<docenti.length; i++){
	%>
	<p>Nome: <%=docenti[i].getNomeDocente() %></p>
	<p>Cognome: <%=docenti[i].getCognomeDocente() %></p>
	<p>CV docente: <%=docenti[i].getCvDocente() %></p>
	<p>Codice docente: <%=docenti[i].getCodDocente() %></p> 
	</div>
	<%
		}
	%>
		<h3>Corsi con posti disponibili:</h3>
		<%
			Corso[] corsiDisponibili = ClientFacade.getIstance().getCorsiDisponibili();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			for(int i = 0; i<corsiDisponibili.length; i++){
		%>
		<div class="card card-body bg-light">
		<p>CodCorso: <%=corsiDisponibili[i].getCodCorso() %></p>
		<p>CodDocente: <%=corsiDisponibili[i].getCodDocente() %></p>
		<p>Nome corso: <%=corsiDisponibili[i].getNomeCorso() %></p>
		<p>Data inizio corso: <%=formato.format(corsiDisponibili[i].getDataInizioCorso()) %></p>
		<p>Data fine corso: <%=formato.format(corsiDisponibili[i].getDataFineCorso()) %></p>
		<p>Costo corso: <%=corsiDisponibili[i].getCostoCorso() %></p>
		<p>Commento corso: <%=corsiDisponibili[i].getCommentiCorso() %></p>
		<p>Aula corso: <%=corsiDisponibili[i].getAulaCorso() %></p>
		<p>Posti disponibili: <%=corsiDisponibili[i].getPostiDisp() %></p>
		</div>
		<%
			}
		%>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>