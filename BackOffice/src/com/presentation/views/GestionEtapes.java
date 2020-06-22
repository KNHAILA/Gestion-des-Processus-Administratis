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
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.NumberFormatter;

import com.metier.business.Etape;
import com.metier.business.Personnel;
import com.persistance.dao.DAOEmploye;
import com.persistance.dao.DAOEtape3;
import com.persistance.dao.DAOProcedure;
import com.presentation.controleurs.GestionEmployeControleur;
import com.presentation.controleurs.GestionEtapeControleur;
import com.presentation.controleurs.GestionProcedureControleur;

import java.awt.Color;

public class GestionEtapes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton validerSupp;

	
	private JPanel acenter;
	private JPanel asouth;
	private JPanel affi;
	
	private GridBagConstraints c;
	private JLabel NumProc;
	private JTextField NumProcAEdit;
	private JLabel NomEtape;
	private JTextField NomEtapeAEdit;
	private JLabel Employe;
    private JComboBox<String> EmployeListe;

	private JButton valider;
	private JButton ajouter;
	private JButton retour;


	
	private JPanel AWest;

	private JTable table;
	private JLabel aj;

	private JLabel ed;
	private JLabel sp;
	private JLabel home;
	private ImageIcon i;
	private Box box;
	
	private Box box2;
	private Box box3;
	private Box box4;
	private Box box5;
	private Box box6;
	private JPanel ss;
	private JPanel sc;
	private JPanel aa;
	private JPanel ab;
	private JLabel gestion;
	private JTable tablear;
	private JTextField rechercheEtape;
	private GestionProcedureControleur controleur=new GestionProcedureControleur();
	private GestionEtapeControleur controleur1=new GestionEtapeControleur();
	private GestionEmployeControleur controleur2=new GestionEmployeControleur();
	
	
	private Connection con;
	


	
	public GestionEtapes() {
		this.setTitle("Gestion des Etapes");
		this.setSize(800,500);
		this.i();
		this.c();
		this.s();
		this.cont();
		this.f();
		this.initialiserAjout();
		this.setSizesAjout();
		this.actionAfficher();
		this.InitialierGridBagLayoutAjout();
		this.actionAjouter();
		this.actionSupprimer();
		this.actionHome();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
	}
	
	private void i()
	{
		AWest =new JPanel();
		AWest.setLayout(new BorderLayout());
		acenter=new JPanel();
		acenter.setLayout(new BorderLayout());
		ss=new JPanel(new FlowLayout(FlowLayout.LEFT));
		sc=new JPanel(new FlowLayout(FlowLayout.LEFT));
		ab=new JPanel(new FlowLayout(FlowLayout.CENTER));
		aa=new JPanel(new GridBagLayout());

		/***********************/
		i=new ImageIcon("icons/aj.png");
		Image m=i.getImage();
		Image n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		aj =new JLabel(" Ajouter");
		box = Box.createHorizontalBox();
		JLabel image = new JLabel(i);
		box.add(image);
		box.add(aj);
		/**************************/
		
		i=new ImageIcon("icons/afficher.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		ed =new JLabel("  Afficher");
		box2 = Box.createHorizontalBox();
		JLabel image2 = new JLabel(i);
		box2.add(image2);
		box2.add(ed);
		/*****************************/
		i=new ImageIcon("icons/sup.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		sp =new JLabel("  Supprimer");
		box3 = Box.createHorizontalBox();
		JLabel image3 = new JLabel(i);
		box3.add(image3);
		box3.add(sp);
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
		i=new ImageIcon("icons/steps.png");
		m=i.getImage();
		n=m.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		gestion =new JLabel("Gestion des Etapes");
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
		sp.setFont(new Font("Cambria", Font.BOLD, 20));	
		sp.setForeground(new Color(0,64,128));
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
			c.gridy=1;
		
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
			NumProc=new JLabel("Entrer Numero Procedure :");
			NumProcAEdit=new JTextField();	
			valider=new JButton("Valider");
			valider.addActionListener(new ActionListener() {
					
			@Override
		    public void actionPerformed(ActionEvent a){
			 // TODO Auto-generated method stub
			    try {
			     	  Pattern pt = Pattern.compile("^(\\p{Digit})+$");
			    	  Matcher m = pt.matcher(NumProcAEdit.getText());
			    			
			    	   if(m.find() && (controleur.existe(Integer.parseInt((NumProcAEdit.getText())))))
			    	   {
			     	       ajout();
			     		   Grid2();
			     		   size2();	
			    	    }else {
							             
			     		    JOptionPane.showMessageDialog(null, "Numero du Procedure n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
						    reset();
							         
			    	    }
			     		    
			     	}catch(Exception d)
			        {
						  d.printStackTrace();
					}
			     		
	             }
	        }); 
			
				}
			
		private void InitialierGridBagLayoutAjout() {
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			aa.add(NumProc,c);
			c.gridx=1;
			c.gridy=0;
			aa.add(NumProcAEdit,c);
			c.gridx=0;
			c.gridy=1;
		
			asouth.add(valider);
			
			acenter.add(asouth,BorderLayout.SOUTH);
		}

		private void setSizesAjout() {
			NumProc.setFont(new Font("Cambria", Font.BOLD, 16));
			NumProc.setForeground(new Color(0,64,128));
			NumProcAEdit.setPreferredSize(new Dimension(200,30));
			NumProc.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		    valider.setFont(new Font("Cambria", Font.BOLD, 18));
			valider.setForeground(new Color(0,64,128));
			
		}

		private void vider() {
		aa.removeAll();
		asouth.removeAll();
		aa.updateUI();
		}
		
		private void ajout()

		{
			vider();
			
			
			asouth=new JPanel();
			asouth.setLayout(new FlowLayout(FlowLayout.CENTER));
			asouth.setBackground(SystemColor.inactiveCaptionBorder);
			NomEtape=new JLabel("Nom Etape :");
			NomEtapeAEdit=new JTextField();
			Employe=new JLabel("Employe :");
			EmployeListe=new JComboBox<String>(controleur2.rempcombo());
			ajouter=new JButton("Ajouter");
			retour = new JButton("Retour");
            ajouter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a){
					 // TODO Auto-generated method stub
				     Etape p = new Etape();
					 int proc = Integer.parseInt((NumProcAEdit.getText()));
					 String nom = NomEtapeAEdit.getText().toString();
					 String employe = EmployeListe.getSelectedItem().toString();
					 String numemploye = controleur2.recupererNumEmploye(employe); 
					 int numetape = p.getNumeroetape(nom, proc);
					 int ordre= controleur1.getOrdre(Integer.parseInt(NumProcAEdit.getText()));
					 try 
					 {
			    		if(!nom.equals(""))
			    		{
					       controleur1.addEtape(numetape,nom,numemploye,proc,ordre);
					       reset2();
				    	   JOptionPane.showMessageDialog(null, "Ajout Effectue");
				    			
				    	}else
				    	  {
				    		JOptionPane.showMessageDialog(null, "Ajout Non Effectue");
				    	  }
				       }catch(Exception d)
				     	   {
				    		 d.printStackTrace();
				    		}
				    		
				}	
			
			});

           retour.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				aa.removeAll();
				aa.updateUI();
	            GestionEtapes.this.acenter.removeAll();
	          	GestionEtapes.this.acenter.updateUI();
	         	GestionEtapes.this.acenter.repaint();
		        f();
		        GestionEtapes.this.initialiserAjout();
				GestionEtapes.this.InitialierGridBagLayoutAjout();
				GestionEtapes.this.setSizesAjout();	
				acenter.repaint();

				
			}
           });
        	   
      }
		
       private void reset2()
		{
			NomEtapeAEdit.setText("");
			EmployeListe.setSelectedIndex(0);
		}		
	    private void reset() {
		   
		    NumProcAEdit.setText("");
		   
	   }
	   
	   private void Grid2() {
		   c.anchor=GridBagConstraints.FIRST_LINE_START;
		   c.gridx=0;
		   c.gridy=0;
           aa.add(NomEtape,c);
		   c.gridx=1;
		   c.gridy=0;
           aa.add(NomEtapeAEdit,c);
		   c.gridx=0;
		   c.gridy=1;
		   aa.add(Employe,c);
		   c.gridx=1;
		   c.gridy=3;
		   aa.add(EmployeListe,c);
		   c.gridx=1;
		   c.gridy=4;
           asouth.add(retour);
		   acenter.add(asouth,BorderLayout.SOUTH);
		   asouth.add(ajouter);
		   acenter.add(asouth,BorderLayout.SOUTH);
		   
	   }
	   
	   private void size2()

	   {
		    NomEtape.setFont(new Font("Cambria", Font.BOLD, 16));
			NomEtape.setForeground(new Color(0,64,128));
			NomEtapeAEdit.setPreferredSize(new Dimension(200,30));
			NomEtape.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
            Employe.setFont(new Font("Cambria", Font.BOLD, 16));
			Employe.setForeground(new Color(0,64,128));
			EmployeListe.setPreferredSize(new Dimension(200,30));
			Employe.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		    ajouter.setFont(new Font("Cambria", Font.BOLD, 18));
			ajouter.setForeground(new Color(0,64,128));
            retour.setFont(new Font("Cambria", Font.BOLD, 18));
     		retour.setForeground(new Color(0,64,128));
	   }
	   
		
	   private void affectationSupprimer() {
            acenter.removeAll();
	        asouth.removeAll();
			ab.remove(box5);
			ab.updateUI();
			this.repaint();
			ab.add(box6);
			this.InitialierGridBagLayoutSupprimer();
			acenter.add(ab,BorderLayout.NORTH);
			acenter.add(aa,BorderLayout.CENTER);
			AWest.add(ss,BorderLayout.SOUTH);
			AWest.add(sc,BorderLayout.CENTER);
			getContentPane().add(AWest,BorderLayout.WEST);
			getContentPane().add(acenter,BorderLayout.CENTER);
			acenter.updateUI();
			this.repaint();

	   }
		
		private void InitialierGridBagLayoutSupprimer() {
            aa.removeAll();
			aa.updateUI();
			c.anchor=GridBagConstraints.FIRST_LINE_START;
			c.gridx=0;
			c.gridy=0;
			aa.add(NomEtape,c);
			c.gridx=1;
			c.gridy=0;
			aa.add(NomEtapeAEdit,c);
			c.gridx=0;
			c.gridy=1;
            aa.add(Employe,c);
			c.gridx=1;
			c.gridy=3;
			aa.add(EmployeListe,c);
			c.gridx=0;
			c.gridy=4;
			NomEtape.setFont(new Font("Cambria", Font.BOLD, 16));
			NomEtape.setForeground(new Color(0,64,128));
			NomEtapeAEdit.setPreferredSize(new Dimension(200,30));
			NomEtape.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
            Employe.setFont(new Font("Cambria", Font.BOLD, 16));
			Employe.setForeground(new Color(0,64,128));
			EmployeListe.setPreferredSize(new Dimension(200,30));
			Employe.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
			validerSupp.setFont(new Font("Cambria", Font.BOLD, 18));
			validerSupp.setForeground(new Color(0,64,128));
			asouth.add(validerSupp);	
			acenter.add(asouth,BorderLayout.SOUTH);
		}
		
		
		
	 void actionrechercher() {
			box6.addMouseListener(new MouseAdapter()
			{
				public void mouseClicked(MouseEvent e)
				{
					Etape e1=null;
					try {
		     			 Pattern pt = Pattern.compile("^(\\p{Digit})+$");
		    			 Matcher m = pt.matcher(rechercheEtape.getText());
				    if(m.find())
				    {
					  e1=controleur1.searchEtape(Integer.parseInt(rechercheEtape.getText()));
					  if(e1==null) 
					  {
                        JOptionPane.showMessageDialog(null, "L'etape n'existe pas", "Erreur", JOptionPane.ERROR_MESSAGE);
					  }
					 else {
                           NomEtapeAEdit.setText(e1.getNom());
						   EmployeListe.setSelectedItem((e1.getEmploye().getNom()+" "+e1.getEmploye().getPrenom()));
					}
				  
				    }
					else {

						 JOptionPane.showMessageDialog(null, "Le Numero d'etape est invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				    
				 }catch(Exception d){
					      d.printStackTrace();
					}
				}
				});
			}

		public void initialiserSupprimer()
		{
			
			i=new ImageIcon("icons/search.png");
			Image m = i.getImage();
			Image n = m.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			i=new ImageIcon(n);
			this.rechercheEtape =new JTextField("Numero de l'etape");
			this.rechercheEtape.setPreferredSize(new Dimension(200,30));
			this.box6 = Box.createHorizontalBox();
			JLabel image5 = new JLabel(i);
			this.box6.add(image5);
			this.box6.add(rechercheEtape);
            asouth=new JPanel();
			asouth.setLayout(new FlowLayout(FlowLayout.CENTER));
			asouth.setBackground(SystemColor.inactiveCaptionBorder);
			NomEtape=new JLabel("Nom Etape :");
			NomEtapeAEdit=new JTextField();
			this.actionrechercher();
            Employe=new JLabel("Employe :");
			EmployeListe=new JComboBox<String>(controleur2.rempcombo());
			validerSupp=new JButton("Supprimer");
			this.actionrechercher();
			this.actionvalidersupprime();
			
		}

		private void actionvalidersupprime() {
			validerSupp.addActionListener(new ActionListener() {
                @Override
				public void actionPerformed(ActionEvent e) {
				 try {
                       if(controleur1.supprimer(Integer.parseInt(rechercheEtape.getText())))
					   {
                         JOptionPane.showMessageDialog(null, "Etape Supprimee");
						 reset2();
		    			
	    			   }
	    			   else
	    			   {
	    				JOptionPane.showMessageDialog(null, "Etape Non Supprimee");
	    			   }
	    		}catch(Exception d)
	     	       {
	    			d.printStackTrace();
	    		   }
				}
			});
		}

	   private void actionSupprimer() {
			box3.addMouseListener(new MouseAdapter() {
				@Override
			public void mouseClicked(MouseEvent e) {
             aa.removeAll();
			 aa.updateUI();
	         acenter.removeAll();
			 acenter.updateUI();
			 ab.removeAll();
			 ab.updateUI();
			 ab.repaint();
             acenter.repaint();
             GestionEtapes.this.initialiserSupprimer();
			 GestionEtapes.this.affectationSupprimer();
             GestionEtapes.this.repaint();
				
			}
				
		});
			
	   }
	
	   private void actionAfficher() {
			box2.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
		       GestionEtapes.this.acenter.remove(aa);
			   acenter.removeAll();
			   acenter.updateUI();
			   ab.removeAll();
			   ab.updateUI();
			   ab.repaint();
			   ab.add(box5);
			   acenter.add(ab,BorderLayout.NORTH);  
			   acenter.updateUI();
               acenter.repaint();
               GestionEtapes.this.remplire();
				}
			});
			
		}

	   private void actionAjouter() {
		     box.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
                aa.removeAll();
				aa.updateUI();
				GestionEtapes.this.acenter.removeAll();
				GestionEtapes.this.acenter.updateUI();
	            GestionEtapes.this.acenter.repaint();
	            ab.removeAll();
	            ab.updateUI();
	            ab.repaint();
	            ab.add(box5);
                f();
                GestionEtapes.this.initialiserAjout();
				GestionEtapes.this.InitialierGridBagLayoutAjout();
				GestionEtapes.this.setSizesAjout();	
				acenter.repaint();
              }
			});
			
		}
	   
	   private void remplire() {
		  
		    DAOEtape3 e=new DAOEtape3();
			ArrayList<Etape> list=new ArrayList<Etape>();
			list=e.getAll();
			ModelEtape model = new ModelEtape(list);
			table = new JTable(model);
		    acenter.removeAll();
			acenter.updateUI();
			//ab.remove(box5);
			//ab.updateUI();
			this.repaint();
			aa.removeAll();
			aa.updateUI();
			this.repaint();
			//ab.add(box5);
			acenter.add(ab,BorderLayout.NORTH);
			affi=new JPanel(new GridLayout());
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
	   
	  public void actionHome() {
		  box4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Acceuil a=new Acceuil();
					a.setSize(GestionEtapes.this.getSize());
					a.setLocation(GestionEtapes.this.getLocation());
					//a.setLocationRelativeTo(null);
					GestionEtapes.this.dispose();
					a.setVisible(true);
				}
			});
	  }
	  
	public void setControleur(GestionEtapeControleur gestionEtapeControleur) {
		// TODO Auto-generated method stub
		this.controleur1=gestionEtapeControleur;
	}
	
 }		

            