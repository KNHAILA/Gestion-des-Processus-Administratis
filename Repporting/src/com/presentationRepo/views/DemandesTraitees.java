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

public class DemandesTraitees extends JFrame {
	private static final long serialVersionUID = 1L;
	private AcceptationControleur controleur;
	
   public DemandesTraitees() {
      super("Gestion demandes"); 
		setBounds(250, 100, 656, 400);
      JFreeChart barChart = ChartFactory.createBarChart(
    		 "Nombre des demands traitées pour chaque procedure",           
         "Procedure Name",            
         "nombre des demandes ",            
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

        
      for (int i = 0; i < controleur.getAllDemandes().size(); i++) {
  		dataset.addValue(controleur.getAllDemandes().get(i).getNombreDemandes(), "Demande" ,
  				controleur.getAllDemandes().get(i).getNom());
  		
		}

      return dataset; 
   }
   public static void main(String[] args) {

    	DemandesTraitees  demo = new DemandesTraitees ();
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
   
}
