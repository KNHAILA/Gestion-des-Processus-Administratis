

package com.presentationRepo.views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.*;

import com.metier.business.Employe;
import com.persistence.DAORepo.DAOEmploye;
import com.presentationRepo.controleurs.ValidationControleur;

public class ValidationEtapesPlusieurs extends JFrame {
	
	private static final long serialVersionUID = 1L;
	 
	private ValidationControleur controleur;
	
	public ValidationEtapesPlusieurs() {
		String chartTitle="Taux de validation des étapes par plusieurs employés";
		setBounds(250, 100, 656, 400);
		controleur=new ValidationControleur();
		DefaultPieDataset dataset = new DefaultPieDataset();
		ArrayList<Employe> validees = controleur.getValidees(); 
	    JFreeChart chart = createChart(dataset, chartTitle);
	    ChartPanel chartPanel = new ChartPanel(chart);
	    setContentPane(chartPanel);
	    for(Employe emp: validees) {
				dataset.setValue( emp.getNom()+" "+emp.getPrenom(), 
						new Double(emp.getNombreEtapesValidees()*360)/controleur.getTotal());
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

	ValidationEtapesPlusieurs  demo = new ValidationEtapesPlusieurs();
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);

}

	
}