package it.betacom.businesscomponent.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.ClientFacade;
import it.betacom.businesscomponent.idgenerator.IdGeneratorCorsista;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;

@WebServlet("/registra")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = -8089312366544654746L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	
			IdGeneratorCorsista idGen =  IdGeneratorCorsista.getIstance();
			int idCorso = Integer.parseInt(request.getParameter("corso"));
			Corso corso = ClientFacade.getIstance().getCorsoById(idCorso);
			
			int codCorsista = idGen.nextId();
			Corsista corsista = new Corsista();
			corsista.setCodCorsista(codCorsista);
			corsista.setNomeCorsista(request.getParameter("nomeCorsista"));
			corsista.setCognomeCorsista(request.getParameter("cognomeCorsista"));
			int precedentiFormativi = Integer.parseInt(request.getParameter("radio"));
			corsista.setPrecedentiFormativi(precedentiFormativi);
			ClientFacade.getIstance().createCorsista(corsista);
			ClientFacade.getIstance().createCorsoCorsista(corso, corsista);
			response.sendRedirect("home.jsp");
		}catch (IOException | DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
