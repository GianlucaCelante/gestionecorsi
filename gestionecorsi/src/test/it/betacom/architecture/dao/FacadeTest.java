package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.ClientFacade;
import it.betacom.businesscomponent.model.Amministratore;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;
import it.betacom.businesscomponent.model.Docente;

class FacadeTest {

	private static Corsista corsista;
	private static Corso corso;
	private static CorsoCorsista corsoCorsista;

	@BeforeEach
	void setUp() throws Exception {

		corsista = new Corsista();
		corsista.setNomeCorsista("mario");
		corsista.setCognomeCorsista("gialli");
		corsista.setPrecedentiFormativi(0);
		
		corso = new Corso();
		corso.setNomeCorso("aaa");
		corso.setDataInizioCorso(new Date());
		corso.setDataFineCorso(new Date());
		corso.setCostoCorso(1.0);
		corso.setAulaCorso("aula");
		corso.setCommentiCorso("descrizione");
		corso.setCodDocente(1);
		
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setCodCorso(1);
		corsoCorsista.setCodCorsista(1);
		
	}

	@AfterEach
	void tearDown() throws Exception {

		try {

			Connection conn = DBAccess.getConnection();

			Statement stmt = conn.createStatement();

			stmt.executeUpdate("delete from corsista where codcorsista = " + corsista.getCodCorsista());
			
			conn.commit();

			conn.close();

			corsista = null;
			corso = null;

		} catch (DAOException exc) {

			exc.printStackTrace();
			fail("Creazione corsista fallita");
		}

	}
	
	@Test
	void testGetDocenti() {

		try {

			Docente[] docs = ClientFacade.getIstance().getDocenti();
			
			for(Docente d: docs) {
				
				System.out.println(d.toString());
				
			}
			

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Recupero amministratore fallito");

		}
	}
	
	@Test
	void testGetAmministratoreById() {

		try {

			Amministratore amm = ClientFacade.getIstance().getAmministratoreById(1);
			System.out.println(amm.toString());

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Recupero amministratore fallito");

		}
	}
	
	@Test
	void testCreateCorsoCorsista() {

		try {

			ClientFacade.getIstance().createCorsoCorsista(corso, corsista);

			System.out.println("Corso registrato " + corso.toString() + ", Corsista registrato " + corsista.toString());

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Creazione corso fallita test");

		}

	}

	@Test
	void testCreateAndDeleteCorsista() {

		try {

			ClientFacade.getIstance().createCorsista(corsista);

			System.out.println("Corsista registrato" + corsista.toString());
			
			ClientFacade.getIstance().deleteCorso(corso.getCodCorso());
			
			System.out.println("Corso eliminato");

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Creazione corsista fallita test");

		}

	}
	
	@Test
	void testCreateCorso() {

		try {

			ClientFacade.getIstance().createCorso(corso);

			System.out.println("Corso registrato " + corso.toString());

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Creazione corso fallita test");

		}

	}

	@Test
	void testGetCorsisti() {

		try {

			Corsista[] corsisti = ClientFacade.getIstance().getCorsisti();

			for(Corsista c : corsisti) {
				
				System.out.println("Corsisti:" + c.toString());
			}

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Creazione corsista fallita test");

		}

	}
	
	@Test
	void testgetCorsiCorsisti() {

		try {

			CorsoCorsista[] corsiCorsisti = ClientFacade.getIstance().getCorsiCorsisti();

			for(CorsoCorsista c : corsiCorsisti) {
				
				System.out.println("Corsisti:" + c.toString());
			}

		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Creazione corsista fallita test");

		}

	}

}
