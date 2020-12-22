package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;
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
		corsista.setCodCorsista(1);
		corsista.setPrecedentiFormativi(true);
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
}
