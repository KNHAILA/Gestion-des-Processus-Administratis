package com.metier.businessmanger;

import java.util.ArrayList;
import com.metier.business.Employe;
import com.persistence.DAORepo.DAOEmploye;


public class EmployeManager {
	private DAOEmploye daoemploye;
	public EmployeManager() {
		daoemploye=new DAOEmploye();
	}
	
	public ArrayList<Employe> getValidees()
	{
		return daoemploye.getValidees();
	}
	public ArrayList<Employe> getNombreEtapes()
	{
		return daoemploye.getNombreEtapes();
	}
	public int getNbEtapes(String mat) {
		return daoemploye.getNbEtapes(mat);
	}
	public int getTotal() {
		return daoemploye.getTotal();
	}
}

