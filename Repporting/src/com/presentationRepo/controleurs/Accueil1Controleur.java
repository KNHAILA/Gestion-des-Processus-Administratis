   package com.presentationRepo.controleurs;

	import org.jfree.ui.RefineryUtilities;

import com.presentationRepo.views.AcceptationPlusieurs;
import com.presentationRepo.views.Accueil;
import com.presentationRepo.views.Accueil1;
import com.presentationRepo.views.DemandesAcceptees;


	public class Accueil1Controleur {
		private Accueil1 accueil1;
		
		public Accueil1Controleur() {
		
			
		}
		public Accueil1 getAccueil() {
			return accueil1;
		}
		
		public void acceder1()
		{
			DemandesAcceptees  demo = new DemandesAcceptees ();
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);
	        
	        
		}
		public void acceder2()
		{
			AcceptationPlusieurs  demo = new AcceptationPlusieurs ();
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);
	       
	        
		}
		public void acceder3()
		{
			Accueil  demo = new Accueil();
	        demo.pack();
	        demo.setSize(accueil1.getSize());
			demo.setLocation(accueil1.getLocation());
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);
	        accueil1.dispose();
	        
		}

		public void setAccueil1(Accueil1 accueil) {
			this.accueil1 = accueil;
			accueil.setControleur(this);
		}

	}



