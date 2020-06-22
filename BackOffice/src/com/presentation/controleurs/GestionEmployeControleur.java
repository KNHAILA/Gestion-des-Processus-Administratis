package com.presentation.controleurs;

import java.util.ArrayList;
import java.util.Iterator;

import com.metier.business.Employe;
import com.metier.business.Service;
import com.metier.businessmanger.EmployeManager;
import com.metier.businessmanger.ServiceManager;
import com.presentation.views.Acceuil;
import com.presentation.views.GestionEmploye2;

public class GestionEmployeControleur {
	
	private GestionEmploye2 gestionpersonnel;
	private EmployeManager employemanger=new EmployeManager();
	private ServiceManager servicemanager=new ServiceManager();
	public GestionEmploye2 getGestionpersonnel() {
		return gestionpersonnel;
	}

	public void setGestionpersonnel(GestionEmploye2 gestionpersonnel) {
		this.gestionpersonnel = gestionpersonnel;
		gestionpersonnel.setControleur(this);
	}
	
	public void addEmploye()
	{
		employemanger.insererEmploye(gestionpersonnel.getEmploye());
	}
	
	public Employe searchEmploye(String matricule) {
		return employemanger.Rechercher(matricule);
	}
	
	public void updateEmploye() {
		employemanger.Modifier(gestionpersonnel.getEmploye());
	}
	public Service setService(String nom) {
		return servicemanager.selectByName(nom);
	}
	
	public ArrayList<Employe> listeActibve(){
		return employemanger.listeactive();
	}
	public ArrayList<Employe>listeChef()
	{
		return employemanger.listeChef();
	}
	
	public ArrayList<Employe> Listearchives(ArrayList<Employe> list)
	{
		ArrayList<Employe> listearchive=new ArrayList<Employe>();
		Iterator<Employe> it=list.iterator();
		Employe e;
		while(it.hasNext())
		{
			e=it.next();
			if(e.getArchive())
			listearchive.add(e);
			
		}
		return listearchive;
	}
	
	public void archiver(ArrayList<Employe> list) {
		ArrayList<Employe> listearchive=new ArrayList<Employe>();
		listearchive=Listearchives(list);
		Iterator<Employe> it=list.iterator();
		Employe e;
		while(it.hasNext())
		{
			e=it.next();
			employemanger.Archiver(e);
			
		}
	}
	 public String[] rempcombo() {
		 return employemanger.rempcombo();
	 }
	 public String[] rempcombo1() {
		 return employemanger.rempcombo1();
	 }
	 public String recupererNumEmploye(String name) {
	 return employemanger.recupererNumEmploye(name);
	 }
	public void home() {
		Acceuil a=new Acceuil();
		a.setSize(gestionpersonnel.getSize());
		a.setLocation(gestionpersonnel.getLocation());
		//a.setLocationRelativeTo(null);
		gestionpersonnel.dispose();
		a.setVisible(true);
	}
	
	
}
