package it.betacom.businesscomponent.model;

public class Corsista {
	private String nomeCorsista;
	private String cognomeCorsista;
	private int codCorsista;
	private int precedentiFormativi;
	
	public String getNomeCorsista() {
		return nomeCorsista;
	}
	
	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}
	
	public String getCognomeCorsista() {
		return cognomeCorsista;
	}
	
	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}
	
	public int getCodCorsista() {
		return codCorsista;
	}
	
	public void setCodCorsista(int codCorsista) {
		this.codCorsista = codCorsista;
	}
	
	public int getPrecedentiFormativi() {
		return precedentiFormativi;
	}
	
	public void setPrecedentiFormativi(int precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}
	
	@Override
	public String toString() {
		return "Corsista [nomeCorsista=" + nomeCorsista + ", cognomeCorsista=" + cognomeCorsista + ", codCorsista="
				+ codCorsista + ", precedentiFormativi=" + precedentiFormativi + "]";
	}
}
