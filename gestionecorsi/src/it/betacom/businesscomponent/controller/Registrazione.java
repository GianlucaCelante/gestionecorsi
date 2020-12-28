package it.betacom.businesscomponent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.businesscomponent.model.Amministratore;

@WebServlet("/registra")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = -8089312366544654746L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Amministratore amm = new Amministratore();
		try {
			amm.setNomeAdmin(request.getParameter("nomeAdmin"));
			amm.setCognomeAdmin(request.getParameter("cognomeAdmin"));
			int codAdmin = Integer.parseInt(request.getParameter("codAdmin"));
			amm.setCodAdmin(codAdmin);
			amm.setPassword(request.getParameter("password"));
			session.setAttribute("codAdmin", codAdmin);
			response.sendRedirect("index.jsp");
		}catch (IOException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
