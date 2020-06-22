package com.presentation.controleurs;

import javax.swing.JTextField;
import com.businessmanager.EmployeManager;
import com.presentation.views.AcceuilChefDeService;
import com.presentation.views.AuthentificationEmploye;
import com.presentation.views.ConsultDemande;
import com.presentation.views.TraitementDemande;

public class AuthentificationEmployeControleur {
	private AuthentificationEmploye authentification;
	
	public AuthentificationEmployeControleur() {
	}
	public AuthentificationEmploye getAuthentification() {
		return authentification;
	}
	
	public void setAuthentification(AuthentificationEmploye authentification) {
		this.authentification = authentification;
		authentification.setControleur(this);
	}
	
	public boolean testPassword(String a, String b) {
		return EmployeManager.TestMotDePasse(a, b);
	}
	
	public void acceder(String string) {
		if(EmployeManager.IsChef(string))
		{
			AcceuilChefDeService a =new AcceuilChefDeService();
			a.setSize(authentification.getSize());
			a.setLocation(authentification.getLocation());
			//a.setCin(b);
			authentification.dispose();
			a.setVisible(true);
		}
		else
		{
			TraitementDemande a =new TraitementDemande(new JTextField(string));
			a.setSize(authentification.getSize());
			a.setLocation(authentification.getLocation());
			authentification.dispose();
			a.setVisible(true);
		}
		
	}
}
