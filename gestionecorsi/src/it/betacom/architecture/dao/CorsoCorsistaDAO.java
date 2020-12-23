package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements DAOConstants {
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

	public CorsoCorsista[] getAll(Connection conn) throws DAOException {
		CorsoCorsista[] corsiCorsisti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSOCORSISTA);
			rs.last();
			corsiCorsisti = new CorsoCorsista[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				CorsoCorsista c = new CorsoCorsista();
				c.setCodCorso(rs.getInt(1));
				c.setCodCorsista(rs.getInt(2));
				corsiCorsisti[i] = c;
			}
			
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsiCorsisti;
	}
}
