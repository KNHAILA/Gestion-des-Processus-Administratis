package com.presentation.views;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;

import com.presentation.controleurs.AcceuilControleur;

public class Acceuil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AcceuilControleur controleur;
	private JPanel panel_center;
	private JLabel depose;
	private JLabel consult;
	private JLabel depose1;
	private JLabel consult1;
	private JLabel deposeicon;
	private JLabel consulticon;
	private Box box;
	private Box box1;
	private JTextField cin;
	
	public void setCin(JTextField cin) {
		this.cin = cin;
	}


	public Acceuil() {
		this.setTitle("Page d'acceuil");
		this.setSize(800,500);
		this.initialiser();
		this.setSizes();
		controleur=new AcceuilControleur();
		controleur.setAcceuil(this);
		this.affectation();
		this.actiondepose();
		this.actionconsult();
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	

	private void actionconsult() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.Suivre(cin);
			}
		});
	}

	private void actiondepose() {
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder(cin);
			}
		});
		
	}

	
	private void setSizes()
	{
		depose.setFont(new Font("Cambria", Font.BOLD, 20));
		depose1.setFont(new Font("Cambria", Font.BOLD, 20));
		deposeicon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,120));
		depose.setBorder(BorderFactory.createEmptyBorder(0, 25, 0,70));
		consult.setBorder(BorderFactory.createEmptyBorder(0, 35, 0,70));
		consult.setFont(new Font("Cambria", Font.BOLD, 20));
		consult1.setFont(new Font("Cambria", Font.BOLD, 20));
		
		
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
		ImageIcon i = new ImageIcon("icons/depose.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		depose=new JLabel("Déposer");
		depose1=new JLabel("une demande");
		box = Box.createVerticalBox();
		deposeicon = new JLabel(i);
		box.add(deposeicon);
		box.add(depose);
		box.add(depose1);
		/*******************/
		i = new ImageIcon("icons/consult.png");
		m = i.getImage();
		n = m.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		consult=new JLabel("Suivre");
		consult1=new JLabel("une demande");
		box1= Box.createVerticalBox();
		consulticon = new JLabel(i);
		box1.add(consulticon);
		box1.add(consult);
		box1.add(consult1);
		/*******************/
		
	}
	
	public AcceuilControleur getControleur() {
		return controleur;
	}

	public void setControleur(AcceuilControleur controleur) {
		this.controleur = controleur;
	}

	public static void main(String[] args) {
		Acceuil a=new Acceuil();
		a.setVisible(true);

	}

}