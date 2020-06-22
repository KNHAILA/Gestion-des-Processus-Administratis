package com.presentation.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.presentation.controleurs.AcceuilControleur;

public class Acceuil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcceuilControleur controleur;
	private JPanel panel_center;
	private JLabel gPersonnel;
	private JLabel gProcedures;
	private JLabel gEtapes;
	private JLabel gPersonnel1;
	private JLabel gProcedures1;
	private JLabel gEtapes1;
	
	private JLabel gPersonnelicon;
	private JLabel gProceduresicon;
	private JLabel gEtapesicon;
	
	private Box box;
	private Box box1;
	private Box box2;
	
	public Acceuil() {
		this.setTitle("Page d'acceuil");
		this.setSize(800,500);
		this.initialiser();
		this.setColors();
		this.setSizes();
		controleur=new AcceuilControleur();
		controleur.setAcceuil(this);
		this.affectation();
		this.actiongestion();
		this.actionprocedures();
		this.actionetapes();
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	private void actionetapes() {
		box2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder2();
			}
		});
		
	}

	private void actionprocedures() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder1();
			}
		});
		}

	private void actiongestion() {
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder();
			}
		});
		
	}

	private void setColors()
	{
		gPersonnel.setForeground(new Color(0,0,81));
		gPersonnel1.setForeground(new Color(0,0,81));
		gProcedures.setForeground(new Color(0,0,81));
		gProcedures1.setForeground(new Color(0,0,81));
		gEtapes.setForeground(new Color(0,0,81));
		gEtapes1.setForeground(new Color(0,0,81));
	}
	
	private void setSizes()
	{
		gPersonnel.setFont(new Font("Cambria", Font.BOLD, 20));
		gPersonnel1.setFont(new Font("Cambria", Font.BOLD, 20));
		gPersonnelicon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,70));
		gPersonnel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,70));
		gProcedures.setFont(new Font("Cambria", Font.BOLD, 20));
		gProcedures1.setFont(new Font("Cambria", Font.BOLD, 20));
		gProceduresicon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
		gProcedures.setBorder(BorderFactory.createEmptyBorder(0, 35, 0, 70));
		gEtapes.setFont(new Font("Cambria", Font.BOLD, 20));
		gEtapes1.setFont(new Font("Cambria", Font.BOLD, 20));
		gEtapes.setBorder(BorderFactory.createEmptyBorder(0, 30, 0,70));
		gEtapes1.setBorder(BorderFactory.createEmptyBorder(0, 15, 0,70));
		
	}
	
	private void affectation()
	{
		panel_center.add(box);
		panel_center.add(box1);
		panel_center.add(box2);
		getContentPane().add(panel_center,BorderLayout.CENTER);
	}
	
	private void initialiser() {
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		ImageIcon i = new ImageIcon("icons/perso.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		gPersonnel=new JLabel("Gestion");
		gPersonnel1=new JLabel("du personnel");
		box = Box.createVerticalBox();
		gPersonnelicon = new JLabel(i);
		box.add(gPersonnelicon);
		box.add(gPersonnel);
		box.add(gPersonnel1);
		/*******************/
		i = new ImageIcon("icons/processus.png");
		m = i.getImage();
		n = m.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		gProcedures=new JLabel("Gestion");
		gProcedures1=new JLabel("des procédures");
		box1 = Box.createVerticalBox();
		gProceduresicon = new JLabel(i);
		box1.add(gProceduresicon);
		box1.add(gProcedures);
		box1.add(gProcedures1);
		/*******************/
		i = new ImageIcon("icons/step5.png");
		m = i.getImage();
		n = m.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		gEtapes=new JLabel("Gestion");
		gEtapes1=new JLabel("des étapes");
		box2 = Box.createVerticalBox();
		gEtapesicon = new JLabel(i);
		box2.add(gEtapesicon);
		box2.add(gEtapes);
		box2.add(gEtapes1);
		/*******************/
		
	}
	
	public AcceuilControleur getControleur() {
		return controleur;
	}

	public void setControleur(AcceuilControleur controleur) {
		this.controleur = controleur;
	}

	
}
