package it.betacom.businesscomponent.model;

import java.util.Date;

import javax.servlet.http.HttpSession;

public class Corso {
	private int codCorso;
	private int codDocente;
	private String nomeCorso;
	private Date dataInizioCorso;
	private Date dataFineCorso;
	private double costoCorso;
	private String commentiCorso;
	private String aulaCorso;
	private int postiDisp;
	
	public int getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(int codCorso) {
		this.codCorso = codCorso;
	}
	public int getCodDocente() {
		return codDocente;
	}
	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public Date getDataInizioCorso() {
		return dataInizioCorso;
	}
	public void setDataInizioCorso(Date dataInizioCorso) {
		this.dataInizioCorso = dataInizioCorso;
	}
	public Date getDataFineCorso() {
		return dataFineCorso;
	}
	public void setDataFineCorso(Date dataFineCorso) {
		this.dataFineCorso = dataFineCorso;
	}
	public double getCostoCorso() {
		return costoCorso;
	}
	public void setCostoCorso(double costoCorso) {
		this.costoCorso = costoCorso;
	}
	public String getCommentiCorso() {
		return commentiCorso;
	}
	public void setCommentiCorso(String commentiCorso) {
		this.commentiCorso = commentiCorso;
	}
	public String getAulaCorso() {
		return aulaCorso;
	}
	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}
	public int getPostiDisp() {
		return postiDisp;
	}
	public void setPostiDisp(int postiDisp) {
		this.postiDisp = postiDisp;
	}
	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", codDocente=" + codDocente + ", nomeCorso=" + nomeCorso
				+ ", dataInizioCorso=" + dataInizioCorso + ", dataFineCorso=" + dataFineCorso + ", costoCorso="
				+ costoCorso + ", commentiCorso=" + commentiCorso + ", aulaCorso=" + aulaCorso + ", postiDisp=" + postiDisp+ "]";
	}
	
	
	
}
