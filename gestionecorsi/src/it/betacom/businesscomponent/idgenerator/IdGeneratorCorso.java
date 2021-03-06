package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;

public class IdGeneratorCorso implements IdGeneratorInterface, DAOConstants {

	private static IdGeneratorCorso idGenerator;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private IdGeneratorCorso() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static IdGeneratorCorso getIstance() throws DAOException, ClassNotFoundException, IOException {
		if (idGenerator == null) {
			idGenerator = new IdGeneratorCorso();
		}
		return idGenerator;
	}

	@Override
	public int nextId() throws DAOException, ClassNotFoundException, IOException {
		int id = 0;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSOSEQ);
			rs.next();
			id = rs.getInt(1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return id;
	}
}
