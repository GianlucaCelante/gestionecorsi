package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.Corso;

public class CorsoDAO implements DAOConstants{
	private CachedRowSet rw;
	
	public static CorsoDAO getFactory() throws DAOException {
		return new CorsoDAO();
	}
	
	private CorsoDAO() throws DAOException{
		try {
			rw = RowSetProvider.newFactory().createCachedRowSet();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rw.setCommand(SELECT_CORSO);
			rw.execute(conn);
			rw.moveToInsertRow();
			rw.updateInt(1, entity.getCodCorso());
			rw.updateInt(2, entity.getCodDocente());
			rw.updateString(3, entity.getNomeCorso());
			rw.updateDate(4, new java.sql.Date(entity.getDataInizioCorso().getTime()));
			rw.updateDate(5, new java.sql.Date(entity.getDataFineCorso().getTime()));
			rw.updateDouble(6, entity.getCostoCorso());
			rw.updateString(7, entity.getCommentiCorso());
			rw.updateString(8, entity.getAulaCorso());
			rw.updateInt(9,  entity.getPostiDisp());
			rw.insertRow();
			rw.moveToCurrentRow();
			rw.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
	}
	
	public void delete(Connection conn, int codCorso) throws DAOException{
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setInt(1, codCorso);
			ps.execute();
			conn.commit();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corso[] getAll(Connection conn) throws DAOException{
			Corso[] corsi = null;
			try {
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(SELECT_CORSO);
				rs.last();
				corsi = new Corso[rs.getRow()];
				rs.beforeFirst();
				for(int i = 0; rs.next(); i++) {
					Corso c = new Corso();
					c.setCodCorso(rs.getInt(1));
					c.setCodDocente(rs.getInt(2));
					c.setNomeCorso(rs.getString(3));
					c.setDataInizioCorso(new java.util.Date(rs.getDate(4).getTime()));
					c.setDataFineCorso(new java.util.Date(rs.getDate(5).getTime()));
					c.setCostoCorso(rs.getDouble(6));
					c.setCommentiCorso(rs.getString(7));
					c.setAulaCorso(rs.getString(8));
					c.setPostiDisp(rs.getInt(9));
					corsi[i] = c;
				}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	public Corso getCorso(Connection conn, int codcorso) throws DAOException {
		
		Corso corso = null;
		
		PreparedStatement ps;
		
		try {
			
			ps = conn.prepareStatement(SELECT_CORSO_BYID);
			ps.setLong(1, codcorso);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				corso = new Corso();
				corso.setCodCorso(rs.getInt(1));
				corso.setCodDocente(rs.getInt(2));
				corso.setNomeCorso(rs.getString(3));
				corso.setDataInizioCorso(new java.util.Date(rs.getDate(4).getTime()));
				corso.setDataFineCorso(new java.util.Date(rs.getDate(5).getTime()));
				corso.setCostoCorso(rs.getDouble(6));
				corso.setCommentiCorso(rs.getString(7));
				corso.setAulaCorso(rs.getString(8));
				corso.setPostiDisp(rs.getInt(9));
				
			}
			
		} catch (SQLException sql) {
				
			throw new DAOException(sql);
		}
			
			
		return corso;
		
		
	}
}

