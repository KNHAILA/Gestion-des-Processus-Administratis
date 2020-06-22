package com.presentationRepo.controleurs;

	import org.jfree.ui.RefineryUtilities;
    import com.presentationRepo.views.AcceptationPlusieurs;
import com.presentationRepo.views.Accueil;
import com.presentationRepo.views.Accueil1;
import com.presentationRepo.views.Accueil2;
import com.presentationRepo.views.DemandesAcceptees;
import com.presentationRepo.views.ValidationEtapes;
import com.presentationRepo.views.ValidationEtapesPlusieurs;

public class Accueil2Controleur {
		
			private Accueil2 accueil2;
			
			public Accueil2Controleur() {
			
				
			}
			public Accueil2 getAccueil() {
				return accueil2;
			}
			
			public void acceder1()
			{
				ValidationEtapes  demo = new ValidationEtapes ();
		        demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);
		       
			}
			public void acceder2()
			{
				ValidationEtapesPlusieurs  demo = new ValidationEtapesPlusieurs ();
		        demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);
		       
		        
			}
			public void acceder3()
			{
				Accueil  demo = new Accueil();
		        demo.pack();
		        demo.setSize(accueil2.getSize());
				demo.setLocation(accueil2.getLocation());
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);
		        accueil2.dispose();
		        
			}

			public void setAccueil2(Accueil2 accueil) {
				this.accueil2 = accueil;
				accueil2.setControleur(this);
			}

		}

