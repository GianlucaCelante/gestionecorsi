package it.betacom.businesscomponent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.ClientFacade;


@WebServlet("/rimuovi")
public class RimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codCorso = Integer.parseInt(request.getParameter("codCorso"));
		
		try {
			ClientFacade.getIstance().deleteCorso(codCorso);
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
        response.sendRedirect("deletecorso.jsp");
    }

}
