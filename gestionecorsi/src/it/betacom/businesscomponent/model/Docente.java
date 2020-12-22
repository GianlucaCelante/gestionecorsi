package it.betacom.businesscomponent.model;

public class Docente {
	String nomeDocente;
	String cognomeDocente;
	String cvDocente;
	int codDocente;
	
	public String getNomeDocente() {
		return nomeDocente;
	}
	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}
	public String getCognomeDocente() {
		return cognomeDocente;
	}
	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}
	public String getCvDocente() {
		return cvDocente;
	}
	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}
	public int getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}
	
	@Override
	public String toString() {
		return "Docente [nomeDocente=" + nomeDocente + ", cognomeDocente=" + cognomeDocente + ", cvDocente=" + cvDocente
				+ ", codDocente=" + codDocente + "]";
	}
	
	
	
}
