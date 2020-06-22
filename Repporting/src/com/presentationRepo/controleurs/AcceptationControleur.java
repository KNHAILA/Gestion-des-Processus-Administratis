package com.presentationRepo.controleurs;

import java.util.ArrayList;

import com.metier.business.Procedure;
import com.metier.businessmanger.ProcedureManager;

public class AcceptationControleur {
	  ProcedureManager proceduremanager=new ProcedureManager();
      
      public ArrayList<Procedure> getAccepted()
  	{
  		return proceduremanager.getAccepted();
  	}
  	
  	public ArrayList<Procedure> getRefused()
  	{
  		return proceduremanager.getRefused();
  	}
  	public ArrayList<Procedure> getEnAttente()
  	{
  		return proceduremanager.getEnAttente();
  	}
  	
  	public ArrayList<Procedure> getAll()
  	{
  		return proceduremanager.getAll();
  	}
  	

  	public ArrayList<Procedure> getAllDemandes()
  	{
  		return proceduremanager.getAllDemandes();
  	}
  	
  	public int getNbDmd(int num) {
  		return proceduremanager.getNbDmd(num);
  	}

  	public int getTotal() {
  		return  getAccepted().size();
  	}
     
}
