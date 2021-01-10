package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.Corsista;

public class CorsistaDAO implements DAOConstants {
	private CachedRowSet rowSet;

	public static CorsistaDAO getFactory() throws DAOException {
		return new CorsistaDAO();
	}

	private CorsistaDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void create(Connection conn, Corsista entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNomeCorsista());
			rowSet.updateString(2, entity.getCognomeCorsista());
			rowSet.updateInt(3, entity.getCodCorsista());
			rowSet.updateInt(4, entity.getPrecedentiFormativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corsista[] getAll(Connection conn) throws DAOException {
		Corsista[] corsista = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);
			rs.last();

			corsista = new Corsista[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corsista cors = new Corsista();
				cors.setNomeCorsista(rs.getString(1));
				cors.setCognomeCorsista(rs.getString(2));
				cors.setCodCorsista(rs.getInt(3));
				cors.setPrecedentiFormativi(rs.getInt(4));
				corsista[i] = cors;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsista;
	}
	
	public Corsista getCorsista(Connection conn, int codcorsista) throws DAOException {
		
		Corsista corsista = null;
		
		PreparedStatement ps;
		
		try {
			
			ps = conn.prepareStatement(SELECT_CORSISTA_BYID);
			ps.setLong(1, codcorsista);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				corsista = new Corsista();
				corsista.setNomeCorsista(rs.getString(1));
				corsista.setCognomeCorsista(rs.getString(2));
				corsista.setCodCorsista(rs.getInt(3));
				corsista.setPrecedentiFormativi(rs.getInt(4));
				
			}
			
		} catch (SQLException sql) {
				
			throw new DAOException(sql);
		}
			
			
		return corsista;
		
		
	}
	
	//modifiche francesco
	public int getNumeroCorsisti(Connection conn) throws DAOException{
		int nCorsisti = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_TOT_CORSISTI);
			if(rs.next())
				nCorsisti = rs.getInt(1);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return nCorsisti;
	}
}