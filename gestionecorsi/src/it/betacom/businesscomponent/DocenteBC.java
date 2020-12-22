package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.businesscomponent.model.Docente;

public class DocenteBC {
private Connection conn;
	
	public DocenteBC() throws DAOException, ClassNotFoundException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public Docente[] getDocenti() throws DAOException {
		Docente[] docenti=null;
		try {
			docenti=DocenteDAO.getFactory().getAll(conn);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}
}
