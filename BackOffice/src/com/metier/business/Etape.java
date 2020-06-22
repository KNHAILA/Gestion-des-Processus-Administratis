package com.metier.business;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Etape {

	/*numero_e` int(11) NOT NULL,
	  `Matricule_a` varchar(25) NOT NULL,
	  `numero_p` int(11) NOT NULL,
	  `nom` varchar(25) NOT NULL */
	private Connection con;
	
	
	
	private String nom;
	private Employe employe;
	private Procedure procedure;
	private String nomEmploye;
	private int numeroetape;
	
		private int numero_p;
		
	
		private String numEmploye;
		
	
	
	public Etape(String nom, int numeroetape, String numEmploye) {
			this.nom = nom;
			this.numeroetape = numeroetape;
			this.numEmploye = numEmploye;
		}


	@Override
	public String toString() {
		return employe.toString();
	}




	public Etape(String nom, int numeroetape, int numero_p, String numEmploye) {
		this.nom = nom;
		this.numeroetape = numeroetape;
		this.numero_p = numero_p;
		this.numEmploye = numEmploye;
	}


	public Etape(Connection con, Employe employe, Procedure procedure, String nomEmploye) {
		this.con = con;
		this.employe = employe;
		this.procedure = procedure;
		this.nomEmploye = nomEmploye;
	}


	public Etape(String nom, Employe employe, Procedure procedure, int numero_p) {
			this.nom = nom;
			this.employe = employe;
			this.procedure = procedure;
			this.numero_p = numero_p;
		}







	public int getNumeroetape(String nom,int numero_p) {
		
		return Math.abs((nom.hashCode())- numero_p);
	}

	public Etape() {
	}

public Employe getEmploye()
{
  return employe;	
}


	public int getNumero_p() {
		return numero_p;
	}



	public void setNumero_p(int numero_p) {
		this.numero_p = numero_p;
	}



	public Etape(String nom, String nomEmploye, int numero_p) {
		this.nom = nom;
		this.nomEmploye = nomEmploye;
		this.numero_p = numero_p;
	}






	









	


	public Etape(String nom, Employe employe) {
		this.nom = nom;
		this.employe = employe;
	}


	public String getMatEmp() {
		return employe.getMatricule();
	}


	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}


	public Etape(String nom, Employe employe, int numeroetape) {
		this.nom = nom;
		this.employe = employe;
		this.numeroetape = numeroetape;
	}


	



	



		
		
		
		


	

	public Etape(String nom) {
		this.nom = nom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}



	public Procedure getProcedure() {
		return procedure;
	}



	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}



	public Etape(String nom, Employe employe, Procedure procedure) {
		this.nom = nom;
		this.employe = employe;
		this.procedure = procedure;
	}
	
	
	
	



	public int Numero() {
		return Math.abs((nom.hashCode())-(procedure.getNombreEtapes()));

	}







	public Etape(Employe employe, Procedure procedure, int numero_p) {
		this.employe = employe;
		this.procedure = procedure;
		this.numero_p = numero_p;
	}


	public Etape(String nom, String nomEmploye) {
		this.nom = nom;
		this.nomEmploye = nomEmploye;
	}
	
	
}
