package com.presentationRepo.views;

	import java.util.ArrayList;
    import javax.swing.JFrame;
    import org.jfree.chart.ChartFactory;
	import org.jfree.chart.ChartPanel; 
	import org.jfree.chart.JFreeChart; 
	import org.jfree.chart.plot.PlotOrientation;
	import org.jfree.data.category.CategoryDataset; 
	import org.jfree.data.category.DefaultCategoryDataset; 
	import org.jfree.ui.ApplicationFrame; 
	import org.jfree.ui.RefineryUtilities;
    import com.metier.business.Employe;
    import com.persistence.DAORepo.DAOEmploye;
import com.presentationRepo.controleurs.ValidationControleur;

	public class ValidationEtapes  extends JFrame {
		
			private ArrayList<Employe> liste;
			 private ValidationControleur controleur;
		   public ValidationEtapes() {
			   super("Statistique"); 
          controleur=new ValidationControleur();
		      
		      liste=controleur.getValidees();

		      JFreeChart barChart = ChartFactory.createBarChart(
		    		 "Taux de validation d’étapes par employé",           
		         "Employé",            
		         "taux de validation %",            
		         createDataset(),          
		         PlotOrientation.VERTICAL,           
		         true, true, false);
		         
		      ChartPanel chartPanel = new ChartPanel( barChart );        
		      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
		      setContentPane( chartPanel ); 
		      this.setDefaultCloseOperation(ApplicationFrame.DISPOSE_ON_CLOSE);
		   }
		   
		   private CategoryDataset createDataset( ) {
		            
		      final DefaultCategoryDataset dataset =new DefaultCategoryDataset( );  

		      DAOEmploye e=new DAOEmploye();
		      for (int i = 0; i < liste.size(); i++) {
		      		//dataset.addValue(((liste.get(i).getNombreEtapesValidees()-listeEmploeReporting.get(i).getNbrEtapeValidé())*100)/listeEmploeReporting.get(i).getNbrEtapes(), "REJETEE" ,listeEmploeReporting.get(i).getEmploye_nom() );
                
	      		dataset.addValue((liste.get(i).getNombreEtapesValidees()*100/liste.get(i).getNombreEtapes()), "ACCEPTEE" ,liste.get(i).getNom()+" "+liste.get(i).getPrenom()) ;
                 }
                 
                    //*100)/listeEmploeReporting.get(i).getNbrEtapes()
				

		      return dataset; 
		   }
		   
		   public static void main( String[ ] args ) {
			   ValidationEtapes chart = new  ValidationEtapes();
		      chart.pack( );        
		      RefineryUtilities.centerFrameOnScreen( chart );        
		      chart.setVisible( true ); 
		   }
		}
