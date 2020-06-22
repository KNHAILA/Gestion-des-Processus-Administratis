package com.presentation.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

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
import com.presentation.controleurs.SuivreDemandeControleur;

public class SuivreDemande extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SuivreDemandeControleur controleur;
	private JLabel connexion;
	private JLabel nomDemande;
	private JButton continuer;
	private JPanel panel_nouth;
	private JPanel panel_center;
	private JPanel panel_south;
	private JComboBox<String> listeDemandes;
	private GridBagConstraints c;
	private JTextField Cin;
	/******************************/
	private JLabel documentcitoyen;
	private JLabel nomProcedure;
	private JLabel modifier;
	private JLabel modifiericone;
	private JLabel importer;
	private JLabel exporter;
	private JLabel decision;
	private Box box;
	private JLabel telechager;
	private JLabel rapport;
	private File[] file;
	private JFileChooser fc;
	/********************/
	private JButton Valider;
	private Box box1;
	private JLabel home;
	private JPanel left;
	private JPanel right;
	
	public SuivreDemande(JTextField n) {
		this.setCin(n);
		this.setTitle("Application de Gestion Des Processus Administratives");
		this.setSize(800,500);
		controleur = new SuivreDemandeControleur();
		controleur.setSuivredemande(this);
		this.initialiser();
		this.setColors();
		this.setSizes();
		this.InitialierGridBagLayout();
		this.affectation();
		this.actionsecontinuer();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	private void actionsecontinuer() {
		continuer.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listeDemandes.getSelectedItem()==null)
					controleur.acceder(Cin);
				else
				{
					int ordre=controleur.OrdreDemande(controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText()));
					int demande=controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText());
					System.out.println(demande);
					if(ordre==0 && controleur.RapportDemande(demande)==null)
					{
						JOptionPane jop1 = new JOptionPane();
						jop1.showMessageDialog(null, "La demande n'est pas encore traitée", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(ordre==-3)
					{
						JOptionPane jop1 = new JOptionPane();
						jop1.showMessageDialog(null, "La demande est terminée", "Information", JOptionPane.INFORMATION_MESSAGE);
				
					}
					else
					{
						int ordreDecision;
						ordreDecision=controleur.OrdreDecision(demande);
						String m=controleur.etatDemande(demande);
						if(ordre<0)
							SuivreDemande.this.selectionner("Votre demande est "+m+" et arrivée à l'étape "+ordreDecision,controleur.ProcedureDemande(demande));
						if(ordre>=0)
						{
							ordreDecision++;
							SuivreDemande.this.selectionner("Votre demande est "+m+" et arrivée à l'étape "+ordreDecision,controleur.ProcedureDemande(demande));
							SuivreDemande.this.modifier();
						}		
					}
				}
			}
		});
		
	}
	
	public void modifier()
	{
		modifier=new JLabel("Cliquer pour modifier les documents :");
		ImageIcon i = new ImageIcon("icons/upload1.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		modifiericone= new JLabel(i);
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=4;
		panel_center.add(modifier,c);
		c.gridx=1;
		c.gridy=4;
		panel_center.add(modifiericone,c);
		this.actionmodifer();
		modifier.setFont(new Font("Cambria", Font.BOLD, 20));
		modifier.setForeground(new Color(0,64,128));
		Valider=new JButton("Valider");
		left.add(Valider);
		Valider.setFont(new Font("Cambria", Font.BOLD, 18));
		Valider.setBackground(new Color(0,98,145));
		Valider.setForeground(Color.WHITE);
		panel_south.add(left,BorderLayout.EAST);
		this.actionValider();
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(panel_south,BorderLayout.SOUTH);
	}
	
	private void actionValider() {
		Valider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print("jjjjj");
				if(file!=null)
				{
					int demande=controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText());
					ArrayList<String> l=new ArrayList<String>();
					for(File f: file)
						l.add(f.getAbsolutePath());
					controleur.update(demande,l);
					controleur.acceder(Cin);
				}
				else
				{
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Vous n'avez pas importé des documents ", "Information", JOptionPane.INFORMATION_MESSAGE);
			
				}
			}
		});
	}
	
	private void actionmodifer() {
		modifiericone.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseClicked(MouseEvent a) {
					int returnVal;
					if(a.getSource()==modifiericone) {
						returnVal=fc.showOpenDialog(null);
						
					if(returnVal==JFileChooser.APPROVE_OPTION) {
						file= fc.getSelectedFiles();
					}
				}
				}});
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
		listeDemandes.setPreferredSize(new Dimension(500,25));
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
		listeDemandes=new JComboBox<String>(controleur.ListeDemande(Cin.getText()));
		continuer=new JButton("Continuer");
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
	}
	
	public SuivreDemandeControleur getControleur() {
		return controleur;
	}
	
	public void setControleur(SuivreDemandeControleur controleur) {
		this.controleur = controleur;
	}
	/*******************************/
	/*public void actionimport()
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
	*/
	public void actionexport()
	{
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				try {
					Desktop.getDesktop().open(new java.io.File(controleur.RapportDemande(controleur.getIdDemande(listeDemandes.getSelectedItem().toString(),Cin.getText()))));
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
	

	
	public void selectionner(String s,String f)
	{
		panel_center.removeAll();
		panel_center.updateUI();
		panel_south.removeAll();
		panel_south.updateUI();
		this.initialiserc(s,f);
		//this.actionimport();
		this.colors();
		this.initialiserLayout();
		this.actionexport();
		panel_center.repaint();
	}
	
	public void initialiserc(String s,String f) {
		panel_south.setLayout(new BorderLayout());
		left=new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		right=new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.RIGHT));
		nomProcedure=new JLabel("Nom de procedure : "+f);
		decision=new JLabel(s);
		telechager=new JLabel("Téléchager le rapport");
		rapport=new JLabel("Rapport de choix de décision :  ");
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
		fc.setMultiSelectionEnabled(true);
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
		this.actionHome();
	}
	
	private void actionHome() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder(Cin);
			}
		});
		
	}
	
	public void intialiserNonTermineRejet()
	{
		documentcitoyen=new JLabel("Cliquez ici pour importer les documents :");
		ImageIcon i = new ImageIcon("icons/download1.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		importer = new JLabel(i);
	}
	public void initialiserLayout() {
		c.anchor=GridBagConstraints.CENTER;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(nomProcedure,c);
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=1;
		panel_center.add(decision,c);
		c.gridx=0;
		c.gridy=2;
		panel_center.add(rapport,c);
		c.anchor=GridBagConstraints.CENTER;
		c.gridx=0;
		c.gridy=3;
		panel_center.add(box,c);
		c.gridx=0;
		c.gridy=4;
		right.add(box1);
		
		panel_south.add(right,BorderLayout.WEST);
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(panel_south,BorderLayout.SOUTH);
	}
	
	private void colors() {
		exporter.setBorder(BorderFactory.createEmptyBorder(0, 40, 00, 80));
		telechager.setFont(new Font("Cambria", Font.BOLD, 15));	
		telechager.setForeground(Color.black);
		nomProcedure.setFont(new Font("Cambria", Font.BOLD, 20));
		nomProcedure.setForeground(new Color(0,64,128));
		nomProcedure.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		decision.setFont(new Font("Cambria", Font.BOLD, 20));
		decision.setForeground(new Color(240,36,98));
		decision.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		home.setFont(new Font("Cambria", Font.BOLD, 18));
		home.setForeground(new Color(0,64,128));
		right.setBackground(SystemColor.inactiveCaptionBorder);
		left.setBackground(SystemColor.inactiveCaptionBorder);
		//importer.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 40));
		panel_south.setPreferredSize(new Dimension(600,80));
		rapport.setFont(new Font("Cambria", Font.BOLD, 20));	
		rapport.setForeground(new Color(0,64,128));
		box.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
	}
	
	public void setCin(JTextField n) {
		Cin=n;
	}
	
	public static void main(String[] args) {
		SuivreDemande d=new SuivreDemande(new JTextField("A1234"));
		d.setVisible(true);
	}

}
