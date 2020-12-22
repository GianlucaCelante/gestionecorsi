package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	public static CorsoCorsistaDAO getFactory() throws DAOException {
		return new CorsoCorsistaDAO();
	}
	
	private CorsoCorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void create(Connection conn, CorsoCorsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSOCORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateInt(1, entity.getCodCorso());
			rowSet.updateInt(2, entity.getCodCorsista());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
