package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaDaoTest {

	private static CorsoCorsista cc;	
	
	@BeforeEach
	void setUp() throws Exception{
		cc = new CorsoCorsista();
		cc.setCodCorso(1);
		cc.setCodCorsista(1);
	}

	@Test
	void testCreate() {
		try {
			CorsoCorsistaDAO.getFactory().create(DBAccess.getConnection(), cc);
			System.out.println("ordine registrato");
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("create ordine_articolo fallito");
		}
	}
	
	@AfterEach
	void tearDown() throws Exception{
		try {
			cc = null;
			Connection conn = DBAccess.getConnection();
			Statement stmt = conn.createStatement();
			stmt.execute("delete from corso_corsista where codcorso = 1 and codcorsista = 1");
			conn.commit();
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Pulizia fallita");
		}
		
	}

}
