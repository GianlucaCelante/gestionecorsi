<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white fixed-top" style="border-bottom:1px solid grey;">
	<h5 class="my-0 mr-md-auto font-weight-normal">Corsi</h5>
	<div class="my-2 my-md-0 mr-md-3">
		<%
			String admin = (String)session.getAttribute("nomeadmin");
			if(admin == null){
		%>
				<a class="p-2 text-dark" href="statistica.jsp">Visualizza Statistiche</a>
				<a class="p-2 text-dark" href="corsi.jsp">Visualizza Corsi</a>
				<a class="p-2 text-dark" href="gestioneadmin.jsp"><%=admin %></a>
				<a class="p-2 text-dark" href="logout.jsp">Log-out</a>
		<%
			}else{
		%>
				<a class="p-2 text-dark" href="statistica.jsp">Visualizza Statistiche</a>
				<a class="p-2 text-dark" href="corsi.jsp">Visualizza Corsi</a>
				<a class="p-2 text-dark" href="login.jsp">Login</a>
		<%
			}
		%>
	</div>
</div>