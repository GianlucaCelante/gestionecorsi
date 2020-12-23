package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;
	
	public CorsoCorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void create(CorsoCorsista entity) throws DAOException, ClassNotFoundException, IOException {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, entity);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public CorsoCorsista[] getAll() throws DAOException{
		CorsoCorsista[] corsiCorsisti = null;
		try {
			corsiCorsisti = CorsoCorsistaDAO.getFactory().getAll(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsiCorsisti;
	}
}
