package com.metier.business;

import java.sql.Date;

public class Personnel {
	private String Matricule;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String dateEmbauche;
	private String MotPasse;
	
	public Personnel() {
		
	}
	public Personnel(String matricule, String nom, String prenom, String date, String date2, String motPasse) {
		Matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = date;
		this.dateEmbauche = date2;
		MotPasse = motPasse;
	}
	public Personnel(String matricule, String nom, String prenom) {
		Matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Personnel(String nom, String prenom, String date, String date2) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = date;
		this.dateEmbauche = date2;
	}
	public Personnel(String matricule) {
		Matricule = matricule;
		
	}
	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date String) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getMotPasse() {
		return MotPasse;
	}

	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}

	@Override
	public String toString() {
		return "Personnel [Matricule=" + Matricule + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", dateEmbauche=" + dateEmbauche + ", MotPasse=" + MotPasse + "]";
	}
	
	void afficher() {
		System.out.println(this.toString());
	}

}
