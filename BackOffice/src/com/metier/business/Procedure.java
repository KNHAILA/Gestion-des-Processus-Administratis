package com.metier.business;


public class Procedure {
	private String nom;
	public Employe chef;
	private int nombreEtapes;
	private String cheminListe;
	private boolean achivee;
	
	public Procedure(String nom, Employe chef, int nombreEtapes, String cheminListe,boolean archivee) {
		super();	
		this.nom = nom;
		this.chef = chef;
		this.nombreEtapes = nombreEtapes;
		this.cheminListe = cheminListe;
		this.achivee=archivee;
		}
	public Procedure(String nom, Employe chef, String cheminListe, boolean archivee) {
		super();	
		this.nom = nom;
		this.chef = chef;
		this.cheminListe = cheminListe;
		this.achivee=archivee;
		}
	public Procedure(String nom, String cheminListe, boolean archivee) {
		super();	
		this.nom = nom;
		this.cheminListe = cheminListe;
		this.achivee=archivee;
		}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Employe getChef() {
		return chef;
	}

	public void setChef(Employe chef) {
		this.chef = chef;
	}

	public int getNombreEtapes() {
		return nombreEtapes;
	}

	public void setNombreEtapes(int nombreEtapes) {
		this.nombreEtapes = nombreEtapes;
	}

	public String getCheminListe() {
		return cheminListe;
	}

	public void setCheminListe(String cheminListe) {
		this.cheminListe = cheminListe;
	}
	
    
	public boolean getAchivee() {
		return achivee;
	}

	public void setAchivee(boolean achivee) {
		this.achivee = achivee;
	}

	

	@Override
	public String toString() {
		return "Procedure [nom=" + nom + ", chef=" + chef + ", nombreEtapes=" + nombreEtapes + ", cheminListe="
				+ cheminListe + ", achivee=" + achivee + "]";
	}

	public int genererNumero() {
		return Math.abs((cheminListe.hashCode())- (nom.hashCode())-nombreEtapes);
	}
	
}

