<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menuApp">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="menuApp">
			<%
				String user = (String)session.getAttribute("username");
				if(user == null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="registra.jsp">
						<span class="glyphicon glyphicon-user"></span> Inserisci corsista
					</a>
				</li>
				<li>
					<a href="registra.jsp">
						<span class="glyphicon glyphicon-user"></span> Visualizza statistica
					</a>
				</li>
				<li>
					<a href="registra.jsp">
						<span class="glyphicon glyphicon-user"></span> Elimina corsi
					</a>
				</li>
			</ul>
			<%
				}else{
			%>
			<ul class="nav navbar-nav">
				<li><a href="acquisti.jsp">Acquisti</a></li>
				<li><a href="visualizza.jsp">Riepilogo ordine</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="visualizza.jsp">
						<span class="glyphicon glyphicon-shopping-cart">&nbsp;</span>
					</a>
				</li>
				<li>
                    <div class="dropdown" style="margin-top: 8px">
                        <button class="btn dropdown-toggle" type="button"
                            data-toggle="dropdown"
                            style="background-color: #303030; color: #F9F9F9"><%=user%>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#" class="disabilita">Riepilogo dati</a></li>
                            <li><a href="user.jsp">Modifica utente</a></li>

                        </ul>
                    </div>
                </li>
				<li>
					<a href="logout.jsp">
						<span class="glyphicon glyphicon-off"></span> Logout
					</a>
				</li>
			</ul>
			<%
				}
			%>
		</div>
	</div>
</nav>