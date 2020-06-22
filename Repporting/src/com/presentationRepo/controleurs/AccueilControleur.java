package com.presentationRepo.controleurs;

import org.jfree.ui.RefineryUtilities;

import com.metier.businessmanger.AdministrateurManager;
import com.presentationRepo.views.Accueil;
import com.presentationRepo.views.Accueil1;
import com.presentationRepo.views.Accueil2;
import com.presentationRepo.views.Authentification;
import com.presentationRepo.views.DemandesTraitees;

public class AccueilControleur {
	private Accueil accueil;
	
	public AccueilControleur() {
	
		
	}
	public Accueil getAccueil() {
		return accueil;
	}
	
	public void acceder()
	{
		DemandesTraitees  demo = new DemandesTraitees ();
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
      
        
	}
	public void acceder1()
	{
		Accueil1 a =new Accueil1();
		accueil.dispose();
		a.setVisible(true);
	}
	public void acceder2()
	{
		Accueil2 a =new Accueil2();
		accueil.dispose();
		a.setVisible(true);
	}

	public void setAccueil(Accueil accueil) {
		this.accueil = accueil;
		accueil.setControleur(this);
	}

}
