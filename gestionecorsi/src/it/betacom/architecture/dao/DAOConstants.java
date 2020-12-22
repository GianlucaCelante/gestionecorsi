package it.betacom.architecture.dao;

public interface DAOConstants {
	String SELECT_CORSOCORSISTA = "select * from corso_corsista";
	String SELECT_CORSO = "select * from corso";
	String SELECT_CORSISTA = "select * from corsista";
	String SELECT_DOCENTE = "select * from docente";
	
	String DELETE_CORSO = "delete from corso where codcorso = ?";
	
	String SELECT_AMMINISTRATORE_BYID = "select * from amministratore where codadmin = ?";
	
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "select corsista_seq.nextval from dual";
}
