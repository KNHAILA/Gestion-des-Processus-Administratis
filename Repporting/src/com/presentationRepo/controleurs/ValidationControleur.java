package com.presentationRepo.controleurs;

import java.util.ArrayList;

import com.metier.business.Employe;
import com.metier.business.Procedure;
import com.metier.businessmanger.EmployeManager;
;


public class ValidationControleur {
       EmployeManager employemanager=new EmployeManager();
       
       public ArrayList<Employe> getValidees()
   	{
   		return employemanager.getValidees();
   	}
   	public ArrayList<Employe> getNombreEtapes()
   	{
   		return employemanager.getNombreEtapes();
   	}
   	public int getNbEtapes(String mat) {
   		return employemanager.getNbEtapes(mat);
   	}
   	public int getTotal() {
   		return employemanager.getTotal();
   	}
      
}
