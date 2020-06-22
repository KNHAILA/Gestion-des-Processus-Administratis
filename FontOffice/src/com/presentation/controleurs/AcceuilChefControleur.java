package com.presentation.controleurs;
import com.presentation.views.AcceuilChefDeService;
import com.presentation.views.ConsultAvancement;
import com.presentation.views.ConsultDemande;


public class AcceuilChefControleur {
	
	private AcceuilChefDeService acceuil;
	
	public AcceuilChefControleur() {
	}

	public AcceuilChefDeService getAcceuil() {
		return acceuil;
	}

	public void setAcceuil(AcceuilChefDeService acceuil) {
		this.acceuil = acceuil;
		acceuil.setControleur(this);
	}
	public void accederConsultDemande()
	{
		ConsultDemande a =new ConsultDemande();
		a.setSize(acceuil.getSize());
		a.setLocation(acceuil.getLocation());
		//a.setCin(b);
		acceuil.dispose();
		a.setVisible(true);
	}
	public void accederConsultAvancement()
	{
		ConsultAvancement a = new ConsultAvancement();
		a.setSize(acceuil.getSize());
		a.setLocation(acceuil.getLocation());
		//a.setCin(b);
		acceuil.dispose();
		a.setVisible(true);
	}
}
