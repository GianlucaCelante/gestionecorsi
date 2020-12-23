package it.betacom.architecture.dao;

import java.sql.SQLException;

//classe centralizzata per gestire qui le eccezioni sql
public class DAOException extends SQLException{

	private static final long serialVersionUID = -8799817260555073920L;

	//codice d'errore username o password sbagliate
	private static final int ORA1017 = 1017;
	
	//codice d'errore quando non riesce a connettersi al db, IOException di Oracle 
	private static final int ORA17002 = 17002;
	
	//codice errore violazione vincolo
	private static final int ORA00001 = 0;

	
	private String message;
	
	@Override
	public String getMessage() {
		
		return message;
	}

	public DAOException(SQLException sql) {
		
		String chiave = "";
		
		if(sql != null) {
			
			switch(sql.getErrorCode()) {
			
			
			case ORA1017:
				
				chiave = "Username/password errati";
				
				log(sql);
				
				break;
				
				
			case ORA17002:
				
				chiave = "IOException di Oracle DB.Impossibile connettersi";
				
				log(sql);
				
				break;
				
				
			case ORA00001:
				
				chiave = "Vincolo di tabella violato";
				
				log(sql);
				
				break;
				
				
			default:
				
				chiave = "Eccezione sql non prevista";
				log(sql);
			
			}
		}
		
		message = chiave;
		
	}

	private void log(SQLException sql) {

		sql.printStackTrace();
		
		System.err.println("Motivo: " + sql.getMessage());
		System.err.println("Stato app: " + sql.getSQLState());
		System.err.println("Codice errore: " + sql.getErrorCode());
		System.err.println("Causa del problema: " + sql.getCause());
	}	
}