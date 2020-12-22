package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long nextId() throws DAOException, ClassNotFoundException, IOException;
}
