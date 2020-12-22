package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DBAccess;

class DBAccessTest {

	@Test
	void testConnection() {

		try {

			DBAccess.getConnection();

		} catch (DAOException | ClassNotFoundException | IOException e) {

			e.printStackTrace();

			fail(e.getMessage());

		} finally {

			try {

				DBAccess.closeConnection();

			} catch (DAOException e) {

				e.printStackTrace();
				fail("Errore nel tentativo di chiusura");

			}

		}
	}
}
