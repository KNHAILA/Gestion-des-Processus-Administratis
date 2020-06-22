package com.presentation.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import com.presentation.controleurs.AuthentificationEmployeControleur;

public class AuthentificationEmploye extends JFrame{

	private AuthentificationEmployeControleur controleur;
	private static final long serialVersionUID = 1L;
	private JLabel connexion;
	private JLabel nomUtilisateur;
	private JTextField nomUtilisateurEdit;
	private JLabel motPasse;
	private JPasswordField motPasseEdit;
	private JButton connecter;
	private JPanel panel_nouth;
	private JPanel panel_center;
	private JPanel panel_south;
	private GridBagConstraints c;
	private Box box;
	private Box box1;
	
	public AuthentificationEmploye() {
		this.setTitle("Application de Gestion Des Processus Administratives");
		this.setSize(800,500);
		controleur = new AuthentificationEmployeControleur();
		controleur.setAuthentification(this);
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
		connecter.addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "deprecation", "static-access" })
			@Override
			public void actionPerformed(ActionEvent e) {
				if(traitementestValise(nomUtilisateurEdit.getText(), motPasseEdit.getText()))
				{
					if(controleur.testPassword(nomUtilisateurEdit.getText(),motPasseEdit.getText()))
					{
						controleur.acceder(nomUtilisateurEdit.getText());
					}
					else
					{
						JOptionPane jop1 = new JOptionPane();
						jop1.showMessageDialog(null, "Le mot de passe ou le nom d'utilisateur est incorrecte", "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
	}

	private void setColors()
	{
		panel_nouth.setBackground(SystemColor.inactiveCaption);
		panel_south.setBackground(SystemColor.inactiveCaptionBorder);
		connecter.setBackground(new Color(0,98,145));
		connecter.setForeground(Color.WHITE);

	}
	
	private void setSizes()
	{
		connexion.setFont(new Font("Cambria", Font.BOLD, 22));
		nomUtilisateur.setFont(new Font("Cambria", Font.BOLD, 16));
		motPasse.setFont(new Font("Cambria", Font.BOLD, 16));
		panel_nouth.setPreferredSize(new Dimension(600,40));
		panel_south.setPreferredSize(new Dimension(600,50));
		nomUtilisateurEdit.setPreferredSize(new Dimension(190,25));
		motPasseEdit.setPreferredSize(new Dimension(190,25));
		box.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 20));
		connecter.setFont(new Font("Cambria", Font.BOLD, 18));
		
		
	}
	
	private void affectation()
	{
		panel_nouth.add(connexion);
		panel_south.add(connecter);
		getContentPane().add(panel_nouth, BorderLayout.NORTH);
		getContentPane().add(panel_south, BorderLayout.SOUTH);
		getContentPane().add(panel_center,BorderLayout.CENTER);
	}
	
	private void initialiser() {
		connexion=new JLabel("Connexion :");
		nomUtilisateur=new JLabel(" Nom de l'utilisateur :");
		nomUtilisateurEdit=new JTextField();
		motPasse=new JLabel("  Mot de passe :");
		motPasseEdit=new JPasswordField();
		panel_nouth = new JPanel();
		panel_nouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_south = new JPanel();
		panel_center=new JPanel();
		panel_center.setLayout(new GridBagLayout());
		c=new GridBagConstraints();
		connecter=new JButton("Se connecter");
		ImageIcon i=new ImageIcon("icons/user3.png");
		Image m=i.getImage();
		Image n=m.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		box = Box.createHorizontalBox();
		JLabel image = new JLabel(i);
		box.add(image);
		box.add(nomUtilisateur);
		i=new ImageIcon("icons/key2.png");
		m=i.getImage();
		n=m.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		i=new ImageIcon(n);
		box1 = Box.createHorizontalBox();
		JLabel image1 = new JLabel(i);
		box1.add(image1);
		box1.add(motPasse);
	}
	
	
	private void InitialierGridBagLayout()
	{
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.gridx=0;
		c.gridy=0;
		panel_center.add(box,c);
		c.gridx=1;
		c.gridy=0;
		panel_center.add(nomUtilisateurEdit,c);
		c.gridx=0;
		c.gridy=1;
		panel_center.add(box1,c);
		c.gridx=1;
		c.gridy=1;
		panel_center.add(motPasseEdit,c);
	}
	public AuthentificationEmployeControleur getControleur() {
		return controleur;
	}

	public void setControleur(AuthentificationEmployeControleur controleur) {
		this.controleur = controleur;
	}

	public static void main(String[] args) {
		AuthentificationEmploye a=new AuthentificationEmploye();
		a.setVisible(true);

	}
	public boolean traitementestValise(String a,String b)
	{
		boolean f= true;
		Border redBorder=new LineBorder(Color.RED, 2, true);
		Border blackBorder=new JTextField().getBorder();
		if(!a.matches("^[a-zA-Z0-9]+$"))
		{
			nomUtilisateurEdit.setBorder(redBorder);
			nomUtilisateurEdit.setText("not valid");
			nomUtilisateurEdit.setForeground(Color.RED);
			f=false;
		}
		else if(a.matches("^[a-zA-Z0-9]+$"))
		{
			nomUtilisateurEdit.setBorder(blackBorder);
			nomUtilisateurEdit.setForeground(Color.black);
		}
		
		if(b.equals(""))
		{
			motPasseEdit.setBorder(redBorder);
			//motPasseEdit.setText("");
			motPasseEdit.setForeground(Color.RED);
			f=false;
		}
		else if(!b.equals(""))
		{
			motPasseEdit.setBorder(blackBorder);
			motPasseEdit.setForeground(Color.black);
		}
		
		return f;
	}
}
