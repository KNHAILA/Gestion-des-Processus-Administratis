package com.persistance.dao;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.metier.business.Administrateur;
import com.metier.business.Employe;
import com.metier.business.Service;
import com.persistance.connection.ConnexionDB;

public  class DAOEmploye implements InterfaceDAOEmploye{
	private Connection con;
	public DAOEmploye() {
		con=ConnexionDB.Connexion();
	}
	
	@Override
	public boolean add(Employe i) {
		try {
			String s="insert into Employe values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1,i.generer());
			ps.setString(2,i.getNom());
			ps.setString(3,i.getPrenom());
			ps.setString(4, i.getDateNaissance());
		    ps.setString(5,i.getDateEmbauche());
		
	        ps.setString(6, i.generer());
			ps.setString(7,"M1");
			ps.setString(8,i.getService().getId_service()); 
			ps.setBoolean(9, i.getChef());
			ps.setBoolean(10,true);
			return (ps.execute());
		}catch(Exception e)
		{
			System.out.println("Erreur"+e);
		}
		return false;
	}

	@Override
	public Employe searchById(String id) {
		try {
			String sEmploye="select*from Employe where Matricule='"+id+"'";
			Statement p=con.createStatement();
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
			return new Employe(
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
					rEmploye.getBoolean(9));
		}catch(Exception e) {
			System.out.println("Erreur"+e);
		}
		return null;
	}

	@Override
	public ArrayList<Employe> getAll() {
		ArrayList<Employe> list=new ArrayList<Employe>();
		try {
			String s="select*from Employe";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				String sAdministrateur="select*from Administrateur where Matricule='"+rs.getString(7)+"'";
				ps=con.createStatement();
				ResultSet rAdministrateur=ps.executeQuery(sAdministrateur);
				rAdministrateur.next();
				String sService="select*from Service where Id_service='"+rs.getString(8)+"'";
				ps=con.createStatement();
				ResultSet rService=ps.executeQuery(sService);
				rService.next();
				list.add(new Employe(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),new Administrateur(
								rAdministrateur.getString(1),
								rAdministrateur.getString(2),
								rAdministrateur.getString(3),
								rAdministrateur.getString(4),
								rAdministrateur.getString(5),
								rAdministrateur.getString(6)),new Service(
										rService.getString(1),
										rService.getString(2))
						, rs.getBoolean(9)));
			}
			return list;
		} catch(Exception e) {
			System.out.println("Erreur "+e);
		}
		return null;
	}
	@Override
	public ArrayList<Employe> getAllActive() {
		ArrayList<Employe> list=new ArrayList<Employe>();
		try {
			String s="select*from Employe where Etat=true";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				String sAdministrateur="select*from Administrateur where Matricule='"+rs.getString(7)+"'";
				ps=con.createStatement();
				ResultSet rAdministrateur=ps.executeQuery(sAdministrateur);
				rAdministrateur.next();
				String sService="select*from Service where Id_service='"+rs.getString(8)+"'";
				ps=con.createStatement();
				ResultSet rService=ps.executeQuery(sService);
				rService.next();
				list.add(new Employe(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),new Administrateur(
								rAdministrateur.getString(1),
								rAdministrateur.getString(2),
								rAdministrateur.getString(3),
								rAdministrateur.getString(4),
								rAdministrateur.getString(5),
								rAdministrateur.getString(6)),new Service(
										rService.getString(1),
										rService.getString(2)),
						rs.getBoolean(9),
						rs.getBoolean(10)));
			}
			return list;
		} catch(Exception e) {
			System.out.println("Erreur "+e);
		}
		return null;
	}
	
	@Override
	public Boolean update(Employe i) {
		try {
		String s="update Employe set nom=?, prenom=?, date_naissance=?, date_embauche=?, Matricule_a=?, id_service=?, chef=?  where Matricule=?";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setString(1,i.getNom());
		ps.setString(2,i.getPrenom());
		ps.setString(3,i.getDateNaissance());
		ps.setString(4,i.getDateEmbauche());
		ps.setString(5,"M1"); 
		ps.setString(6,i.getService().getId_service());
		ps.setBoolean(7,i.getChef());
		ps.setString(8,i.getMatricule());
		return ps.execute();
		}catch(Exception e) {
			System.out.println("Erreur "+e);
		}
		return false;
	}

	@Override
	public Boolean updateArchive(Employe i) {
		try {
		String s="update Employe set Etat=? where Matricule='"+i.getMatricule()+"'";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setBoolean(1, i.getArchive());
		return ps.execute();
		}catch(Exception e) {
			e.printStackTrace();;
		}
		return false;
	}

	
	@Override
	public Boolean isPassWordCorrect(String matricule, String passWord) {
		try {
			String s="select Mot_passe from employe where Matricule='"+matricule+"'";
			Statement p=con.createStatement();
			ResultSet r=p.executeQuery(s);
			if(r.next()) {
				if(r.getString(1).equals(passWord))
					return true;
			}
		}catch(Exception e) {
			
		}
		return false;
	}
	public ArrayList<Employe> getAllChef() {
		ArrayList<Employe> list=new ArrayList<Employe>();
		try {
			String s="select*from employe where Chef=true";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				String sAdministrateur="select*from administrateur where Matricule='"+rs.getString(7)+"'";
				ps=con.createStatement();
				ResultSet rAdministrateur=ps.executeQuery(sAdministrateur);
				rAdministrateur.next();
				String sService="select*from service where Id_service='"+rs.getString(8)+"'";
				ps=con.createStatement();
				ResultSet rService=ps.executeQuery(sService);
				rService.next();
				list.add(new Employe(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						new Administrateur(
								rAdministrateur.getString(1),
								rAdministrateur.getString(2),
								rAdministrateur.getString(3),
								rAdministrateur.getString(4),
								rAdministrateur.getString(5),
								rAdministrateur.getString(6)),new Service(
										rService.getString(1),
										rService.getString(2)),
						rs.getBoolean(9)));
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	 public String[] rempcombo() 
	   {
		int i=0;
		 String noms[]=new String[getAll().size()];
		try {
			String s = "Select * from Employe where etat=true and chef = false";
		   Statement ps;
			  ps = con.createStatement();
		
			ResultSet	rs = ps.executeQuery(s);
			
				while(rs.next()){
					 noms[i] = rs.getString("nom")+" " +rs.getString("prenom");
					i++;
				}
				return noms;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return null;
	   }
	 public String[] rempcombo1() 
	   {
		int i=0;
		 String noms[]=new String[getAll().size()];
		try {
			String s = "Select * from Employe where chef=true and etat = true";
		   Statement ps;
			  ps = con.createStatement();
		
			ResultSet	rs = ps.executeQuery(s);
			
				while(rs.next()){
					 noms[i] = rs.getString("nom")+" " +rs.getString("prenom");
					i++;
				}
				return noms;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return null;
	   }
	 public String recupererNumEmploye(String name)
		{
			
			String[] sousChaines =name.split(" ");

			try {
				String em= "Select matricule from employe where nom='"+sousChaines[0]+"'";
				Statement e = con.createStatement();
				ResultSet rs=e.executeQuery(em);
				if(rs.next()) {
				String matricule= rs.getString(1);
				return matricule;}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}
	
	public static void main(String[] args) {
		DAOEmploye e=new DAOEmploye();
		Service s=new Service("s1","Service de maintenace");
		Administrateur a=new Administrateur("M1", "hhhh","hjhh","2019-07-05" , "2019-07-05", "ggggggg", s);
		Employe m=new Employe("M2","GHAFFOUR","hjhh","2019-07-05" , "2019-07-05",s,false,false);
		//System.out.print(e.recupererNumEmploye("Mina GH"));
		//m.afficher();
		//Employe m;
		//m=e.searchById("M2");
		//if(m!=null)
		//	System.out.println(m.toString());
		/*ArrayList<Employe> list=new ArrayList<Employe>();
		list=e.getAllActive();
		Iterator<Employe> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		}*/
		System.out.print(e.updateArchive(m));
		//System.out.println(e.isPassWordCorrect("M2", "test1234"));*/
	}
}
