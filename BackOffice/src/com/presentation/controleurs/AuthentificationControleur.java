package com.presentation.controleurs;

import com.metier.business.Administrateur;
import com.metier.businessmanger.AdministrateurManager;
import com.presentation.views.Acceuil;
import com.presentation.views.Authentification;


public class AuthentificationControleur {
	private Authentification authentification;
	private AdministrateurManager administrateurManager;
	
	public AuthentificationControleur() {
		administrateurManager=new AdministrateurManager();
	}
	public Authentification getAuthentification() {
		return authentification;
	}
	
	public void acceder()
	{
		Acceuil a =new Acceuil();
		a.setSize(authentification.getSize());
		a.setLocation(authentification.getLocation());
		authentification.dispose();
		a.setVisible(true);
	}

	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
		authentification.setControleur(this);
	}
	
	public boolean testPassword(String a, String b) {
		Administrateur e;
		e=administrateurManager.getpassword(a);
		if (e==null)
			return false;
		else if(e.getMotPasse().equals(b))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		AuthentificationControleur c=new AuthentificationControleur();
		System.out.print(c.testPassword("Not valid", "vv"));
	}
}
