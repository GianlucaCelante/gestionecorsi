package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import it.betacom.architecture.dao.AmministratoreDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.model.Amministratore;

public class AmministratoreBC {
	private Connection conn;
	public AmministratoreBC() throws DAOException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
	}
	public Amministratore getAmministratoreById(Integer id) throws DAOException {
		return AmministratoreDAO.getFactory().getById(conn, id);
	}
}
