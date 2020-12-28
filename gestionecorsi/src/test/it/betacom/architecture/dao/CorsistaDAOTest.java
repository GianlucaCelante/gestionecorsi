package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
import it.betacom.businesscomponent.ClientFacade;
import it.betacom.businesscomponent.model.Corsista;

public class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;
	
	@BeforeAll
	static void setUp() throws Exception{
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setNomeCorsista("Max");
		corsista.setCognomeCorsista("Rossi");
		corsista.setPrecedentiFormativi(0);
	}
	
	@Test
	void testGetAll() throws DAOException, ClassNotFoundException, IOException{
		conn=DBAccess.getConnection();
		try {
			Corsista[] corsista = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsista);
			for(Corsista cors : corsista) {
				System.out.println(cors);
			}
			System.out.println();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero ordine fallito");
		}
	}
	
	
	@Test
	void testCreateCorsista() {

		try {
			
			ClientFacade.getIstance().createCorsista(corsista);
			
			System.out.println("Corsista registrato");
			
			
		} catch (DAOException | ClassNotFoundException | IOException exc) {

			exc.printStackTrace();

			fail("Creazione corsista fallita test");

		}

	}
	
	
	@Test
	void testGetCodCorsisti() throws DAOException, ClassNotFoundException, IOException{
		conn=DBAccess.getConnection();
		try {
			int[] corsisti = CorsistaDAO.getFactory().getCodCorsisti(conn);

			for(int i = 0; i > corsisti.length; i++) {
				System.out.println(corsisti[i]);
			}
			System.out.println();
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero ordine fallito");
		}
	}
	
	@Test
	void testGetCorsista() throws DAOException, ClassNotFoundException, IOException{
		conn=DBAccess.getConnection();
		
		try {

			Corsista corsista = CorsistaDAO.getFactory().getCorsista(conn, 1);
			
			System.out.println(corsista.toString());
			
			
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Recupero ordine fallito");
		}
	}
	
	
	
	@AfterAll
	static void tearDown() throws Exception{
		
		try {



			Connection conn = DBAccess.getConnection();

			Statement stmt = conn.createStatement();

			stmt.executeUpdate("delete from corsista where codcorsista = " + corsista.getCodCorsista());

			conn.commit();
			
			conn.close();
			
			corsista = null;

			
		} catch (DAOException exc) {

			exc.printStackTrace();
			fail("Pulizia fallita");
		}
		
	
	}
}
