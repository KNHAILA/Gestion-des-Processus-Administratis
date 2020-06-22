package com.business;

import java.util.ArrayList;

public class Demande {
	private int numero;
	private Citoyen citoyen;
	private ArrayList<String> fichiers;
	private int numeroProcedure;
	private boolean jeton;
	
	public Demande(int numero, Citoyen citoyen) {
		this.numero = numero;
		this.citoyen = citoyen;
	}
	public Demande(int numero) {
		this.numero = numero;
	}
	
	public Demande(Citoyen citoyen, ArrayList<String> fichiers,int numero) {
		this.citoyen = citoyen;
		this.fichiers = fichiers;
		this.numeroProcedure=numero;
	}
	

	public int getNumeroProcedure() {
		return numeroProcedure;
	}
	
	public void setNumeroProcedure(int numeroProcedure) {
		this.numeroProcedure = numeroProcedure;
	}
	
	public Demande(Citoyen citoyen, ArrayList<String> fichiers) {
		this.citoyen = citoyen;
		this.fichiers = fichiers;
	}
	
	public int getNumero() {
		return this.genererNumeroDemande();
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Citoyen getCitoyen() {
		return citoyen;
	}
	
	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
	
	public ArrayList<String> getFichiers() {
		return fichiers;
	}
	public void setFichiers(ArrayList<String> fichiers) {
		this.fichiers = fichiers;
	}
	
	
	public boolean isJeton() {
		return jeton;
	}
	public void setJeton(boolean jeton) {
		this.jeton = jeton;
	}
	public int genererNumeroDemande()
	{
		return Math.abs(getCitoyen().getCIN().hashCode()-getFichiers().hashCode());
	}
}
