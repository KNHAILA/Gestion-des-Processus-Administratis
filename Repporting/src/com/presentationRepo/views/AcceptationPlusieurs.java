package com.presentationRepo.views;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.*;

import com.metier.business.Procedure;
import com.persistence.DAORepo.DAOProcedureRepo;
import com.presentationRepo.controleurs.AcceptationControleur;

public class AcceptationPlusieurs extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private AcceptationControleur controleur;
	
	public AcceptationPlusieurs() {
		String chartTitle="Taux d'acceptation de demandes par plusieurs procedures";
		setBounds(250, 100, 656, 400);
	    controleur=new AcceptationControleur();
		DefaultPieDataset dataset = new DefaultPieDataset();
		 ArrayList<Procedure> demandes = controleur.getAccepted(); 
	        JFreeChart chart = createChart(dataset, chartTitle);
	        ChartPanel chartPanel = new ChartPanel(chart);
	        setContentPane(chartPanel);
	        for(Procedure proc: demandes) {
				dataset.setValue( proc.getNom(),new Double (proc.getNombreDemandesAcceptees()*360)/demandes.size());
				}
		     }
	private JFreeChart createChart(DefaultPieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  
            dataset,                
            true,                   
            true,
            false
        );
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1}");
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setLabelGenerator(labelGenerator);
        return chart;

    }
	public static void main(String[] args) {

	AcceptationPlusieurs  demo = new AcceptationPlusieurs  ();
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);

}

	
}

