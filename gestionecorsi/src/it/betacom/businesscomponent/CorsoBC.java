package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.DBAccess;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;

import it.betacom.businesscomponent.idgenerator.IdGeneratorCorso;
import it.betacom.businesscomponent.model.Corso;

public class CorsoBC {
	private Connection conn;
	private IdGeneratorCorso idGenerator;
	
	public CorsoBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public void createCorso(Corso c) throws DAOException, ClassNotFoundException, IOException {
		try {
			idGenerator = IdGeneratorCorso.getIstance();
			c.setCodCorso(idGenerator.nextId());
			CorsoDAO.getFactory().create(conn, c);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public void deleteCorso(int codCorso) throws DAOException{
		try {
			CorsoDAO.getFactory().delete(conn, codCorso);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
	
	public Corso getCorsoById(int codcorso) throws DAOException {
		
		Corso corso = null;
		
		try {
			
			
			corso = CorsoDAO.getFactory().getCorso(conn, codcorso);
			
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		
		return corso;
		
	}
	
	public Corso[] getAll() throws DAOException{
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	public Corso[] getCorsiAttivi() throws DAOException{
		Corso[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getCorsiAttivi(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	//modifiche francesco
	public String[] getNomeCorsoPiuFrequentato() throws DAOException{
		String[] nomeCorsi = null;
		try {
			nomeCorsi = CorsoDAO.getFactory().getNomeCorsoPiuFrequentato(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return nomeCorsi;
	}
	
	public String[] getDataInizioUltimoCorso() throws DAOException{
		String[] corsi = null;
		try {
			corsi = CorsoDAO.getFactory().getDataInizioUltimoCorso(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	public int getNumeroCommenti() throws DAOException{
		int nCommenti = 0;
		try {
			nCommenti = CorsoDAO.getFactory().getNumeroCommenti(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return nCommenti;
	}
	
	public Corso[] getCorsiDisponibili() throws DAOException{
		Corso[] corsiDisponibili = null;
		try {
			corsiDisponibili = CorsoDAO.getFactory().getCorsiDisponibili(conn);
		} catch(SQLException sql){
			throw new DAOException(sql);
		}
		return corsiDisponibili;
	}
}
