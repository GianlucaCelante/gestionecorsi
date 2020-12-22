package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.businesscomponent.model.Amministratore;

public class AmministratoreDAO implements DAOConstants{
	public static AmministratoreDAO getFactory() throws DAOException{
		return new AmministratoreDAO();
	}
	
	public Amministratore getById(Connection conn, int id) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_AMMINISTRATORE_BYID);
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			Amministratore amm= null;
			if(rs.next()) {
				amm= new Amministratore();
				amm.setNomeAdmin(rs.getString(1));
				amm.setCognomeAdmin(rs.getString(2));
				amm.setCodAdmin(rs.getInt(3));
				amm.setPassword(rs.getString(4));
			}
			return amm;
		}catch(SQLException exc) {
			throw new DAOException(exc);
		}
	}
}
