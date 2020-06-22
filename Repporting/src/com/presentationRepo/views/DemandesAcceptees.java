package com.presentationRepo.views;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import com.persistence.DAORepo.DAOProcedureRepo;
import com.presentationRepo.controleurs.AcceptationControleur;



	public class DemandesAcceptees extends JFrame {
		
		
		private static final long serialVersionUID = 1L;
		private AcceptationControleur controleur;
		
		public DemandesAcceptees() {
			super("Gestion demandes"); 
			setBounds(250, 100, 656, 400);
			JFreeChart barChart = ChartFactory.createBarChart(
					"TAUX d'Acceptation des demandes par procedure",           
					"Procedure ID",            
					"taux d'acceptation/Refus/en attente %",            
					createDataset(),          
					PlotOrientation.VERTICAL,           
					true, true, false);
	         
		      ChartPanel chartPanel = new ChartPanel( barChart );        
		      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
		      setContentPane( chartPanel ); 
	   }
	   
	   private CategoryDataset createDataset( ) {
		   controleur=new AcceptationControleur();
	      final DefaultCategoryDataset dataset =new DefaultCategoryDataset( );  

	        
	     for (int i = 0; i < controleur.getAccepted().size(); i++) {
      		dataset.addValue(controleur.getAccepted().get(i).getNombreDemandesAcceptees()*100/
      				controleur.getNbDmd(controleur.getAccepted().get(i).getNumero()),
      				"ACCEPTEE" ,controleur.getAccepted().get(i).getNom());
			}
	     for (int j = 0; j< controleur.getRefused().size(); j++) {
	    	dataset.addValue(controleur.getRefused().get(j).getNombreDemandesRefusees()*100/
	    			controleur.getNbDmd(controleur.getRefused().get(j).getNumero()),
	    			"REFUSEE",controleur.getRefused().get(j).getNom());
	     }
	     for (int k = 0; k< controleur.getEnAttente().size(); k++) {
		    	dataset.addValue(controleur.getEnAttente().get(k).getNombreDemandesEnAttente()*100/
		    			controleur.getNbDmd(controleur.getEnAttente().get(k).getNumero()),
		    			"EN ATTENTE" ,controleur.getEnAttente().get(k).getNom());
		      }
	     

	      return dataset; 
	   }
	   public static void main(String[] args) {

	    	DemandesAcceptees  demo = new DemandesAcceptees ();
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);

	    }
	   
	}
