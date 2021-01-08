package it.betacom.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;

public class ValidaCorso {
	private Connection conn;
	
	public ValidaCorso() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public boolean validaCorso(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String nome = request.getParameter("nome");
		String inizio = request.getParameter("inizio");
		String fine = request.getParameter("fine");
		String costo = request.getParameter("costo");
		String commento = request.getParameter("commenti");

		String aula = request.getParameter("aula");
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(aula);
		boolean checkSpecialCharacter = matcher.find();
		try {
			if (nome.isEmpty() || nome.matches(".*\\d+.*") || nome.length() > 30) {
				session.setAttribute("errorNomeCorso", "Nome non conforme");
				response.sendRedirect("registracorso.jsp");
				return false;
			} else if (inizio.isEmpty() || fine.isEmpty() || ChronoUnit.DAYS.between(formato.parse(inizio).toInstant(),
				formato.parse(fine).toInstant()) < 2) {
				session.setAttribute("errorDataCorso", "Date troppo vicine o non conformi");
				response.sendRedirect("registracorso.jsp");
				return false;
			} else if (costo.isEmpty()) {
				session.setAttribute("errorCostoCorso", "Inserire costo");
				response.sendRedirect("registracorso.jsp");
				return false;
			} else if (commento.length() > 200) {
				session.setAttribute("errorCommentoCorso", "Commento troppo lungo");
				response.sendRedirect("registracorso.jsp");
				return false;
			} else if (checkSpecialCharacter || aula.length() > 30) {
				session.setAttribute("errorAulaCorso", "Aula non conforme");
				response.sendRedirect("registracorso.jsp");
				return false;
			} else {
				return true;
			}
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
