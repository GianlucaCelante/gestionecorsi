package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.idgenerator.IdGeneratorCorsista;
import it.betacom.businesscomponent.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	private IdGeneratorCorsista idGen;
	
	public CorsistaBC() throws DAOException, ClassNotFoundException, IOException {
		conn=DBAccess.getConnection();
	}
	
	public void create(Corsista corsista) throws DAOException, ClassNotFoundException, IOException{
		try {
		
			CorsistaDAO.getFactory().create(conn, corsista);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corsista getCorsistaById(int codcorsista) throws DAOException{
		
		Corsista corsista = null;
		
		try {
			
			corsista = CorsistaDAO.getFactory().getCorsista(conn, codcorsista);
			
			
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
		
		
	}
	
	public Corsista[] getCorsisti() throws DAOException {
		Corsista[] corsista=null;
		try {
			corsista=CorsistaDAO.getFactory().getAll(conn);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}
	
	//modifiche francesco
	public int getNumeroCorsisti() throws DAOException{
		int nCorsisti = 0;
		try {
			nCorsisti = CorsistaDAO.getFactory().getNumeroCorsisti(conn);
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return nCorsisti;
	}
}
