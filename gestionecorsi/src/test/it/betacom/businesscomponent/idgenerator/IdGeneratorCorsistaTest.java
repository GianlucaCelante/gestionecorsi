package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.idgenerator.IdGeneratorCorsista;

class IdGeneratorCorsistaTest {

	@Test
	void testNextId() {		
		try {		
			
			IdGeneratorCorsista idGen = IdGeneratorCorsista.getIstance();			
			assertNotNull(idGen, "Istanza create correttamente");			
			int valore = idGen.nextId();			
			assertEquals(valore, idGen.nextId() - 1, "Test sequenza");			
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();			
			fail("Sequenza non funzionante");
		}		
	}

}
