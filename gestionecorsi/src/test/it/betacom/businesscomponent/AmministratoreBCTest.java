package test.it.betacom.businesscomponent;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.AmministratoreBC;
import it.betacom.businesscomponent.model.Amministratore;

public class AmministratoreBCTest {
	private static Connection conn;
	private static Amministratore amm;
	
	@BeforeAll
	static void setUp() throws Exception{
		amm = new Amministratore();
		conn = DBAccess.getConnection();
	}
	
	@Test
	void testGetById() throws ClassNotFoundException, IOException {
		try {
			AmministratoreBC ammBC= new AmministratoreBC();
			amm = ammBC.getAmministratoreById(1);
			assertNotNull(amm);
			System.out.println(amm.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero ordini fallito");
		}
	}
	@Test
	void testGetById2() throws ClassNotFoundException, IOException {
		try {
			AmministratoreBC ammBC= new AmministratoreBC();
			amm = ammBC.getAmministratoreById(-1);
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
