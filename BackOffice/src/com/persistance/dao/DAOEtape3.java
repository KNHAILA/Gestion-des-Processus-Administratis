package com.persistance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.metier.business.Employe;
import com.metier.business.Etape;
import com.metier.business.Procedure;
import com.persistance.connection.ConnexionDB;



public  class DAOEtape3 implements InterfaceDAOEtapes {
	private Connection con;
	public DAOEtape3() {
		con=ConnexionDB.Connexion();
	}
	@Override
	public boolean add(int numep, String nomep, String numemp, int proc,int ord)
	{
		try {
			
			String s="insert into etape values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
			
		    ps.setInt(1,numep);
			ps.setString(2,nomep);
			ps.setInt(3,proc);
			ps.setString(4,numemp);
			ps.setInt(5,ord);
			ps.execute();
			return true;
		}
		catch(Exception d){
			d.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public Etape searchById(int id) {
		try {
			
		
			String sEtape="select*from etape where numero_e='"+id+"'";
			Statement p=con.createStatement();
			ResultSet rEtape=p.executeQuery(sEtape);
			rEtape.next();
			String smploye = "select *from employe where Matricule='"+rEtape.getString(4)+"'";
			
			p=con.createStatement();
			ResultSet rEmploye=p.executeQuery(smploye);
			rEmploye.next();
   return new Etape(rEtape.getString(2),new Employe(rEmploye.getString(1), rEmploye.getString(2), rEmploye.getString(3)));
				 
		}catch(Exception e) {
			System.out.println("Erreur"+e);;
		}
		return null;
	}
	
	@Override
	public ArrayList<Etape> getAll() {
		ArrayList<Etape> list=new ArrayList<Etape>();
		try {
			String s="select *from etape";
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(s);
			while(rs.next()) {
				String emp="select *from employe where Matricule='"+rs.getString(4)+"'";
				Statement p=con.createStatement();
				ResultSet remploye=p.executeQuery(emp);
				remploye.next();
				String pro="select *from proced where numero='"+rs.getString(3)+"'";
				 p=con.createStatement();
				ResultSet rProc=p.executeQuery(pro);
				rProc.next();
				list.add(new Etape(rs.getString(2),
						new Employe(remploye.getString(1), 
								remploye.getString(2),
								remploye.getString(3)),
						new Procedure( rProc.getString(2),
								 rProc.getString(5),
								 rProc.getBoolean(6)
								 ),
						rs.getInt(1)));
						}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 @Override
	  public boolean delete(int id) {
		int nb;
		try {
			 String s = "select *from etape where numero_e ='" + id+"'";
			 Statement p=con.createStatement();
			 ResultSet ps = p.executeQuery(s);
		     if(ps.next())
		     {
		       this.decrementeOrdre(ps.getInt(3));}
			   String sql = "delete from etape where numero_e ='" + id+"'";
			   Statement rs=con.createStatement();
			   int nb1 = rs.executeUpdate(sql);
               return (nb1 == 1 ? true : false);

		    }catch(SQLException e) {
		     	e.printStackTrace();
			    return false;
		     }
	   }	
		public String getNomEmploye(String numeroemploye) {
			try {

				String em= "Select nom, prenom from employe where Matricule='"+numeroemploye+"'";
				Statement e = con.createStatement();
				ResultSet rs=e.executeQuery(em);
				if(rs.next()) {
				  return rs.getString(1)+" "+rs.getString(2);
				}
			} catch (SQLException e1) {
			}
			return null;
		}
		
		public int getOrdre(int numproc)
		{
			
			try {
				  
				 
				  String s="Select *from proced where numero='"+numproc+"'";
				  Statement e=con.createStatement();
				  ResultSet rs=e.executeQuery(s);
				  if(rs.next())
				  {
					  
					  String sql="UPDATE proced SET nombreEtapes=nombreEtapes+1 where numero='"+numproc+"'";
					  Statement p=con.createStatement();
					  int ps=p.executeUpdate(sql);
					 
					  return rs.getInt(4);
					  
				  }
				
				     
				
			}catch (SQLException e1) {
				
			}
			return 0;
	
		}

		
		public void decrementeOrdre(int numproc)
		 {
		   try {
				  String s="Select *from proced where numero='"+numproc+"'";
				  Statement e=con.createStatement();
				  ResultSet rs=e.executeQuery(s);
				  if(rs.next())
				  {
					  
					  String sql="UPDATE proced SET nombreEtapes=nombreEtapes-1";
					  Statement p=con.createStatement();
					  p.executeUpdate(sql);
				  
				  }
				  
				  String querty="Select *from etape where numero_p='"+numproc+"'";
				  Statement qe=con.createStatement();
				  ResultSet qr=qe.executeQuery(s);
				  if(qr.next())
				  {
				    String ty="UPDATE `etape` SET `ordre`=`ordre`-1 WHERE `ordre`!=0";
				    Statement t=con.createStatement();
				    t.executeUpdate(ty);
				  } 
				  
		       } catch (SQLException e1) {
						
					}  
           }
		
		
		 
	
   }

