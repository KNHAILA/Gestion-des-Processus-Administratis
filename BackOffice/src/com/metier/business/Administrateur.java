package com.metier.business;

import java.sql.Date;

public class Administrateur extends Personnel{
	private Service service;
	
	public Administrateur(String matricule, String nom, String prenom, String dateNaissance, String dateEmbauche,
			String motPasse) {
		super(matricule, nom, prenom, dateNaissance, dateEmbauche, motPasse);
	}
	
	public Administrateur(String matricule, String nom, String prenom, String dateNaissance, String dateEmbauche,
			String motPasse,Service service) {
		super(matricule, nom, prenom, dateNaissance, dateEmbauche, motPasse);
		this.service=service;
	}
	
	public Administrateur(String matricule,String motPasse) {
		super();
		this.setMatricule(matricule);
		this.setMotPasse(motPasse);
		
	}
	public Service getService() {
		return service;
	}
	
	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return super.toString()+service.toString();
	}
	public void afficher() {
		System.out.println(this.toString());
	}
	
}
