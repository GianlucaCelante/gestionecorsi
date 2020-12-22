package it.betacom.businesscomponent.model;

public class Amministratore {
	private String nomeAdmin;
	private String cognomeAdmin;
	private int codAdmin;
	private String password;
	
	
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}
	public String getCognomeAdmin() {
		return cognomeAdmin;
	}
	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}
	public int getCodAdmin() {
		return codAdmin;
	}
	public void setCodAdmin(int codAdmin) {
		this.codAdmin = codAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Amministratore [nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin + ", codAdmin=" + codAdmin
				+ ", password=" + password + "]";
	}
	
	
	
}
