package com.presentationRepo.views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.presentationRepo.controleurs.AccueilControleur;
import com.presentationRepo.controleurs.AuthentificationControleur;

public class Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_center;
	private JPanel panel_south;
	private JPanel ab;
	private JRadioButton demande;
	private JRadioButton demandeAcceptee;
	private JRadioButton gEtapes;
	private ButtonGroup g;
	private GridBagConstraints c;
	private ImageIcon caret_right;
	private JLabel icon;
	private JButton valider;
	private AccueilControleur controleur;
	private ImageIcon i;
	
	private Box box;
	
	
	
	public Accueil() {
		this.setTitle("Page d'acceuil");
		this.setSize(800,500);
		this.initialiser();
		this.setColors();
		this.setSizes();
		this.events();
		this.InitialierGridBagLayout();
		this.affectation();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	private void setColors()
	{
		panel_south.setBackground(SystemColor.inactiveCaptionBorder);
		ab.setBackground(SystemColor.inactiveCaptionBorder);
	}
	
	private void setSizes()
	{
		panel_south.setPreferredSize(new Dimension(600,50));
		demande.setFont(new Font("Cambria", Font.BOLD, 20));
		demande.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		demandeAcceptee.setFont(new Font("Cambria", Font.BOLD, 20));
		demandeAcceptee.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		gEtapes.setFont(new Font("Cambria", Font.BOLD, 20));
		gEtapes.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		valider=new JButton("valider");
		valider.setFont(new Font("Cambria", Font.BOLD, 18));
		valider.setForeground(new Color(0,64,128));
		
	}
	
	private void affectation()
	{
		panel_south.add(icon);
		ab.add(box);
		panel_south.add(valider);
		getContentPane().add(panel_south, BorderLayout.SOUTH);
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(ab,BorderLayout.NORTH);
	}
	
	private void initialiser() {
		
		i=new ImageIcon("icons/report.png");
		Image k=i.getImage();
		Image l=k.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ab=new JPanel(new FlowLayout(FlowLayout.CENTER));
		i=new ImageIcon(l);
		box = Box.createHorizontalBox();
		JLabel image5 = new JLabel(i);
		box.add(image5);
		controleur=new AccueilControleur();
		controleur.setAccueil(this);
		caret_right=new ImageIcon("icons/caret_right.png");
		Image m=caret_right.getImage();
		Image n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		caret_right=new ImageIcon(n);
		icon =new JLabel(caret_right);
		demande=new JRadioButton("Statistiques sur le nombre de demandes traitées pour chaque procédure");
		demandeAcceptee=new JRadioButton("Statistiques sur les taux d’acceptation des demandes des procédures");
		gEtapes=new JRadioButton("Statistiques sur les taux de validation des étapes");
		g=new ButtonGroup();
		g.add(demande);
		g.add(demandeAcceptee);
		g.add(gEtapes);
		demande.setSelected(true);
		panel_south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		c=new GridBagConstraints();
	}
	
	private void InitialierGridBagLayout()
	{
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(demande,c);
		c.gridx=0;
		c.gridy=1;
		panel_center.add(demandeAcceptee,c);
		c.gridx=0;
		c.gridy=2;
		panel_center.add(gEtapes,c);
	}
	public void acces()
	{
		if(demande.isSelected())
	  {
		controleur.acceder();
	  }
		if(demandeAcceptee.isSelected())
		  {
			controleur.acceder1();
		  }
		if(gEtapes.isSelected())
		  {
			controleur.acceder2();
		  }
		
	}
	public void events() {
	valider.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent a) {
			acces();
			   }
		
	});
	}
	public void setControleur(AccueilControleur controleur) {
		this.controleur = controleur;
	}

	public static void main(String[] args) {
		Accueil a=new Accueil();
		a.setVisible(true);

	}

}
