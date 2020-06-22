package com.metier.businessmanger;

import java.sql.Date;
import java.util.ArrayList;

import com.metier.business.Employe;
import com.persistance.dao.DAOEmploye;
import com.persistance.dao.DAOService;

public class EmployeManager {
	private DAOEmploye daoemploye;
	public EmployeManager() {
		daoemploye=new DAOEmploye();
	}
	
	public void insererEmploye(Employe e)
	{
		daoemploye.add(e);
	}
	
	public Employe Rechercher(String matricule)
	{
		return daoemploye.searchById(matricule);
	}
	public void Modifier(Employe e) {
		daoemploye.update(e);
	}
	public ArrayList<Employe> listeactive()
	{
		return daoemploye.getAllActive();
	}
	public ArrayList<Employe> listeChef() {
		return daoemploye.getAllChef();
	}
	public boolean Archiver(Employe i)
	{
		return daoemploye.updateArchive(i);
	}
	 public String[] rempcombo() {
		 return daoemploye.rempcombo();
	 }
	 public String[] rempcombo1() {
		 return daoemploye.rempcombo1();
	 }
	 public String recupererNumEmploye(String name) {
	 return daoemploye.recupererNumEmploye(name);
	 }
}
