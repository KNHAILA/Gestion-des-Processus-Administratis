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
import com.presentation.controleurs.AcceuilChefControleur;

public class AcceuilChefDeService extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcceuilChefControleur controleur;
	private JPanel panel_center;
	private JLabel consult;
	private JLabel avancement;
	private JLabel archive;
	private JLabel consult1;
	private JLabel avancement1;
	private JLabel avancement2;
	private JLabel archive1;
	
	private JLabel consulticon;
	private JLabel avancementicon;
	private JLabel archiveicon;
	
	private Box box;
	private Box box1;
	private Box box2;
	
	public AcceuilChefDeService() {
		this.setTitle("Page d'acceuil");
		this.setSize(800,500);
		this.initialiser();
		this.setColors();
		this.setSizes();
		controleur=new AcceuilChefControleur();
		controleur.setAcceuil(this);
		this.affectation();
		this.actionconsult();
		this.actionavancement();
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	

	private void actionavancement() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.accederConsultAvancement();
			}
		});
		}

	private void actionconsult() {
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.accederConsultDemande();
			}
		});
		
	}

	private void setColors()
	{
		consult.setForeground(new Color(0,128,192));
		consult1.setForeground(new Color(0,128,192));
		avancement.setForeground(new Color(0,128,192));
		avancement1.setForeground(new Color(0,128,192));
		avancement2.setForeground(new Color(0,128,192));
	}
	
	private void setSizes()
	{
		consult.setFont(new Font("Cambria", Font.BOLD, 20));
		consult1.setFont(new Font("Cambria", Font.BOLD, 20));
		consulticon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,70));
		consult.setBorder(BorderFactory.createEmptyBorder(0, 20, 0,70));
		avancement.setFont(new Font("Cambria", Font.BOLD, 20));
		avancement1.setFont(new Font("Cambria", Font.BOLD, 20));
		avancement2.setFont(new Font("Cambria", Font.BOLD, 20));
		avancementicon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
		avancement.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 70));
		avancement1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 70));
		box.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 40));
		box1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 40));
	}
	
	private void affectation()
	{
		panel_center.add(box);
		panel_center.add(box1);
		getContentPane().add(panel_center,BorderLayout.CENTER);
	}
	
	private void initialiser() {
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		ImageIcon i = new ImageIcon("icons/consult11.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		consult=new JLabel("Consulter");
		consult1=new JLabel("les demandes");
		box = Box.createVerticalBox();
		consulticon = new JLabel(i);
		box.add(consulticon);
		box.add(consult);
		box.add(consult1);
		/*******************/
		i = new ImageIcon("icons/avancement.png");
		m = i.getImage();
		n = m.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		avancement=new JLabel("Consulter");
		avancement1=new JLabel("l'avancement");
		avancement2=new JLabel("des demandes");
		box1 = Box.createVerticalBox();
		avancementicon = new JLabel(i);
		box1.add(avancementicon);
		box1.add(avancement);
		box1.add(avancement1);
		box1.add(avancement2);
		
	}
	
	public AcceuilChefControleur getControleur() {
		return controleur;
	}

	public void setControleur(AcceuilChefControleur controleur) {
		this.controleur = controleur;
	}

	public static void main(String[] args) {
		AcceuilChefDeService a=new AcceuilChefDeService();
		a.setVisible(true);

	}

}
