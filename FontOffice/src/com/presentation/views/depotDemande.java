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
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import com.business.Citoyen;
import com.business.Demande;
import com.presentation.controleurs.DepotDemandeControleur;


public class depotDemande extends JFrame {

	/**
	 * 
	 */
	private DepotDemandeControleur controleur;
	private static final long serialVersionUID = 1L;
	private JLabel connexion;
	private JLabel nomProcedure;
	private JButton continuer;
	private JPanel panel_nouth;
	private JPanel panel_center;
	private JPanel panel_south;
	private JPanel right;
	private JPanel left;
	private JComboBox<String> listeProcedures;
	private GridBagConstraints c;
	private JTextField Cin;
	/******************************/
	private JLabel documentProcedure;
	private JLabel documentcitoyen;
	private JLabel importer;
	private JLabel exporter;
	private JLabel home;
	private JPanel center;
	private File[] file;
	private JFileChooser fc;
	private JFileChooser fcexport;
	private JButton valider;
	private JPopupMenu pop;
	private Box box1;
	/********************/
	
	public depotDemande() {
		this.setTitle("Application de Gestion Des Processus Administratives");
		this.setSize(800,500);
		controleur = new DepotDemandeControleur();
		controleur.setDepotdemande(this);
		this.initialiser();
		this.setColors();
		this.setSizes();
		this.InitialierGridBagLayout();
		this.affectation();
		this.actionseconnecter();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	private void actionseconnecter() {
		continuer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listeProcedures.getSelectedItem()==null)
					controleur.acceder(Cin);
				else
					depotDemande.this.selectionner();
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
		nomProcedure.setFont(new Font("Cambria", Font.BOLD, 16));
		panel_nouth.setPreferredSize(new Dimension(600,40));
		panel_south.setPreferredSize(new Dimension(600,50));
		listeProcedures.setPreferredSize(new Dimension(190,25));
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
		connexion=new JLabel("Depôt d'une demande :");
		nomProcedure=new JLabel("Choisir une procédure :  ");
		panel_nouth = new JPanel();
		panel_nouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_south = new JPanel();
		//panel_south.setLayout(new BorderLayout());
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		listeProcedures=new JComboBox<String>(controleur.getNomProcedures());
		continuer=new JButton("Continuer");
	}
	
	private void InitialierGridBagLayout()
	{
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(nomProcedure,c);
		c.gridx=1;
		c.gridy=0;
		panel_center.add(listeProcedures,c);
	}
	public DepotDemandeControleur getControleur() {
		return controleur;
	}

	public void setControleur(DepotDemandeControleur controleur) {
		this.controleur = controleur;
	}
	/*******************************/
	public void actionvalider()
	{
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(file==null)
				{
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Vous n'avez pas importé des documents", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else {
					ArrayList<String> l=new ArrayList<String>();
					for(File f: file)
						l.add(f.getAbsolutePath());
					System.out.print(controleur.setDemande(new Demande(new Citoyen(Cin.getText()), l,
							controleur.getId(listeProcedures.getSelectedItem().toString()))));
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "La demande est enregistrée", "Information", JOptionPane.INFORMATION_MESSAGE);
					controleur.acceder(Cin);
				}
			}
		});
	}
	public void actionexport()
	{
		exporter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				try {
					Desktop.getDesktop().open(new java.io.File(controleur.getFile(listeProcedures.getSelectedItem().toString())));
				}catch( Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionimport()
	{
		importer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				int returnVal;
				if(a.getSource()==importer) {
					returnVal=fc.showOpenDialog(null);
					
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					file= fc.getSelectedFiles();
				}
			}
			}});
	}
	
	public void selectionner()
	{
		panel_center.removeAll();
		panel_center.updateUI();
		panel_south.removeAll();
		panel_south.updateUI();
		this.initialiserc();
		this.colors();
		this.initialiserLayout();
		this.actionexport();
		this.actionimport();
		this.actionvalider();
		panel_center.repaint();
	}
	
	public void initialiserc() {
		documentProcedure=new JLabel("La liste des documents nécessaires pour cette procédure :  ");
		documentcitoyen=new JLabel("Cliquez ici pour importer les documents :  ");
		ImageIcon i = new ImageIcon("icons/download1.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		importer = new JLabel(i);
		i = new ImageIcon("icons/upload1.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		exporter = new JLabel(i);
		c=new GridBagConstraints();
		fc=new JFileChooser();
		fc.setMultiSelectionEnabled(true);
		fcexport=new JFileChooser();
		valider = new JButton("Valider");
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
		panel_south.setLayout(new BorderLayout());
		left=new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		right=new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	
	private void actionHome() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder(Cin);
			}
		});
	}
	
	public void initialiserLayout() {
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(documentProcedure,c);
		c.gridx=1;
		panel_center.add(exporter,c);
		c.gridx=0;
		c.gridy=1;
		panel_center.add(documentcitoyen,c);
		c.gridx=1;
		c.gridy=1;
		panel_center.add(importer,c);
		left.add(valider);
		right.add(box1);
		panel_south.add(right,BorderLayout.WEST);
		panel_south.add(left,BorderLayout.EAST);
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(panel_south,BorderLayout.SOUTH);
	}
	
	private void colors() {
		documentcitoyen.setFont(new Font("Cambria", Font.BOLD, 20));	
		documentcitoyen.setForeground(new Color(0,64,128));
		documentProcedure.setFont(new Font("Cambria", Font.BOLD, 20));	
		documentProcedure.setForeground(new Color(0,64,128));
		documentProcedure.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 40));
		exporter.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 40));
		valider.setFont(new Font("Cambria", Font.BOLD, 18));
		valider.setBackground(new Color(0,98,145));
		valider.setForeground(Color.WHITE);
		panel_south.setPreferredSize(new Dimension(600,80));
		right.setBackground(SystemColor.inactiveCaptionBorder);
		left.setBackground(SystemColor.inactiveCaptionBorder);
		home.setFont(new Font("Cambria", Font.BOLD, 18));
		home.setForeground(new Color(0,64,128));
	}
	
	public void setCin(JTextField cin) {
		Cin = cin;
	}

	public static void main(String[] args) {
		depotDemande d=new depotDemande();
		d.setVisible(true);
	}
}
