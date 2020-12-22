package it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;

class IdGeneratorCorsoTest {

	@Test
	void testNextId() {		
		try {		
			IdGeneratorCorso idGen = IdGeneratorCorso.getIstance();			
			assertNotNull(idGen, "Istanza create correttamente");			
			long valore = idGen.nextId();			
			assertEquals(valore, idGen.nextId() - 1, "Test sequenza");			
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();			
			fail("Sequenza non funzionante");
		}		
	}

}