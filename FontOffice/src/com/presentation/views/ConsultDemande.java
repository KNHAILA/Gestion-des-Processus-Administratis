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
import javax.swing.SwingConstants;

import com.presentation.controleurs.ConsultDemandeControleur;


public class ConsultDemande extends JFrame {

	/**
	 * 
	 */
	private ConsultDemandeControleur controleur;
	private static final long serialVersionUID = 1L;
	private JLabel connexion;
	private JLabel nomDemande;
	private JButton continuer;
	private JPanel panel_nouth;
	private JPanel panel_center;
	private JPanel panel_south;
	private JComboBox<String> listeDemandes;
	private GridBagConstraints c;
	//private JTextField Cin;
	/******************************/
	private JLabel documentProcedure;
	private JLabel documentcitoyen;
	private JLabel exporter;
	private Box box;
	private JLabel telechager;
	//private File[] file;
	private JFileChooser fc;
	private JFileChooser fcexport;
	private JButton valider;
	private JPanel p;
	
	private JPanel accRefright;
	private JPanel accRefleft;
	private JLabel Accepter;
	private JLabel Refuser;
	private JLabel home;
	private Box box1;
	private Box box2;
	private Box box3;
	/********************/
	
	public ConsultDemande() {
		this.setTitle("Application de Gestion Des Processus Administratives");
		this.setSize(800,500);
		controleur = new ConsultDemandeControleur();
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
	
	private void actionseconnecter() {
		continuer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listeDemandes.getSelectedItem()==null)
					controleur.acceder();
				else
					ConsultDemande.this.selectionner(null);
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
		listeDemandes=new JComboBox<String>(controleur.ListeDemande());
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
	
	public ConsultDemandeControleur getControleur() {
		return controleur;
	}
	
	public void setControleur(ConsultDemandeControleur controleur) {
		this.controleur = controleur;
	}
	/*******************************/
	
	private void actionaccepter() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.accepter(controleur.getIdDemande(listeDemandes.getSelectedItem().toString()));
				JOptionPane jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "La demande est accéptée", "Information", JOptionPane.INFORMATION_MESSAGE);
				controleur.acceder();
			}
		});
		
	}

	private void actionrefuser() {
		box2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.refuser(controleur.getIdDemande(listeDemandes.getSelectedItem().toString()));
				JOptionPane jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "La demande est refusée", "Information", JOptionPane.INFORMATION_MESSAGE);
				controleur.acceder();
			}
		});
	}

	public void actionexport()
	{
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				try {
					Desktop.getDesktop().open(new java.io.File(controleur.getFile(controleur.getIdDemande(listeDemandes.getSelectedItem().toString()))));
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
	
	public void selectionner(String s)
	{
		panel_center.removeAll();
		panel_center.updateUI();
		panel_south.removeAll();
		panel_south.updateUI();
		this.initialiserc();
		this.colors();
		this.initialiserLayout();
		this.actionexport();
		this.actionaccepter();
		this.actionrefuser();
		panel_center.repaint();
	}
	
	public void initialiserc() {
		panel_south.setLayout(new BorderLayout());
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
		fc.setMultiSelectionEnabled(true);
		fcexport=new JFileChooser();
		valider = new JButton("Valider");
		p=new JPanel();
		i = new ImageIcon("icons/file.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		String[] list=controleur.getDemandes(controleur.getIdDemande(listeDemandes.getSelectedItem().toString()));
		p.setLayout(new GridLayout(1,list.length));
		for(int i1=0;i1<list.length;i1++)
		{
			c.anchor=GridBagConstraints.CENTER;
			System.out.println("g");
			String s=new String("file"+i1);
			JLabel label3 = new JLabel(s, i, JLabel.LEFT);
			label3.setVerticalTextPosition(SwingConstants.BOTTOM);
			label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 40));
			label3.setFont(new Font("Cambria", Font.BOLD, 15));	
			label3.setForeground(new Color(0,64,128));
			p.add(label3,c);
			this.actionexportfiles(label3,list[i1]);
		}
		i = new ImageIcon("icons/accept.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		Accepter=new JLabel("Accepter");
		box1 = Box.createVerticalBox();
		JLabel q = new JLabel(i);
		q.setBorder(BorderFactory.createEmptyBorder(0, 20, 00, 40));
		box1.add(q);
		box1.add(Accepter);
		
		i = new ImageIcon("icons/refuse.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		Refuser=new JLabel("Refuser");
		box2 = Box.createVerticalBox();
		JLabel q1 = new JLabel(i);
		q1.setBorder(BorderFactory.createEmptyBorder(0, 15, 00, 0));
		box2.add(q1);
		box2.add(Refuser);
		
		i = new ImageIcon("icons/home.png");
		m = i.getImage();
		n = m.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		home=new JLabel("Home");
		box3 = Box.createVerticalBox();
		JLabel q3 = new JLabel(i);
		q3.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 00));
		box3.add(q3);
		box3.add(home);
		accRefright=new JPanel();
		accRefright.setLayout(new FlowLayout(FlowLayout.RIGHT));
		accRefleft=new JPanel();
		accRefleft.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.actionHome();
	}
	
	private void actionHome() {
		box3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder();
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
		accRefright.add(box1);
		accRefright.add(box2);
		accRefleft.add(box3);
		
		panel_south.add(accRefleft,BorderLayout.WEST);
		panel_south.add(accRefright,BorderLayout.EAST);
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(panel_south,BorderLayout.SOUTH);
	}
	
	private void colors() {
		documentcitoyen.setFont(new Font("Cambria", Font.BOLD, 20));	
		documentcitoyen.setForeground(new Color(0,64,128));
		documentProcedure.setFont(new Font("Cambria", Font.BOLD, 20));	
		documentProcedure.setForeground(new Color(0,64,128));
		documentProcedure.setBorder(BorderFactory.createEmptyBorder(0, 0, 00, 40));
		exporter.setBorder(BorderFactory.createEmptyBorder(0, 40, 00, 80));
		valider.setFont(new Font("Cambria", Font.BOLD, 18));
		valider.setBackground(new Color(0,98,145));
		valider.setForeground(Color.WHITE);
		telechager.setFont(new Font("Cambria", Font.BOLD, 15));	
		telechager.setForeground(Color.black);
		panel_south.setPreferredSize(new Dimension(600,80));
		Accepter.setFont(new Font("Cambria", Font.BOLD, 18));
		Accepter.setForeground(new Color(0,64,128));
		Refuser.setFont(new Font("Cambria", Font.BOLD, 18));	
		Refuser.setForeground(new Color(0,64,128));
		home.setFont(new Font("Cambria", Font.BOLD, 18));
		home.setForeground(new Color(0,64,128));
		accRefright.setBackground(SystemColor.inactiveCaptionBorder);
		accRefleft.setBackground(SystemColor.inactiveCaptionBorder);
	}
	

	public static void main(String[] args) {
		ConsultDemande d=new ConsultDemande();
		d.setVisible(true);
	}
}
