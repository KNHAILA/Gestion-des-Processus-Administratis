package com.metier.business;

public class Procedure {
	private int numero;
	private String nom;
	public Employe chef;
	private int nombreEtapes;
	private String cheminListe;
	private boolean achivee;
	private int nombreDemandesAcceptees;
	private int nombreDemandesEnAttente;
	private int nombreDemandes;
	private int nombreDemandesRefusees;
	
	public Procedure(String nom, Employe chef, int nombreEtapes, String cheminListe,boolean archivee) {
		super();	
		this.nom = nom;
		this.chef = chef;
		this.nombreEtapes = nombreEtapes;
		this.cheminListe = cheminListe;
		this.achivee=archivee;
		}
	
	public Procedure(int numero, String nom) {
		super();
		this.numero = numero;
		this.nom = nom;
	}

	public Procedure() {
		super();
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
   
	public int getNombreDemandes() {
		return nombreDemandes;
	}

	public void setNombreDemandes(int nombreDemandes) {
		this.nombreDemandes = nombreDemandes;
	}

	public void setAchivee(boolean achivee) {
		this.achivee = achivee;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Procedure other = (Procedure) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
  
	public int getNombreDemandesAcceptees() {
		return nombreDemandesAcceptees;
	}

	public int getNombreDemandesRefusees() {
		return nombreDemandesRefusees;
	}

	public void setNombreDemandesRefusees(int nombreDemandesRefusees) {
		this.nombreDemandesRefusees = nombreDemandesRefusees;
	}

	@Override
	public String toString() {
		return "Procedure [numero=" + numero + ", nom=" + nom + ", chef=" + chef + ", nombreEtapes=" + nombreEtapes
				+ ", cheminListe=" + cheminListe + ", achivee=" + achivee + ", nombreDemandesAcceptees=" + nombreDemandesAcceptees +", nombreDemandes=" + nombreDemandes +", nombreDemandesRefusees=" + nombreDemandesRefusees +", nombreDemandesEnAttente=" + nombreDemandesEnAttente + "]";
	}

	public int genererNumero() {
		return this.numero= Math.abs((cheminListe.hashCode())- (nom.hashCode())-nombreEtapes);
	}
	public int getNumero()
	{
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setNombreDemandesAcceptees(int nombreDemandes) {
		this.nombreDemandesAcceptees = nombreDemandes;
	}

	public int getNombreDemandesEnAttente() {
		return nombreDemandesEnAttente;
	}

	public void setNombreDemandesEnAttente(int nombreDemandesEnAttente) {
		this.nombreDemandesEnAttente = nombreDemandesEnAttente;
	}
	
	
}

