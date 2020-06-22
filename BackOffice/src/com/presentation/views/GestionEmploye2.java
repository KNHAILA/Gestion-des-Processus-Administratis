package com.presentation.views;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import com.metier.business.Employe;
import com.metier.businessmanger.ServiceManager;
import com.persistance.dao.DAOEmploye;
import com.presentation.controleurs.GestionEmployeControleur;
//import com.presentation.controleurs.controleur;

import java.awt.Color;

public class GestionEmploye2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GestionEmployeControleur controleur;
	private Employe employe=new Employe(" ",false);
	
	private JPanel acenter;
	private JPanel asouth;
	private GridBagConstraints c;
	private JLabel NomA;
	private JLabel ischef;
	private JCheckBox chefEdit;
	private JTextField NomAEdit;
	private JLabel PrenomA;
	private JTextField PrenomAEdit;
	private JLabel dateNaissance;
	private JTextField DateNaissanceAEdit;
	private JLabel Service;
	private JComboBox<String> ServiceListe;
	private JLabel dateEmbauche;
	private JTextField DateEmbaucheAEdit;
	private JButton valider;
	private JButton validerMod;
	private JButton validerArchiv;

	private JPanel AWest;
	private JLabel aj;
	private JLabel mo;
	private JLabel ed;
	private JLabel ar;
	private JLabel home;
	private ImageIcon i;
	private Box box;
	private Box box1;
	private Box box2;
	private Box box3;
	private Box box4;
	private Box box5;
	private JPanel ss;
	private JPanel sc;
	private JPanel aa;
	private JPanel affi;
	private JPanel ab;
	private JLabel gestion;

	private JTable table;
	private JTable tablear;
	private JTextField rechercheMatricule;
	private Box box6;
	
	public GestionEmploye2() {
		controleur=new GestionEmployeControleur();
		this.setControleur(controleur);
		controleur.setGestionpersonnel(this);
		this.setTitle("Gestion des employés");
		this.setSize(800,500);
		this.initialiserMenu();
		this.initialisermodifier();
		this.colorMenu();
		this.sizeMenu();
		this.sizeAjout();
		this.initialiserAjout();
		this.InitialierGridBagLayoutAjout();
		this.setSizesAjout();
		this.InitialiserGridMenu();
		this.affectationMenu();
		this.affectationAjout();
		this.actionAjouter();
		this.actionmodifier();
		this.actionAfficher();
		this.actionhome();
		this.actionvaliderajout();
		this.actionvalidermodifier();
		this.actionrechercher();
		this.actionArchiver();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	
	private void actionvaliderArchiver() {
		validerArchiv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Employe> list=new ArrayList<Employe>();
				list=((ModelEmployeArchive) tablear.getModel()).getLesEtudiants();
				controleur.archiver(list);
			}
		});
		
	}

	private void actionrechercher() {
		box6.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				Employe e1=null;
				e1=controleur.searchEmploye(rechercheMatricule.getText());
				if(e1==null) {
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null, "La Matricule n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else {
					NomAEdit.setText(e1.getNom());
					PrenomAEdit.setText(e1.getPrenom());
					DateEmbaucheAEdit.setText(e1.getDateEmbauche());
					DateNaissanceAEdit.setText(e1.getDateNaissance());
					ServiceListe.setSelectedItem(e1.getService().getNom());
					chefEdit.setSelected(e1.getChef());
				}
			}
		});
		
	}

	private void actionvaliderajout() {
		valider.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop1 = new JOptionPane();
				if(traitementestValise(NomAEdit.getText(), PrenomAEdit.getText(), DateNaissanceAEdit.getText(),DateEmbaucheAEdit.getText()))
				{
					GestionEmploye2.this.setEmploye(new Employe(NomAEdit.getText(), 
						PrenomAEdit.getText(), 
						DateNaissanceAEdit.getText(),
						DateEmbaucheAEdit.getText(),
						controleur.setService(ServiceListe.getSelectedItem().toString()),
						chefEdit.isSelected()));
					controleur.addEmploye();
					jop1.showMessageDialog(null, "Les données sont enregistrées", "Information", JOptionPane.INFORMATION_MESSAGE);
					NomAEdit.setText(""); 
					PrenomAEdit.setText(""); 
					DateNaissanceAEdit.setText("");
					DateEmbaucheAEdit.setText("");
					chefEdit.setSelected(false);
				}
				else
				{
					jop1.showMessageDialog(null, "Les données sont invalides", "Information", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	private void actionvalidermodifier() {
	validerMod.addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop1 = new JOptionPane();
				if(traitementestValise(NomAEdit.getText(), PrenomAEdit.getText(), DateNaissanceAEdit.getText(),DateEmbaucheAEdit.getText()))
				{
					System.out.print(ServiceListe.getSelectedItem());
					System.out.print(controleur.setService(ServiceListe.getSelectedItem().toString()).toString());
					GestionEmploye2.this.setEmploye(new Employe(rechercheMatricule.getText(),
						NomAEdit.getText(), 
						PrenomAEdit.getText(), 
						DateNaissanceAEdit.getText(),
						DateEmbaucheAEdit.getText(),
						controleur.setService(ServiceListe.getSelectedItem().toString()),
						chefEdit.isSelected()));
					controleur.updateEmploye();
					jop1.showMessageDialog(null, "Les données sont enregistrées", "Information", JOptionPane.INFORMATION_MESSAGE);
					NomAEdit.setText(""); 
					PrenomAEdit.setText(""); 
					DateNaissanceAEdit.setText("");
					DateEmbaucheAEdit.setText("");
					chefEdit.setSelected(false);
				}
				else
				{
					jop1.showMessageDialog(null, "Les données sont invalides", "Information", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	private void actionhome() {
		box4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			controleur.home();
			}
		});
		
	}

	private void actionArchiver() {
		box3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionEmploye2.this.acenter.remove(aa);
				GestionEmploye2.this.archivage();
			}
		});
		
	}

	private void actionAfficher() {
		box2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionEmploye2.this.acenter.remove(aa);
				GestionEmploye2.this.affichage();
			}
		});
		
	}

	private void actionmodifier() {
		box1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GestionEmploye2.this.initialisermodifier();
				GestionEmploye2.this.affectationModifier();
				//GestionEmploye2.this.pack();
				GestionEmploye2.this.repaint();
			}
		});
		
	}

	private void actionAjouter() {
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionEmploye2.this.affectationAjout();
			}
		});
		
	}

	private void affichage()
	{
		acenter.removeAll();
		acenter.updateUI();
		ab.remove(box6);
		ab.updateUI();
		this.repaint();
		ab.add(box5);
		acenter.add(ab,BorderLayout.NORTH);
		affi=new JPanel(new GridLayout());
		DAOEmploye e=new DAOEmploye();
		ArrayList<Employe> list=new ArrayList<Employe>();
		list=e.getAll();
		ModelEmploye model = new ModelEmploye(list);
		table = new JTable(model);
		JScrollPane j=new JScrollPane(table);
		affi.add(j);
		acenter.remove(asouth);
		affi.setBackground(SystemColor.inactiveCaptionBorder);
		affi.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		acenter.add(affi,BorderLayout.CENTER);
		acenter.updateUI();
		acenter.updateUI();
		this.repaint();
	}
	
	private void archivage()
	{
		acenter.removeAll();
		acenter.updateUI();
		asouth.removeAll();
		asouth.updateUI();
		ab.remove(box6);
		ab.updateUI();
		this.repaint();
		ab.add(box5);
		acenter.add(ab,BorderLayout.NORTH);
		affi=new JPanel(new GridLayout());
		ArrayList<Employe> list=new ArrayList<Employe>();
		list=controleur.listeActibve();
		ModelEmployeArchive model = new ModelEmployeArchive(list);
		tablear = new JTable(model);
		JScrollPane j=new JScrollPane(tablear);
		affi.add(j);
		validerArchiv=new JButton("valider");
		validerArchiv.setFont(new Font("Cambria", Font.BOLD, 18));
		validerArchiv.setForeground(new Color(0,64,128));
		asouth.add(validerArchiv);
		this.actionvaliderArchiver();
		acenter.remove(asouth);
		affi.setBackground(SystemColor.inactiveCaptionBorder);
		affi.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		acenter.add(affi,BorderLayout.CENTER);
		acenter.add(asouth,BorderLayout.SOUTH);
		acenter.updateUI();
		acenter.updateUI();
		this.repaint();
	}
	
	public void initialisermodifier()
	{
		//ab.remove(box5);
		i=new ImageIcon("icons/search.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		this.rechercheMatricule =new JTextField("Saisir le matricule");
		this.rechercheMatricule.setPreferredSize(new Dimension(200,30));
		this.box6 = Box.createHorizontalBox();
		JLabel image5 = new JLabel(i);
		this.box6.add(image5);
		this.box6.add(rechercheMatricule);
		validerMod=new JButton("Valider");
		this.actionrechercher();
		this.actionvalidermodifier();
		//ab.updateUI();
	}


	private void initialiserMenu()
	{
		AWest =new JPanel();
		AWest.setLayout(new BorderLayout());
		acenter=new JPanel();
		acenter.setLayout(new BorderLayout());
		ss=new JPanel();
		sc=new JPanel();
		ab=new JPanel(new FlowLayout(FlowLayout.CENTER));
		aa=new JPanel(new GridBagLayout());

		/***********************/
		i=new ImageIcon("icons/add-user-icon.png");
		Image m=i.getImage();
		Image n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		aj =new JLabel("  Ajouter");
		box = Box.createHorizontalBox();
		JLabel image = new JLabel(i);
		box.add(image);
		box.add(aj);
		/**************************/
		i=new ImageIcon("icons/edit-user-icon.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		mo =new JLabel("  Modifier");
		box1 = Box.createHorizontalBox();
		JLabel image1 = new JLabel(i);
		box1.add(image1);
		box1.add(mo);
		/**************************/
		i=new ImageIcon("icons/user-group-icon.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		ed =new JLabel("  Afficher");
		box2 = Box.createHorizontalBox();
		JLabel image2 = new JLabel(i);
		box2.add(image2);
		box2.add(ed);
		/*****************************/
		i=new ImageIcon("icons/offline-user-icon.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		ar =new JLabel("  Archiver");
		box3 = Box.createHorizontalBox();
		JLabel image3 = new JLabel(i);
		box3.add(image3);
		box3.add(ar);
		/**********************/
		i=new ImageIcon("icons/home.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		home =new JLabel("  Home");
		box4 = Box.createHorizontalBox();
		JLabel image4 = new JLabel(i);
		box4.add(image4);
		box4.add(home);
		/******************                    *********/
		i=new ImageIcon("icons/Users-icon.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		gestion =new JLabel("Gestion du personnel :");
		box5 = Box.createHorizontalBox();
		JLabel image5 = new JLabel(i);
		box5.add(image5);
		box5.add(gestion);
		
		c=new GridBagConstraints();
	}
	
	private void colorMenu() {
		AWest.setBackground(new Color(255, 218, 185));
		aa.setBackground(SystemColor.inactiveCaptionBorder);
		aa.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		ab.setBackground(SystemColor.inactiveCaptionBorder);
	}
	
	private void sizeMenu() {
		AWest.setPreferredSize(new Dimension(200,500));
		aj.setFont(new Font("Cambria", Font.BOLD, 20));	
		aj.setForeground(new Color(0,64,128));
		mo.setFont(new Font("Cambria", Font.BOLD, 20));	
		mo.setForeground(new Color(0,64,128));
		ed.setFont(new Font("Cambria", Font.BOLD, 20));	
		ed.setForeground(new Color(0,64,128));
		ar.setFont(new Font("Cambria", Font.BOLD, 20));	
		ar.setForeground(new Color(0,64,128));
		home.setFont(new Font("Cambria", Font.BOLD, 20));	
		home.setForeground(new Color(0,64,128));
	}
	
	private void sizeAjout()
	{
		gestion.setFont(new Font("Cambria", Font.BOLD, 20));	
		gestion.setForeground(new Color(0,64,128));
	}
	
	private void affectationAjout()
	{
		acenter.removeAll();
		asouth.removeAll();
		acenter.updateUI();
		this.repaint();
		ab.remove(box6);
		ab.add(box5);
		ab.updateUI();
		this.InitialierGridBagLayoutAjout();
		acenter.add(ab,BorderLayout.NORTH);
		acenter.add(aa,BorderLayout.CENTER);
		getContentPane().add(acenter,BorderLayout.CENTER);
		acenter.updateUI();
		this.repaint();
	}
	
	private void affectationMenu() {
			AWest.add(ss,BorderLayout.SOUTH);
			AWest.add(sc,BorderLayout.CENTER);
			getContentPane().add(AWest,BorderLayout.WEST);
		}
	
		private void affectationModifier() {
			acenter.removeAll();
			asouth.removeAll();
			ab.remove(box5);
			ab.updateUI();
			this.repaint();
			ab.add(box6);
			this.InitialierGridBagLayoutModifier();
			acenter.add(ab,BorderLayout.NORTH);
			acenter.add(aa,BorderLayout.CENTER);
			AWest.add(ss,BorderLayout.SOUTH);
			AWest.add(sc,BorderLayout.CENTER);
			getContentPane().add(AWest,BorderLayout.WEST);
			getContentPane().add(acenter,BorderLayout.CENTER);
			acenter.updateUI();
			this.repaint();

		}
		
		private void InitialierGridBagLayoutModifier() {
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			aa.add(NomA,c);
			c.gridx=1;
			c.gridy=0;
			aa.add(NomAEdit,c);
			c.gridx=0;
			c.gridy=1;
			aa.add(PrenomA,c);
			c.gridx=1;
			c.gridy=1;
			aa.add(PrenomAEdit,c);
			c.gridx=0;
			c.gridy=2;
			aa.add(dateNaissance,c);
			c.gridx=1;
			c.gridy=2;
			aa.add(DateNaissanceAEdit,c);
			c.gridx=0;
			c.gridy=3;
			aa.add(Service,c);
			c.gridx=1;
			c.gridy=3;
			aa.add(ServiceListe,c);
			c.gridx=0;
			c.gridy=4;
			aa.add(dateEmbauche,c);
			c.gridx=1;
			c.gridy=4;
			aa.add(DateEmbaucheAEdit,c);
			c.gridx=0;
			c.gridy=5;
			aa.add(ischef,c);
			c.gridx=1;
			c.gridy=5;
			aa.add(chefEdit,c);
			validerMod.setFont(new Font("Cambria", Font.BOLD, 18));
			validerMod.setForeground(new Color(0,64,128));
			asouth.add(validerMod);	
			acenter.add(asouth,BorderLayout.SOUTH);
			
		}

		private void InitialiserGridMenu() {
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			sc.add(box,c);
			c.gridx=0;
			c.gridy=1;
			sc.add(box1,c);
			c.gridx=0;
			c.gridy=2;
			sc.add(box2,c);
			c.gridx=0;
			c.gridy=3;
			sc.add(box3,c);
			c.gridx=0;
			c.gridy=6;
			ss.add(box4,c);
		}
		

		private void initialiserAjout() {
			asouth=new JPanel();
			asouth.setLayout(new FlowLayout(FlowLayout.CENTER));
			asouth.setBackground(SystemColor.inactiveCaptionBorder);
			NomA=new JLabel("Nom :");
			NomAEdit=new JTextField();
			ischef=new JLabel("isChef :");
			chefEdit=new JCheckBox();
			PrenomA=new JLabel("Prenom :");
			PrenomAEdit=new JTextField();
			dateNaissance=new JLabel("Date de naissance :");
			DateEmbaucheAEdit=new JTextField();
			DateNaissanceAEdit=new JTextField();
			Service=new JLabel("Service :");
			ServiceManager o=new ServiceManager();
			ServiceListe=new JComboBox<String>(o.ListeNoms());
			dateEmbauche=new JLabel("Date d'embauche :");
			valider=new JButton("Valider"); 
		}


		private void InitialierGridBagLayoutAjout() {
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			aa.add(NomA,c);
			c.gridx=1;
			c.gridy=0;
			aa.add(NomAEdit,c);
			c.gridx=0;
			c.gridy=1;
			aa.add(PrenomA,c);
			c.gridx=1;
			c.gridy=1;
			aa.add(PrenomAEdit,c);
			c.gridx=0;
			c.gridy=2;
			aa.add(dateNaissance,c);
			c.gridx=1;
			c.gridy=2;
			aa.add(DateNaissanceAEdit,c);
			c.gridx=0;
			c.gridy=3;
			aa.add(Service,c);
			c.gridx=1;
			c.gridy=3;
			aa.add(ServiceListe,c);
			c.gridx=0;
			c.gridy=4;
			aa.add(dateEmbauche,c);
			c.gridx=1;
			c.gridy=4;
			aa.add(DateEmbaucheAEdit,c);
			c.gridx=0;
			c.gridy=5;
			aa.add(ischef,c);
			c.gridx=1;
			c.gridy=5;
			aa.add(chefEdit,c);
			asouth.add(valider);	
			acenter.add(asouth,BorderLayout.SOUTH);
		}

		private void setSizesAjout() {
			NomA.setFont(new Font("Cambria", Font.BOLD, 16));
			NomA.setForeground(new Color(0,64,128));
			ischef.setFont(new Font("Cambria", Font.BOLD, 16));
			ischef.setForeground(new Color(0,64,128));
			PrenomA.setFont(new Font("Cambria", Font.BOLD, 16));
			PrenomA.setForeground(new Color(0,64,128));
			dateNaissance.setFont(new Font("Cambria", Font.BOLD, 16));
			dateNaissance.setForeground(new Color(0,64,128));
			dateEmbauche.setFont(new Font("Cambria", Font.BOLD, 16));
			dateEmbauche.setForeground(new Color(0,64,128));
			Service.setFont(new Font("Cambria", Font.BOLD, 16));
			Service.setForeground(new Color(0,64,128));
			NomAEdit.setPreferredSize(new Dimension(200,30));
			PrenomAEdit.setPreferredSize(new Dimension(200,30));
			DateNaissanceAEdit.setPreferredSize(new Dimension(200,30));
			DateEmbaucheAEdit.setPreferredSize(new Dimension(200,30));
			ServiceListe.setPreferredSize(new Dimension(200,30));
			NomA.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			ischef.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			PrenomA.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			dateNaissance.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			dateEmbauche.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			Service.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			valider.setFont(new Font("Cambria", Font.BOLD, 18));
			valider.setForeground(new Color(0,64,128));
		}
		public GestionEmployeControleur getControleur() {
			return controleur;
		}

		public void setControleur(GestionEmployeControleur controleur) {
			this.controleur = controleur;
			//controleur.setGestionpersonnel(this);
		}

		public Employe getEmploye() {
			return employe;
		}

		public void setEmploye(Employe employe) {
			this.employe = employe;
		}
		
		public boolean traitementestValise(String a,String b,String c,String d)
		{
			ExpressionReguliere e=new ExpressionReguliere();
			boolean f= true;
			Border redBorder=new LineBorder(Color.RED, 2, true);
			Border blackBorder=new JTextField().getBorder();
			if(!e.Nom_PrenomIsValide(a))
			{
				NomAEdit.setBorder(redBorder);
				NomAEdit.setText("not valid");
				NomAEdit.setForeground(Color.RED);
				f=false;
			}
			else if(e.Nom_PrenomIsValide(a))
			{
				NomAEdit.setBorder(blackBorder);
				NomAEdit.setForeground(Color.black);
			}
			
			if(!e.Nom_PrenomIsValide(b))
			{
				PrenomAEdit.setBorder(redBorder);
				PrenomAEdit.setText("not valid");
				PrenomAEdit.setForeground(Color.RED);
				f=false;
			}
			else if(e.Nom_PrenomIsValide(b))
			{
				PrenomAEdit.setBorder(blackBorder);
				PrenomAEdit.setForeground(Color.black);
			}
			
			if(!e.DateIsValide(c))
			{
				DateNaissanceAEdit.setBorder(redBorder);
				DateNaissanceAEdit.setText("not valid");
				DateNaissanceAEdit.setForeground(Color.RED);
				f=false;
			}
			else if(e.DateIsValide(c))
			{
				DateNaissanceAEdit.setBorder(blackBorder);
				DateNaissanceAEdit.setForeground(Color.black);
			}
			
			if(!e.DateIsValide(d))
			{
				DateEmbaucheAEdit.setBorder(redBorder);
				DateEmbaucheAEdit.setText("not valid");
				DateEmbaucheAEdit.setForeground(Color.RED);
				f=false;
			}
			else if(e.DateIsValide(d))
			{
				DateEmbaucheAEdit.setBorder(blackBorder);
				DateEmbaucheAEdit.setForeground(Color.black);
			}
			return f;
		}
		
}
