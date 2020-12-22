package test.it.betacom.architecture.dao;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.AmministratoreDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.model.Amministratore;

public class AmministratoreDAOTest {
	private static Connection conn;
	private static Amministratore amm;
	
	@BeforeAll
	static void setUp() throws Exception{
		amm = new Amministratore();
		conn = DBAccess.getConnection();
	}
	
	@Test
	void testGetById() {
		try {
			amm = AmministratoreDAO.getFactory().getById(conn, 1);
			assertNotNull(amm);
			System.out.println(amm.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero ordini fallito");
		}
	}
	@Test
	void testGetById2() {
		try {
			amm = AmministratoreDAO.getFactory().getById(conn, 0);
			assertNull(amm);
		}catch(DAOException exc) {
			exc.printStackTrace();
		}
	}
	@AfterAll
	static void tearDown() throws Exception {
		if(conn != null) DBAccess.closeConnection();		
	}
}
