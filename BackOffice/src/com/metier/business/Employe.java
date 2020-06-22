package com.metier.business;
public class Employe extends Personnel{
	
	private Administrateur administrateur;
	private Service service;
	private Boolean archive;
	private Boolean chef;

	public Employe(String matricule, String nom, String prenom, String dateNaissance,String dateEmbauche,
			String motPasse,Administrateur administrateur,Service service,boolean chef) {
		super(matricule, nom, prenom, dateNaissance, dateEmbauche, motPasse);
		this.administrateur=administrateur;
		this.service=service;
		this.chef=chef;
	}
	
	public Employe(String nom, String prenom, String dateNaissance,String dateEmbauche,Service service,boolean chef) {
		super(nom, prenom, dateNaissance, dateEmbauche);
		this.service=service;
		this.chef=chef;
	}
	
	public Employe(String matricule, String nom, String prenom, String dateNaissance,String dateEmbauche,
			String motPasse,Administrateur administrateur,Service service) {
		super(matricule, nom, prenom, dateNaissance, dateEmbauche, motPasse);
		this.administrateur=administrateur;
		this.service=service;
	}
	public Employe(String matricule, String nom, String prenom, String dateNaissance, String dateEmbauche,
			String motPasse,Administrateur administrateur,Service service,Boolean chef,Boolean archive) {
		super(matricule, nom, prenom, dateNaissance, dateEmbauche, motPasse);
		this.administrateur=administrateur;
		this.service=service;
		this.chef=chef;
		this.archive=archive;
		
	}
	
	public Employe(String matricule, String nom, String prenom, String  date1, String  date2,
		Boolean archive ) {
		super(matricule, nom, prenom, date1, date2, matricule);
		this.archive=archive;
	}
	public Employe(String matricule, String nom, String prenom, String  date1, String  date2,Service service,Boolean chef ) {
			super(matricule, nom, prenom, date1, date2,"M1");
			this.service=service;
			this.chef=chef;
		}
	public Employe(String matricule, String nom, String prenom, String  date1, String  date2,Service service,Boolean chef,Boolean etat ) {
		super(matricule, nom, prenom, date1, date2,"M1");
		this.service=service;
		this.chef=chef;
		this.archive=etat;
	}
	public Employe(String matricule, String nom, String prenom, String  date, String  date2,
			String motdepasse,Boolean chef) {
			super(matricule, nom, prenom, date, date2, motdepasse);
			this.chef=chef;
		}
	
	
	public Employe(String matricule,Boolean etat) {
			super(matricule);
			this.archive=etat;
		}
	
	
	
	public Boolean getChef() {
		return chef;
	}

	@Override
	public String toString() {
		return "Employe: "+super.toString()+" archive=" + archive + ", chef="
				+ chef + "]";
	}
	public void setChef(Boolean chef) {
		this.chef = chef;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}
	
	public Employe(String matricule, String nom, String prenom) {
		super(matricule, nom, prenom);
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	public String generer() {
		return Integer.toString((Math.abs(getNom().hashCode()-getPrenom().hashCode()-getDateEmbauche().hashCode()-getDateNaissance().hashCode())));
	}
/*
	@Override
	public String toString() {
		return administrateur.toString()+service.toString();
	}
	public void afficher()
	{
		System.out.println(super.toString()+this.toString());
	}*/
	 
}