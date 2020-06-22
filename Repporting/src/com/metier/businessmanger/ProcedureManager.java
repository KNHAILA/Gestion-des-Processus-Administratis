package com.metier.businessmanger;

import java.util.ArrayList;
import com.metier.business.Procedure;
import com.persistence.DAORepo.DAOProcedureRepo;

public class ProcedureManager {
	private DAOProcedureRepo daoprocedure;
	public ProcedureManager() {
		daoprocedure=new DAOProcedureRepo();
	}
	
	public ArrayList<Procedure> getAccepted()
	{
		return daoprocedure.getAccepted();
	}
	
	public ArrayList<Procedure> getRefused()
	{
		return daoprocedure.getRefused();
	}
	public ArrayList<Procedure> getEnAttente()
	{
		return daoprocedure.getEnAttente();
	}
	
	public ArrayList<Procedure> getAll()
	{
		return daoprocedure.getAll();
	}
	

	public ArrayList<Procedure> getAllDemandes()
	{
		return daoprocedure.getAllDemandes();
	}
	
	public int getNbDmd(int num) {
		return daoprocedure.getNbDmd(num);
	}

	public int getTotal() {
		return  getAccepted().size();
	}
}
