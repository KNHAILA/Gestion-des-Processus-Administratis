package com.metier.business;
public class Employe{
	private String matricule;
	private String nom;
	private String prenom;
	private int nombreEtapes;
	private int nombreEtapesValidees;
	public Employe() {
		super();
	}
	public Employe(int nombreEtapes, int nombreEtapesvalidees,String mat) {
		super();
		this.nombreEtapes = nombreEtapes;
		this.nombreEtapesValidees = nombreEtapesvalidees;
		 this.matricule=mat;
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
	public int getNombreEtapes() {
		return nombreEtapes;
	}
	public void setNombreEtapes(int nombreEtapes) {
		this.nombreEtapes = nombreEtapes;
	}
	public int getNombreEtapesValidees() {
		return nombreEtapesValidees;
	}
	
	public Employe(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public void setNombreEtapesValidees(int nombreEtapesvalidees) {
		this.nombreEtapesValidees = nombreEtapesvalidees;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricule == null) ? 0 : matricule.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + nombreEtapes;
		result = prime * result + nombreEtapesValidees;
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Employe other = (Employe) obj;
		if (matricule == null) {
			if (other.matricule != null)
				return false;
		} else if (!matricule.equals(other.matricule))
			return false;
		
		return true;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", nombreEtapes=" + nombreEtapes
				+ ", nombreEtapesValidees=" + nombreEtapesValidees + "]";
	}
	
	
	
	 
}