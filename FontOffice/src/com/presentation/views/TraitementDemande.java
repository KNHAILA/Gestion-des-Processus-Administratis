package com.presentation.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.business.Decision;
import com.presentation.controleurs.TraitementDemandeControleur;


public class TraitementDemande extends JFrame {

	/**
	 * 
	 */
	private TraitementDemandeControleur controleur;
	private static final long serialVersionUID = 1L;
	private JLabel connexion;
	private JLabel nomDemande;
	private JButton continuer;
	private JPanel panel_nouth;
	private JPanel panel_center;
	private JPanel panel_south;
	private JComboBox<String> listeDemandes;
	private JComboBox<String> decisions;
	private JLabel decision;
	private GridBagConstraints c;
	private JTextField Cin;
	/******************************/
	private JLabel documentProcedure;
	private JLabel documentcitoyen;
	private JLabel importer;
	private JLabel exporter;
	private Box box;
	private JLabel telechager;
	private JLabel telecharger1;
	private JLabel rapport;
	private File file;
	private JFileChooser fc;
	private JButton valider;
	private JButton valider1;
	private JPanel p;
	
	private JPanel accRef;
	private JPanel left;
	private JPanel right;
	private JLabel Accepter;
	private JLabel Refuser;
	private JLabel caret;
	private Box box1;
	private Box box2;
	private Box box3;
	/********************/
	
	public TraitementDemande(JTextField n) {
		this.setCin(n);
		this.setTitle("Application de Gestion Des Processus Administratives");
		this.setSize(800,500);
		controleur = new TraitementDemandeControleur();
		controleur.setConsultdemande(this);
		this.initialiser();
		this.setColors();
		this.setSizes();
		this.InitialierGridBagLayout();
		this.affectation();
		this.actionseconnecter();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	private void firstPage()
	{
		panel_center.removeAll();
		panel_south.removeAll();
		panel_nouth.removeAll();
		String[] list = controleur.ListeDemande(Cin.getText());
		listeDemandes.removeAllItems();
		for(int i=0;i<list.length;i++)
			listeDemandes.addItem(list[i]);
		this.setColors();
		this.setSizes();
		this.InitialierGridBagLayout();
		this.affectation();
		this.actionseconnecter();
		this.repaint();
	}
	private void actionseconnecter() {
		continuer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listeDemandes.getSelectedItem()!=null)
					TraitementDemande.this.selectionner();
			}
		});
		
	}

	private void setColors()
	{
		panel_nouth.setBackground(SystemColor.inactiveCaption);
		panel_south.setBackground(SystemColor.inactiveCaptionBorder);
		continuer.setBackground(new Color(0,98,145));
		continuer.setForeground(Color.WHITE);

	}
	
	private void setSizes()
	{
		connexion.setFont(new Font("Cambria", Font.BOLD, 22));
		nomDemande.setFont(new Font("Cambria", Font.BOLD, 16));
		panel_nouth.setPreferredSize(new Dimension(600,40));
		panel_south.setPreferredSize(new Dimension(600,50));
		listeDemandes.setPreferredSize(new Dimension(600,25));
		listeDemandes.setFont(new Font("Cambria", Font.BOLD, 15));
		continuer.setFont(new Font("Cambria", Font.BOLD, 18));
		
		
	}
	
	private void affectation()
	{
		panel_nouth.add(connexion,BorderLayout.EAST);
		panel_south.add(continuer);
		getContentPane().add(panel_nouth, BorderLayout.NORTH);
		getContentPane().add(panel_south, BorderLayout.SOUTH);
		getContentPane().add(panel_center,BorderLayout.CENTER);
	}
	
	private void initialiser() {
		connexion=new JLabel("Consulter Les demandes :");
		nomDemande=new JLabel("Choisir une demande :  ");
		panel_nouth = new JPanel();
		panel_nouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_south = new JPanel();
		//panel_south.setLayout(new BorderLayout());
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		System.out.print("hhhhhhhhhh"+Cin.getText());
		listeDemandes=new JComboBox<String>(controleur.ListeDemande(Cin.getText()));
		continuer=new JButton("Continuer");
		panel_center.repaint();
	}
	
	private void InitialierGridBagLayout()
	{
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(nomDemande,c);
		c.gridx=1;
		c.gridy=0;
		panel_center.add(listeDemandes,c);
		panel_center.repaint();
	}
	
	public TraitementDemandeControleur getControleur() {
		return controleur;
	}
	
	public void setControleur(TraitementDemandeControleur controleur) {
		this.controleur = controleur;
	}
	/*******************************/
	public void actionimport()
	{
		box3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				int returnVal;
				if(a.getSource()==box3) {
					returnVal=fc.showOpenDialog(null);
					
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					file= fc.getSelectedFile();
				}
			}
			}});
	}
	
	public void actionvalidertraitement()
	{
		valider1.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(file==null)
				{
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Vous devez importer le rapport", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					controleur.Decision(new Decision(file.getAbsolutePath(),
							controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText()),
							Cin.getText(),
							decisions.getSelectedItem().toString()));
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Traitement effectué", "Information", JOptionPane.INFORMATION_MESSAGE);
					TraitementDemande.this.firstPage();
				}
			}
		});
	}
	
	
	public void actionexport()
	{
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				try {
					Desktop.getDesktop().open(new java.io.File(controleur.getFile(controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText()))));
				}catch( Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionexportfiles(JLabel d,String s)
	{
		d.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				try {
					Desktop.getDesktop().open(new java.io.File(s));
				}catch( Exception e)
				{
					e.printStackTrace();
				}
			}
			});
	}
	

	
	public void selectionner()
	{
		panel_center.removeAll();
		panel_center.updateUI();
		panel_south.removeAll();
		panel_south.updateUI();
		this.initialiserc();
		this.actionvalidertraitement();
		this.actionimport();
		this.colors();
		this.initialiserLayout();
		this.actionexport();
		panel_center.repaint();
	}
	
	public void initialiserc() {
		panel_south.setLayout(new BorderLayout());
		left=new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		right=new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telechager=new JLabel("Téléchager la liste");
		documentProcedure=new JLabel("La liste des documents nécessaires pour La procédure :  ");
		documentcitoyen=new JLabel("La liste des documents du citoyen : ");
		ImageIcon i = new ImageIcon("icons/upload1.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		exporter = new JLabel(i);
		box = Box.createVerticalBox();
		box.add(exporter);
		box.add(telechager);
		c=new GridBagConstraints();
		fc=new JFileChooser();		
		valider = new JButton("Valider");
		p=new JPanel();
		i = new ImageIcon("icons/file.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		String[] list=controleur.getDemandes(controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText()));
		p.setLayout(new GridLayout(1,list.length));
		for(int i1=0;i1<list.length;i1++)
		{
			c.anchor=GridBagConstraints.CENTER;
			String s=new String("file"+i1);
			JLabel label3 = new JLabel(s, i, JLabel.LEFT);
			label3.setVerticalTextPosition(SwingConstants.BOTTOM);
			label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 40));
			label3.setFont(new Font("Cambria", Font.BOLD, 15));	
			label3.setForeground(new Color(0,64,128));
			p.add(label3,c);
			this.actionexportfiles(label3,list[i1]);
		}
		rapport=new JLabel("Importer le rapport");
		i = new ImageIcon("icons/accept.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		Accepter=new JLabel("Accepter");
		box1 = Box.createVerticalBox();
		JLabel q = new JLabel(i);
		q.setBorder(BorderFactory.createEmptyBorder(0, 20, 00, 80));
		box1.add(q);
		box1.add(Accepter);
		
		i = new ImageIcon("icons/refuse.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		Refuser=new JLabel("Refuser");
		box2 = Box.createVerticalBox();
		JLabel q1 = new JLabel(i);
		q1.setBorder(BorderFactory.createEmptyBorder(0, 15, 00, 80));
		box2.add(q1);
		box2.add(Refuser);
		accRef=new JPanel();
		accRef.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telecharger1=new JLabel("Rapport");
		i = new ImageIcon("icons/download1.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		importer = new JLabel(i);
		box3 = Box.createVerticalBox();
		box3.add(importer);
		box3.add(telecharger1);
		decision=new JLabel("Décision : ");
		String[] lst= {"Acceptée","Refusée","Rejetée","Mise-à-jour"};
		decisions=new JComboBox<String>(lst);
		valider1=new JButton("Valider");
		fc=new JFileChooser();
		file=null;
		i = new ImageIcon("icons/left.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		caret=new JLabel(i);
		this.caret();
	}
	
	private void caret() {		
		caret.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				TraitementDemande.this.firstPage();
			}
		});
	}

	public void initialiserLayout() {
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(documentProcedure,c);
		c.anchor=GridBagConstraints.CENTER;
		c.gridx=0;
		c.gridy=1;
		panel_center.add(box,c);
		c.gridx=0;
		c.gridy=2;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		panel_center.add(documentcitoyen,c);
		c.gridx=0;
		c.gridy=3;
		panel_center.add(p,c);
		c.gridx=0;
		c.gridy=4;
		panel_center.add(rapport,c);
		c.anchor=GridBagConstraints.CENTER;
		c.gridx=0;
		c.gridy=5;
		panel_center.add(box3,c);
		c.anchor=GridBagConstraints.FIRST_LINE_END;
		c.gridx=0;
		c.gridy=6;
		panel_center.add(decision,c);
		c.gridx=1;
		c.gridy=6;
		panel_center.add(decisions,c);
		right.add(valider1);
		left.add(caret);
		panel_south.add(left,BorderLayout.WEST);
		panel_south.add(right,BorderLayout.EAST);
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(panel_south,BorderLayout.SOUTH);
	}
	
	private void colors() {
		left.setBackground(SystemColor.inactiveCaptionBorder);
		right.setBackground(SystemColor.inactiveCaptionBorder);
		documentcitoyen.setFont(new Font("Cambria", Font.BOLD, 20));	
		documentcitoyen.setForeground(new Color(0,64,128));
		documentProcedure.setFont(new Font("Cambria", Font.BOLD, 20));	
		documentProcedure.setForeground(new Color(0,64,128));
		documentProcedure.setBorder(BorderFactory.createEmptyBorder(0, 0, 00, 40));
		exporter.setBorder(BorderFactory.createEmptyBorder(0, 40, 00, 80));
		valider.setFont(new Font("Cambria", Font.BOLD, 18));
		valider.setBackground(new Color(0,98,145));
		valider.setForeground(Color.WHITE);
		valider1.setFont(new Font("Cambria", Font.BOLD, 18));
		valider1.setBackground(new Color(0,98,145));
		valider1.setForeground(Color.WHITE);
		telechager.setFont(new Font("Cambria", Font.BOLD, 15));	
		telechager.setForeground(Color.black);
		telecharger1.setFont(new Font("Cambria", Font.BOLD, 15));	
		telecharger1.setForeground(Color.black);
		importer.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 40));
		//panel_south.setPreferredSize(new Dimension(600,80));
		Accepter.setFont(new Font("Cambria", Font.BOLD, 18));
		Accepter.setForeground(new Color(0,64,128));
		Refuser.setFont(new Font("Cambria", Font.BOLD, 18));	
		Refuser.setForeground(new Color(0,64,128));
		accRef.setBackground(SystemColor.inactiveCaptionBorder);
		rapport.setFont(new Font("Cambria", Font.BOLD, 20));	
		rapport.setForeground(new Color(0,64,128));
	}
	
	public void setCin(JTextField n) {
		Cin=n;
	}

	public static void main(String[] args) {
		TraitementDemande d=new TraitementDemande(new JTextField("MINAA"));
		d.setVisible(true);
	}
}
