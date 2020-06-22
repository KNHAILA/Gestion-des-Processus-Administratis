package com.presentation.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.business.Decision;
import com.presentation.controleurs.ConsultAvancementControleur;

public class ConsultAvancement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ConsultAvancementControleur controleur;
	private JPanel north;
	private JPanel center;
	private JPanel south;
	private Box box;
	private Box box1;
	private JLabel avancementTitle;
	private JLabel avancementIcone;
	private JLabel home;
	private JTable tab;
	private JScrollPane scrolTab;
	public ConsultAvancement() {
		this.setTitle("Application de Gestion Des Processus Administratives");
		this.setSize(800,500);
		controleur = new ConsultAvancementControleur();
		controleur.setConsultavancement(this);
		this.initialiser();
		this.colors();
		this.affectation();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	public void initialiser() {
		/***************************/
		north = new JPanel();
		center = new JPanel();
		center.setLayout(new GridLayout());
		south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.LEFT));
		avancementTitle = new JLabel("  L'avancement des demandes ");
		ImageIcon i = new ImageIcon("icons/avancement.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		avancementIcone = new JLabel(i);
		box = Box.createHorizontalBox();
		box.add(avancementIcone);
		box.add(avancementTitle);
		/**************************/
		i = new ImageIcon("icons/home.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		home=new JLabel("Home");
		box1 = Box.createVerticalBox();
		JLabel q3 = new JLabel(i);
		q3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 00));
		box1.add(q3);
		box1.add(home);
		/*****************************/
		ArrayList<Decision> list=new ArrayList<Decision>();
		list=controleur.getDecisions();
		ModelDemande model = new ModelDemande(list);
		tab = new JTable(model);
		scrolTab=new JScrollPane(tab);
		
		this.actionHome();
	}
	
	private void actionHome() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder();
			}
		});
		
	}

	
	public void colors()
	{
		Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		center.setBorder(raisedetched);
		avancementTitle.setFont(new Font("Cambria", Font.BOLD, 20));
		avancementTitle.setForeground(new Color(0,64,128));
		home.setFont(new Font("Cambria", Font.BOLD, 20));
		home.setForeground(new Color(0,64,128));
		south.setBackground(SystemColor.inactiveCaptionBorder);
		north.setBackground(SystemColor.inactiveCaptionBorder);
		tab.setBackground(new Color(255,255,255));
	}
	public void affectation() {
		north.add(box);
		center.add(scrolTab);
		south.add(box1);
		this.getContentPane().add(north,BorderLayout.NORTH);
		this.getContentPane().add(center,BorderLayout.CENTER);
		this.getContentPane().add(south,BorderLayout.SOUTH);
	}
	public void setControleur(ConsultAvancementControleur controleur) {
		this.controleur = controleur;
	}
	public static void main(String[] args) {
		ConsultAvancement c=new ConsultAvancement();
		c.setVisible(true);
	}
}
