package it.betacom.businesscomponent.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.AmministratoreBC;
import it.betacom.businesscomponent.model.Amministratore;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = -8089312366544654746L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String codice = request.getParameter("codice");
		String password = request.getParameter("password");
		if(codice != null && password != null) {
			try {
				if(isInt(codice)) {
					int cod=Integer.parseInt(codice);
					AmministratoreBC ammBC = new AmministratoreBC();
					Amministratore amm = ammBC.getAmministratoreById(cod);
					if (amm != null && amm.getPassword().equals(password)) {
						session.setAttribute("admin", amm.getNomeAdmin());
						response.sendRedirect("registra.jsp");
					}else gestisciErrore(session, response);
				}
				else {
					gestisciErrore(session, response);
				}
			}catch(DAOException | ClassNotFoundException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}else {
			response.sendRedirect("index.jsp");
		}
	}
	private void gestisciErrore(HttpSession session, HttpServletResponse response) throws IOException {
		if(session.getAttribute("tentativi")== null) {
			session.setAttribute("tentativi", 4);
			response.sendRedirect("index.jsp");
		}else {
			int t= (int)session.getAttribute("tentativi");
			t--;
			if (t<=0)
				response.sendRedirect("errorelogin.html");
			else {
				session.setAttribute("tentativi", t);
				response.sendRedirect("index.jsp");
			}
		}
		
	}
	 private boolean isInt(String str){
	     try{
	         Integer.parseInt(str);
	         return true;
	     }catch(NumberFormatException nfe){
	         return false;
	     }
	 }
}
