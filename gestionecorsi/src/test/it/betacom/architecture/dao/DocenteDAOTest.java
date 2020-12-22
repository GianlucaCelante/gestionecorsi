package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.businesscomponent.model.Docente;

class DocenteDAOTest {
	private static Connection conn;	


	@Test
	void testGetAll() throws DAOException, ClassNotFoundException, IOException{
		conn=DBAccess.getConnection();
		try {
			Docente[] docenti=DocenteDAO.getFactory().getAll(conn);
			assertNotNull(docenti);
			for(Docente d:docenti) {
				System.out.println(d);
			}
			System.out.println();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero ordine fallito");
		}
	}
}

