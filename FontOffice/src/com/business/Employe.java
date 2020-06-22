package com.business;

public class Employe {
	private String Matricule;
	private String MotDePasse;
	
	public Employe(String matricule, String motDePasse) {
		Matricule = matricule;
		MotDePasse = motDePasse;
	}

	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

	public String getMotDePasse() {
		return MotDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		MotDePasse = motDePasse;
	}
	
	
}
