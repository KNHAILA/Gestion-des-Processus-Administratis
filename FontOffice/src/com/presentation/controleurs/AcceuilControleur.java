package com.presentation.controleurs;

import javax.swing.JTextField;

import com.presentation.views.Acceuil;
import com.presentation.views.SuivreDemande;
import com.presentation.views.depotDemande;


public class AcceuilControleur {
	
	private Acceuil acceuil;
	
	public AcceuilControleur() {
	}

	public Acceuil getAcceuil() {
		return acceuil;
	}

	public void setAcceuil(Acceuil acceuil) {
		this.acceuil = acceuil;
		acceuil.setControleur(this);
	}

	public void acceder(JTextField cin) {
		depotDemande a=new depotDemande();
		a.setSize(acceuil.getSize());
		a.setLocation(acceuil.getLocation());
		a.setCin(cin);
		//a.setLocationRelativeTo(null);
		acceuil.dispose();
		a.setVisible(true);		
	}
	
	public void Suivre(JTextField cin)
	{
		SuivreDemande a=new SuivreDemande(cin);
		a.setSize(acceuil.getSize());
		a.setLocation(acceuil.getLocation());
		acceuil.dispose();
		a.setVisible(true);	
	}
}
