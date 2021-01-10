package it.betacom.businesscomponent;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.model.Amministratore;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;
import it.betacom.businesscomponent.model.Docente;

public class ClientFacade {

	private static ClientFacade istanza;

	private CorsistaBC corsistaBC;
	private DocenteBC docenteBC;
	private CorsoCorsistaBC corsoCorsistaBC;
	private AmministratoreBC amministratoreBC;
	private CorsoBC corsoBC;

	private ClientFacade() throws DAOException, ClassNotFoundException, IOException {

		corsoBC = new CorsoBC();
		corsistaBC = new CorsistaBC();
		docenteBC = new DocenteBC();
		corsoCorsistaBC = new CorsoCorsistaBC();
		amministratoreBC = new AmministratoreBC();
	}

	public static ClientFacade getIstance() throws DAOException, ClassNotFoundException, IOException {

		if (istanza == null) {

			istanza = new ClientFacade();

		}

		return istanza;

	}
	
	public void createCorso(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		
		corsoBC.createCorso(corso);
		
	}

	public void createCorsista(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {

		corsistaBC.create(corsista);

	}

	public void createCorsoCorsista(CorsoCorsista corsoCorsista) throws DAOException, ClassNotFoundException, IOException {

		corsoCorsistaBC.create(corsoCorsista);

	}
	
	public Corso getCorsoById(int codcorso) throws DAOException {
		
		return corsoBC.getCorsoById(codcorso);
	}
	
	public Corso[] getCorsi() throws DAOException {
		
		return corsoBC.getAll();
		
	}
	
	public Corso[] getCorsiAttivi() throws DAOException {
		
		return corsoBC.getCorsiAttivi();
		
	}

	public Corsista[] getCorsisti() throws DAOException {

		return corsistaBC.getCorsisti();

	}

	public Docente[] getDocenti() throws DAOException {

		return docenteBC.getDocenti();

	}
	
	public CorsoCorsista[] getCorsiCorsisti() throws DAOException {
		
		return corsoCorsistaBC.getAll();
		
	}
	
	public Corsista getCorsista(int codcorsista) throws DAOException {
		
		return corsistaBC.getCorsistaById(codcorsista);
		
	}
	
	public Amministratore getAmministratoreById(Integer id) throws DAOException {

		return amministratoreBC.getAmministratoreById(id);

	}
	
	public void deleteCorso(int codCorso) throws DAOException {
		
		corsoBC.deleteCorso(codCorso);
		
	}
	
	//modifiche francesco
	public Docente[] getDocentePiuCorsi() throws DAOException{
		return docenteBC.getDocentePiuCorsi();
	}
	
	public String[] getNomeCorsoPiuFrequentato() throws DAOException{
		return corsoBC.getNomeCorsoPiuFrequentato();
	}
	
	public String[] getDataInizioUltimoCorso() throws DAOException{
		return corsoBC.getDataInizioUltimoCorso();
	}
	
	public int getNumeroCommenti() throws DAOException{
		return corsoBC.getNumeroCommenti();
	}
	
	public Corso[] getCorsiDisponibili() throws DAOException{
		return corsoBC.getCorsiDisponibili();
	}
	
	public int getNumeroCorsisti() throws DAOException{
		return corsistaBC.getNumeroCorsisti();
	}

}
