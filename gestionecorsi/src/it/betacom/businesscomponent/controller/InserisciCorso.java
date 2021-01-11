package it.betacom.businesscomponent.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.ClientFacade;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.utilities.ValidaCorso;

@WebServlet("/salvacorso")
public class InserisciCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Corso corso = new Corso();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		ValidaCorso controllo;
		try {
			controllo = new ValidaCorso();
		
			if (controllo.validaCorso(request, response)) {
				corso.setCodDocente(Integer.parseInt(request.getParameter("coddocente")));
				corso.setNomeCorso(request.getParameter("nome"));
				corso.setDataInizioCorso(formato.parse(request.getParameter("inizio")));
				corso.setDataFineCorso(formato.parse(request.getParameter("fine")));
				corso.setCostoCorso(Integer.parseInt(request.getParameter("costo")));
				corso.setCommentiCorso(request.getParameter("commenti"));
				corso.setAulaCorso(request.getParameter("aula"));
				corso.setPostiDisp(12);
						
				ClientFacade.getIstance().createCorso(corso);
						
				response.sendRedirect("deletecorso.jsp");
			}
		} catch (DAOException | ClassNotFoundException | IOException | ParseException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}


}

}
