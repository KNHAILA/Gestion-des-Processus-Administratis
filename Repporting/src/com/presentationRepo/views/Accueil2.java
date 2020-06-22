package com.presentationRepo.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.presentationRepo.controleurs.Accueil2Controleur;

public class Accueil2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Accueil2Controleur controleur;
	private JPanel panel_center;
	private JLabel consult;
	private JLabel avancement;
	private JLabel archive;
	private JLabel consult1;
	private JLabel avancement1;
	private JPanel left;
	private JLabel archive1;
	private JPanel panel_south;
	private JLabel consulticon;
	private JLabel avancementicon;
	private JLabel archiveicon;
	private JLabel caret;
	private Box box;
	private Box box1;
	private Box box2;
	
	public Accueil2() {
		this.setTitle("Page d'acceuil");
		this.setSize(800,500);
		this.initialiser();
		this.setColors();
		this.setSizes();
		
		//controleur.setAccueil1(this);
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
				controleur.acceder2();
			}
		});
		}

	private void actionconsult() {
		box.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.acceder1();
			}
		});
		
	}

	private void setColors()
	{   panel_south.setBackground(SystemColor.inactiveCaptionBorder);
		consult.setForeground(new Color(0,128,192));
		consult1.setForeground(new Color(0,128,192));
		avancement.setForeground(new Color(0,128,192));
		avancement1.setForeground(new Color(0,128,192));
		
	}
	
	private void setSizes()
	{   panel_south.setPreferredSize(new Dimension(600,50));
		consult.setFont(new Font("Cambria", Font.BOLD, 20));
		consult1.setFont(new Font("Cambria", Font.BOLD, 20));
		consulticon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,70));
		consult.setBorder(BorderFactory.createEmptyBorder(0, 20, 0,70));
		avancement.setFont(new Font("Cambria", Font.BOLD, 20));
		avancement1.setFont(new Font("Cambria", Font.BOLD, 20));
	
		avancementicon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));
		avancement.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 70));
		avancement1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 70));
		box.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 40));
		box1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 40));
	}
	
	private void affectation()
	{   left.add(caret);
        panel_south.add(left,BorderLayout.WEST);
		panel_center.add(box);
		panel_center.add(box1);
		getContentPane().add(panel_center,BorderLayout.CENTER);
		getContentPane().add(panel_south, BorderLayout.SOUTH);
	}
	
	private void initialiser() {
		panel_south = new JPanel();
		panel_south.setLayout(new BorderLayout());
		left=new JPanel();
		left.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		ImageIcon i = new ImageIcon("icons/one1.png");
		Image m = i.getImage();
		Image n = m.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		consult=new JLabel("Par");
		consult1=new JLabel("Employé");
		controleur=new Accueil2Controleur();
		controleur.setAccueil2(this);
		box = Box.createVerticalBox();
		consulticon = new JLabel(i);
		box.add(consulticon);
		box.add(consult);
		box.add(consult1);
		/*******************/
		i = new ImageIcon("icons/many1.png");
		m = i.getImage();
		n = m.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		avancement=new JLabel("Par Plusieurs");
		avancement1=new JLabel("    Employés");
		
		box1 = Box.createVerticalBox();
		avancementicon = new JLabel(i);
		box1.add(avancementicon);
		box1.add(avancement);
		box1.add(avancement1);
		/****************************************/
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
				Accueil2.this.controleur.acceder3();
			}
		});
		}
	
	public Accueil2Controleur getControleur() {
		return controleur;
	}

	public void setControleur(Accueil2Controleur controleur) {
		this.controleur = controleur;
	}

	public static void main(String[] args) {
		Accueil2 a=new Accueil2();
		a.setVisible(true);

	}

}

