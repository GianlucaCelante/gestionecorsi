package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.businesscomponent.model.Docente;

public class DocenteDAO implements DAOConstants {

	public static DocenteDAO getFactory() throws DAOException {
		return new DocenteDAO();
	}

	public Docente[] getAll(Connection conn) throws DAOException {
		Docente[] docenti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE);
			rs.last();
			docenti = new Docente[rs.getRow()];
			rs.beforeFirst();

			for (int i = 0; rs.next(); i++) {
				Docente docente = new Docente();
				docente.setNomeDocente(rs.getString(1));
				docente.setCognomeDocente(rs.getString(2));
				docente.setCvDocente(rs.getString(3));
				docente.setCodDocente(rs.getInt(4));
				docenti[i] = docente;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}
}
