package com.metier.business;

public class Service {
	private String Id_service;
	private String Nom;
	
	public Service(String id_service, String nom) {
		Id_service = id_service;
		Nom = nom;
	}
	public String getId_service() {
		return Id_service;
	}
	public void setId_service(String id_service) {
		Id_service = id_service;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	@Override
	public String toString() {
		return "Service [Id_service=" + Id_service + ", Nom=" + Nom + "]";
	}
	
	public void afficher() {
		System.out.println(toString());
	}
	
}
