package com.presentation.controleurs;


import javax.swing.JTextField;

import com.business.Citoyen;
import com.businessmanager.CitoyenManger;
import com.presentation.views.Acceuil;
import com.presentation.views.Authentification;


public class AuthentificationControleur {
	private Authentification authentification;
	private CitoyenManger citoyenmanger;

	public AuthentificationControleur() {
		citoyenmanger=new CitoyenManger();
	}
	public Authentification getAuthentification() {
		return authentification;
	}
	
	public void acceder(JTextField c)
	{
		Acceuil a =new Acceuil();
		a.setSize(authentification.getSize());
		a.setLocation(authentification.getLocation());
		a.setCin(c);
		authentification.dispose();
		a.setVisible(true);
	}

	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
		authentification.setControleur(this);
	}
	
	public boolean saveCitoyen(Citoyen c)
	{
		return citoyenmanger.setCitoyen(c);
	}
	
	public static void main(String[] args) {
		//AuthentificationControleur c=new AuthentificationControleur();
		//System.out.print(c.testPassword("Not valid", "vv"));
	}
}
