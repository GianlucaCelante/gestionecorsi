package test.it.betacom.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.model.Corso;

public class CorsoDAOTest {
	private static Corso corso;
	private static Connection conn;
	
	@BeforeAll
	static void setUp() throws Exception{
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setCodDocente(1);
		corso.setNomeCorso("pilates");
		corso.setDataInizioCorso(new Date());
		corso.setDataFineCorso(new Date());
		corso.setCostoCorso(550.00);
		corso.setCommentiCorso("commento");
		corso.setAulaCorso("Lum250");
		corso.setPostiDisp(1);
	}
	
	@Test
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("creato corso");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("creazione corso fallita");
		}
	}
	
	
	
	@Test
	void testGetAll() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
			
			for(Corso c: corsi) {
				
				System.out.println(c.toString());
			}
			
			assertNotNull(corsi);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("creazione articolo fallita");
		}
	}

	//modifiche francesco
	@Test
	void testNomeCorsoPiuFrequentato() {
		try {
			String[] corsi = CorsoDAO.getFactory().getNomeCorsoPiuFrequentato(conn);
			assertNotNull(corsi);
			for(int i = 0; i<corsi.length; i++) {
				System.out.println("corso più frequentato: "+corsi[i]);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			fail("creazione articolo fallita");
		}
	}
	
	@Test
	void testDataInizioUltimoCorso() {
		try {
			String[] corsi = CorsoDAO.getFactory().getDataInizioUltimoCorso(conn);
			assertNotNull(corsi);
			for(int i = 0; i<corsi.length; i++) {
				System.out.println("nome ultimo corso: "+corsi[i]);
				System.out.println("data ultimo corso: "+corsi[i+1]);
				i++;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			fail("creazione articolo fallita");
		}
	}
	
	@Test
	void testNumeroCommenti() {
		try {
			int nCommenti = CorsoDAO.getFactory().getNumeroCommenti(conn);
			System.out.println("numero commenti: "+nCommenti);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("creazione articolo fallita");
		}
	}
	
	@Test
	void testCorsiDisponibili() {
		try {
			Corso[] corsi = CorsoDAO.getFactory().getCorsiDisponibili(conn);
			assertNotNull(corsi);
			for(int i = 0; i<corsi.length; i++) {
				System.out.println("nome corso disponibile: "+corsi[i].getNomeCorso());
			}
		} catch (DAOException e) {
			e.printStackTrace();
			fail("creazione articolo fallita");
		}
	}
	//fine modifiche
	
	@AfterAll
	static void cleanUp() throws Exception{
		try {
			CorsoDAO.getFactory().delete(conn, corso.getCodCorso());
			corso = null;
			conn.commit();
			System.out.println("eliminato corso");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("eliminazione corso fallita");
		}
	}
}
