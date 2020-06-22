package com.persistance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.metier.business.*;
import com.persistance.connection.ConnexionDB;

public class DAOProcedure implements InterfaceDAOProcedure {
	private Connection con;
	public DAOProcedure() {
		con=ConnexionDB.Connexion();
	}
	@Override
	public boolean add(Procedure p)throws DataException{
		try {
			String s="insert into proced values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1,p.genererNumero());
			ps.setString(2,p.getNom());
			ps.setString(3,p.getChef().getMatricule());
			ps.setInt(4,0);
			ps.setString(5,p.getCheminListe());
			ps.setBoolean(6, false);
			return (ps.execute());
		}
		catch(Exception d){
			d.printStackTrace();
		}
		return false;
	}
		
	@Override
	public Procedure searchById(int id) {
		try {
			String sProcedure="select*from proced where numero='"+id+"'";
			Statement p=con.createStatement();
			ResultSet rProcedure=p.executeQuery(sProcedure);
			rProcedure.next();
			String sEmploye="select*from Employe where Matricule='"+rProcedure.getString(3)+"'";
			 p=con.createStatement();
			ResultSet rEmploye=p.executeQuery(sEmploye);
			rEmploye.next();
			String sAdministrateur="select*from Administrateur where Matricule='"+rEmploye.getString(7)+"'";
			p=con.createStatement();
			ResultSet rAdministrateur=p.executeQuery(sAdministrateur);
			rAdministrateur.next();
			String sService="select*from Service where Id_service='"+rEmploye.getString(8)+"'";
			p=con.createStatement();
			ResultSet rService=p.executeQuery(sService);
			rService.next();
			return new Procedure(
					             rProcedure.getString("nom"),
					             new Employe(
					 					rEmploye.getString(1),
					 					rEmploye.getString(2),
					 					rEmploye.getString(3),
					 					rEmploye.getString(4),
					 					rEmploye.getString(5),
					 					rEmploye.getString(6),new Administrateur(
					 							rAdministrateur.getString(1),
					 							rAdministrateur.getString(2),
					 							rAdministrateur.getString(3),
					 							rAdministrateur.getString(4),
					 							rAdministrateur.getString(5),
					 							rAdministrateur.getString(6)),new Service(
					 									rService.getString(1),
					 									rService.getString(2)),
					 					rEmploye.getBoolean(9)),
				                 rProcedure.getInt("nombreEtapes"),
				                 rProcedure.getString("chemin"),
				                 rProcedure.getBoolean("archivee"));
		}catch(Exception e) {
			System.out.println("Erreur"+e);
		}
		return null;
	}
	
	@Override
	public ArrayList<Procedure> getAll() {
		ArrayList<Procedure> list=new ArrayList<Procedure>();
		try {
			String s="select*from proced where archivee=false";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				String sEmploye="select*from Employe where  Matricule='"+rs.getString("Matricule")+"'";
				Statement p1=con.createStatement();
				ResultSet rEmploye=p1.executeQuery(sEmploye);
				rEmploye.next();
				String sAdministrateur="select*from Administrateur where Matricule='"+rEmploye.getString("Matricule_a")+"'";
				p1=con.createStatement();
				ResultSet rAdministrateur=p1.executeQuery(sAdministrateur);
				rAdministrateur.next();
				String sService="select*from Service where Id_service='"+rEmploye.getString("id_service")+"'";
				p1=con.createStatement();
				ResultSet rService=p1.executeQuery(sService);
				rService.next();
				
				list.add(new Procedure(rs.getString("nom"),
						new Employe(
			 					rEmploye.getString(1),
			 					rEmploye.getString(2),
			 					rEmploye.getString(3),
			 					rEmploye.getString(4),
			 					rEmploye.getString(5),
			 					rEmploye.getString(6),new Administrateur(
			 							rAdministrateur.getString(1),
			 							rAdministrateur.getString(2),
			 							rAdministrateur.getString(3),
			 							rAdministrateur.getString(4),
			 							rAdministrateur.getString(5),
			 							rAdministrateur.getString(6)),new Service(
			 									rService.getString(1),
			 									rService.getString(2)),
			 					rEmploye.getBoolean(9)),
						               rs.getInt(4),
						               rs.getString("chemin"),
						               rs.getBoolean("archivee")
						               )
						);
				}
			
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean archiver(Procedure p) {
		try {
			
			String s="update proced set archivee=? where numero=?";
			PreparedStatement ps=con.prepareStatement(s);
			
			ps.setBoolean(1, p.getAchivee());
			ps.setInt(2,p.genererNumero());
			return ps.execute();
			}catch(Exception e) {
				System.out.println("Erreur "+e);
			}
		return false;
	}
	public Boolean existe(int id) {
		try {
			String sProcedure="select*from proced where numero='"+id+"'";
			Statement p=con.createStatement();
			ResultSet rProcedure=p.executeQuery(sProcedure);
			rProcedure.next();
			String sChef="select*from Employe where matricule='"+rProcedure.getString("matricule")+"'";
			Statement p1=con.createStatement();
			ResultSet rChef=p1.executeQuery(sChef);
			rChef.next();
			return true;
		}catch(Exception e) {
			System.out.println("Erreur"+e);
		}
		return false;
	}
	public static void main(String[] ags) {
		DAOProcedure d=new DAOProcedure();
		Service s=new Service("s1","Service de maintenace");
		Administrateur a=new Administrateur("M1", "ghaffour","mina","10/11/2019" , "10/11/2019", "code", s);
		Employe m=new Employe("M2", "NHAILA", "kaoutar", "10/11/2019", "10/11/2019", "test1234",a,s,true);

		Procedure p=new Procedure("ProcProc",m,4,"gfgfg",true);
		
	    System.out.print( d.archiver(p));
	}}


