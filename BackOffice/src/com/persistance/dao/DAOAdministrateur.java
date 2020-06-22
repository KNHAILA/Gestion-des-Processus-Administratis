package com.persistance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.metier.business.Administrateur;
import com.persistance.connection.ConnexionDB;

public class DAOAdministrateur implements InterfaceDAOAdministrateur {

	private Connection con;
	public DAOAdministrateur() {
		con=ConnexionDB.Connexion();
	}
	
	@Override
	public Administrateur getPassword(String Matricule) {
		try {
			String sAdministrateur="select*from Administrateur where Matricule='"+Matricule+"'";
			Statement p=con.createStatement();
			ResultSet rAdministrateur=p.executeQuery(sAdministrateur);
			if(rAdministrateur.next()) {
				return new Administrateur(
							rAdministrateur.getString(1),
							rAdministrateur.getString(6));
				}
		}
			catch(Exception e) {
			System.out.println("Erreur"+e);
		}
		return null;
	}
	public static void main(String[] args) {
		DAOAdministrateur e=new DAOAdministrateur();
		Administrateur a=e.getPassword("M1");
		System.out.print(a.getMotPasse());
	}
}
