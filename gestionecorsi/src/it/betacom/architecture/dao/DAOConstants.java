package it.betacom.architecture.dao;

public interface DAOConstants {
	String SELECT_CORSOCORSISTA = "select * from corso_corsista";
	String SELECT_CORSO = "select * from corso";
	String SELECT_CORSISTA = "select * from corsista";
	String SELECT_DOCENTE = "select * from docente";
	
	String DELETE_CORSO = "delete from corso where codcorso = ?";
	
	String SELECT_CORSISTA_BYID = "select * from corsista where codcorsista = ?";
	String SELECT_CORSO_BYID = "select * from corso where codcorso = ?";
	String SELECT_AMMINISTRATORE_BYID = "select * from amministratore where codadmin = ?";
	String SELECT_CORSO_ASSOCIATO_CORSISTI = "select codcorso from corso_corsista where codcorsista = ?";
	
	String SELECT_CORSISTI_CORSI_ATTIVI = "select codcorsista from corsista where codcorsista in (select codcorsista from corso_corsista where codcorso in (select codcorso from corso where (datainiziocorso<=sysdate and datafinecorso>sysdate)))";
	String SELECT_CORSI_ATTIVI = "select * from corso where (datainiziocorso<=sysdate and datafinecorso>sysdate)";
	
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "select corsista_seq.nextval from dual";
	String SELECT_CORSISTA_VAL_ATTUALE = "select corsista_seq from dual";
	
	//modifiche francesco
	String SELECT_CORSO_PIU_FREQUENTATO = "select nomecorso from corso where postidisp=(select min(postidisp) from corso)";
	String SELECT_NUMERO_COMMENTI = "select count(commenticorso) from corso";
	String SELECT_CORSI_DISPONIBILI = "select * from corso where postidisp>0";
	String SELECT_ULTIMO_CORSO = "select nomecorso,datainiziocorso from corso where datainiziocorso=(select max(datainiziocorso) from corso)";//"select max(datainiziocorso) from corso";
	
	String SELECT_TOT_CORSISTI = "select count(codcorsista) from corsista";
	
	String SELECT_DOCENTE_CORSI = "select * from docente where coddocente=(select coddocente from corso where (select count(coddocente) from corso group by coddocente)>1 group by coddocente)";

}
