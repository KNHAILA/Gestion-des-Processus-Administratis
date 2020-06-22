package com.persistance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.metier.business.Administrateur;
import com.metier.business.Employe;
import com.metier.business.Service;
import com.persistance.connection.ConnexionDB;

public class DAOService implements InterfaceDAOService {

	private Connection con;
	public DAOService() {
		con=ConnexionDB.Connexion();
	}
	
	@Override
	public ArrayList<Service> getAll() {
		ArrayList<Service> list=new ArrayList<Service>();
		try {
			String s="select*from Service";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				list.add(new Service(
										rs.getString(1),
										rs.getString(2)));
			}
			return list;
		} catch(Exception e) {
			System.out.println("Erreur "+e);
		}
		return null;
	}
	
	@Override
	public ArrayList<String> getAllNames() {
		ArrayList<String> list=new ArrayList<String>();
		try {
			String s="select*from Service";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				list.add(rs.getString(2));
			}
			return list;
		} catch(Exception e) {
			System.out.println("Erreur "+e);
		}
		return null;
	}
	@Override
	public Service searchById(String nom) {
		try {
			String sService="select*from Service where Nom='"+nom+"'";
			System.out.print(sService);
			Statement p=con.createStatement();
			ResultSet rService=p.executeQuery(sService);
			if(rService.next()) {
			return new Service(
					rService.getString(1),
					rService.getString(2));
			}
		}catch(Exception e) {
			System.out.println("Erreur"+e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		DAOService s=new DAOService();
		s.searchById("service2").afficher();;
	}
	

}
