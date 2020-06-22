package com.presentation.views;

import java.awt.*;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EtchedBorder;


import com.metier.business.DataException;
import com.metier.business.Procedure;
import com.presentation.controleurs.GestionEmployeControleur;
import com.presentation.controleurs.GestionProcedureControleur;

public class GestionProcedure1 extends JFrame {

	/**
	 * 
	 */
	private JTable procedures;
	private static final long serialVersionUID = 1L;
	private JPanel acenter;
	private JPanel affi=new JPanel(new GridLayout());
	private JPanel asouth;
	private GridBagConstraints c;
	private JLabel nomProc;
	private JLabel liste;
	private JButton listeEdit;
	private JTextField nomProcEdit;
	private final JFileChooser fc=new JFileChooser();
	private JLabel chef;
	private JComboBox<String> chefListe;
	private GestionProcedureControleur controleur1=new GestionProcedureControleur();
	private GestionEmployeControleur controleur=new GestionEmployeControleur();
	private JButton validerArch;
	private JButton valider;
	private JLabel aj;
	private JLabel ed;
	private JLabel ar;
	private JPanel AWest;
	
	
	private JLabel home;
	private ImageIcon i;
	private Box box;
	private Box box2;
	private Box box3;
	private Box box4;
	private Box box5;
	private JPanel ss;
	private JPanel sc;
	private JPanel aa;
	private JPanel ab;
	private JLabel gestion;
	private File file;
	 private String chemin="";
	public GestionProcedure1() {
		this.setTitle("Gestion des procédures");
		this.setSize(800,500);
		this.verticalMenu();
		this.c();
		this.s();
		this.initialiserAjout();
		this.InitialierGridBagLayoutAjout();
		this.setSizesAjout();
		this.cont();
		this.f();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		this.evenments();
	}
	
	private void verticalMenu()
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
		i=new ImageIcon("icons/aj.png");
		Image m=i.getImage();
		Image n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		aj =new JLabel("  Ajouter");
		box = Box.createHorizontalBox();
		JLabel image = new JLabel(i);
		box.add(image);
		box.add(aj);
		/****************************/
		i=new ImageIcon("icons/afficher.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		ed =new JLabel("  Afficher");
		box2 = Box.createHorizontalBox();
		JLabel afficher = new JLabel(i);
		box2.add(afficher);
		box2.add(ed);
		/*****************************/
		i=new ImageIcon("icons/arch.png");
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

		/***************************/
		i=new ImageIcon("icons/proc.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		gestion =new JLabel("Gestion des procédures :");
		box5 = Box.createHorizontalBox();
		JLabel image5 = new JLabel(i);
		box5.add(image5);
		box5.add(gestion);
		
		c=new GridBagConstraints();
		/***************************/
	}
	
	private void c() {
		AWest.setBackground(new Color(255, 218, 185));
		aa.setBackground(SystemColor.inactiveCaptionBorder);
		aa.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		ab.setBackground(SystemColor.inactiveCaptionBorder);
	}
	private void s() {
		AWest.setPreferredSize(new Dimension(200,500));
		aj.setFont(new Font("Cambria", Font.BOLD, 20));	
		aj.setForeground(new Color(0,64,128));
		//mo.setFont(new Font("Cambria", Font.BOLD, 20));	
		//mo.setForeground(new Color(0,64,128));
		ed.setFont(new Font("Cambria", Font.BOLD, 20));	
		ed.setForeground(new Color(0,64,128));
		ar.setFont(new Font("Cambria", Font.BOLD, 20));	
		ar.setForeground(new Color(0,64,128));
		home.setFont(new Font("Cambria", Font.BOLD, 20));	
		home.setForeground(new Color(0,64,128));
		gestion.setFont(new Font("Cambria", Font.BOLD, 20));	
		gestion.setForeground(new Color(0,64,128));
		
	}
	
		private void f() {

			ab.add(box5);
			acenter.add(ab,BorderLayout.NORTH);
			acenter.add(aa,BorderLayout.CENTER);
			AWest.add(ss,BorderLayout.SOUTH);
			AWest.add(sc,BorderLayout.CENTER);
			getContentPane().add(AWest,BorderLayout.WEST);
			getContentPane().add(acenter,BorderLayout.CENTER);
		}
	
		private void cont() {
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			sc.add(box,c);
			
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
		
	/*********************************************/

		private void initialiserAjout() {
			asouth=new JPanel();
			asouth.setLayout(new FlowLayout(FlowLayout.CENTER));
			asouth.setBackground(SystemColor.inactiveCaptionBorder);
			nomProc=new JLabel("Nom de procédure :");
			nomProcEdit=new JTextField();

			chef=new JLabel("chef de Service :");
			liste=new JLabel("Liste des documents :");
			listeEdit=new JButton("Télécharger la liste");
			chefListe=new JComboBox<String>(controleur.rempcombo1());
		
			valider=new JButton("Valider");
			validerArch=new JButton("Valider");
		
		}
		private void evenments(){
            valider.addActionListener(new ActionListener() {
				
		     	@Override
				public void actionPerformed(ActionEvent a){
					// TODO Auto-generated method stub
		     		try {
		     			Pattern pt = Pattern.compile("^(\\p{Alnum})+$");
		    			Matcher m = pt.matcher(nomProcEdit.getText());
		    			
		    			if(m.find()) {
						controleur1.addProcedure((new Procedure(nomProcEdit.getText(),controleur.searchEmploye(controleur.recupererNumEmploye(chefListe.getSelectedItem().toString())
								.toString()),chemin,false)));
						JOptionPane.showMessageDialog(null, "Procédure ajoutée");
						reset();
						
		    			}
						else {
							//nomProcEdit.setBorder(new LineBorder(Color.RED, 2));
							throw new DataException();	
							
						}
						
						}catch(DataException e)
		    		    {
							 System.out.print(e);
						 }
						catch(Exception d){
							d.printStackTrace();
						}
		     		
				     }
		     	
				});
		
		listeEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				int returnVal;
				if(a.getSource()==listeEdit) {
					returnVal=fc.showOpenDialog(null);
					
				if(returnVal==JFileChooser.APPROVE_OPTION) {
					file=fc.getSelectedFile();
				 chemin=file.getAbsolutePath();
				   }
				}
			}
			
		});
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				asouth.remove(validerArch);
				asouth.updateUI();
				acenter.remove(affi);
				acenter.updateUI();
				f();
				InitialierGridBagLayoutAjout();
				box.setEnabled(false);				
			}});
		box2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				
		         remplire();
				aa.updateUI();
				box2.setEnabled(false);				
			}});
		box3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				
		        archiver();
				aa.updateUI();
			}});
		validerArch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Procédures Archivées");
							ArrayList<Procedure> list=new ArrayList<Procedure>();
							list=((ModelProcedure2) procedures.getModel()).getMesProcedures();
						
							controleur1.archiver(list);

			}});

		box4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Acceuil a=new Acceuil();
				a.setSize(GestionProcedure1.this.getSize());
				a.setLocation(GestionProcedure1.this.getLocation());
				//a.setLocationRelativeTo(null);
				GestionProcedure1.this.dispose();
				a.setVisible(true);
			}
		});
		

		}

		private void InitialierGridBagLayoutAjout() {
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			aa.add(nomProc,c);
			c.gridx=1;
			c.gridy=0;
			aa.add(nomProcEdit,c);
			c.gridx=0;
			c.gridy=1;
			aa.add(chef,c);
			c.gridx=1;
			c.gridy=1;
			aa.add(chefListe,c);
			c.gridx=0;
			c.gridy=2;
			aa.add(liste,c);
			c.gridx=1;
			c.gridy=2;
			aa.add(listeEdit,c);
			c.gridx=1;
			c.gridy=3;
			asouth.add(valider);
			
			acenter.add(asouth,BorderLayout.SOUTH);
		}

		private void setSizesAjout() {
			nomProc.setFont(new Font("Cambria", Font.BOLD, 16));
			nomProc.setForeground(new Color(0,64,128));
			liste.setFont(new Font("Cambria", Font.BOLD, 16));
			liste.setForeground(new Color(0,64,128));
			listeEdit.setFont(new Font("Cambria", Font.BOLD, 16));
			listeEdit.setForeground(new Color(0,64,128));
			chef.setFont(new Font("Cambria", Font.BOLD, 16));
			chef.setForeground(new Color(0,64,128));
			nomProcEdit.setPreferredSize(new Dimension(200,30));
		
			chefListe.setPreferredSize(new Dimension(200,30));
			nomProc.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			chef.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			valider.setFont(new Font("Cambria", Font.BOLD, 18));
			valider.setForeground(new Color(0,64,128));
			validerArch.setFont(new Font("Cambria", Font.BOLD, 18));
			validerArch.setForeground(new Color(0,64,128));
			listeEdit.setPreferredSize(new Dimension(200,30));
			
		}
		
	   private void reset() {
		   
		   nomProcEdit.setText("");
		   chefListe.setSelectedIndex(0);
		   
	   }
	   private void remplire() {
		   acenter.removeAll();
			acenter.updateUI();
			acenter.add(ab,BorderLayout.NORTH);
			affi.removeAll();
			affi.updateUI();
		   ArrayList<Procedure> liste=new ArrayList<Procedure>();
		   liste=controleur1.listeActive();
		   ModelProcedure model=new ModelProcedure(liste);
		   procedures=new JTable(model);
		   acenter.remove(asouth);
		  procedures.setColumnSelectionAllowed(true);
		   affi.add(new JScrollPane(procedures));
		   affi.setBackground(SystemColor.inactiveCaptionBorder);
			affi.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		   acenter.add(affi,BorderLayout.CENTER);
		   acenter.updateUI();
		   this.repaint();
		  
	   }
	   public void archiver() {
		   acenter.removeAll();
		   acenter.updateUI();
		   acenter.add(ab,BorderLayout.NORTH);
		   affi.removeAll();
		   affi.updateUI();
		   affi=new JPanel(new GridLayout());
		   ArrayList<Procedure> liste=new ArrayList<Procedure>();
		   liste=controleur1.listeActive();
		   ModelProcedure2 model=new ModelProcedure2(liste);
		   procedures=new JTable(model);
		   procedures.setFillsViewportHeight(true);
		   affi.add(new JScrollPane(procedures));
		   ((ModelProcedure2)procedures.getModel()).fireTableDataChanged();
		   affi.setBackground(SystemColor.inactiveCaptionBorder);
		   affi.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		   acenter.add(affi,BorderLayout.CENTER);
		   asouth.remove(valider);
		   asouth.add(validerArch);
		   acenter.updateUI();
		   acenter.add(asouth,BorderLayout.SOUTH);
		   acenter.updateUI();
		   this.repaint(); 
	   }

	public void setControleur(GestionProcedureControleur gestionProcedureControleur) {
		// TODO Auto-generated method stub
		this.controleur1=gestionProcedureControleur;
	}

}
