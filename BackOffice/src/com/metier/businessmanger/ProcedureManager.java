package com.metier.businessmanger;

import java.util.ArrayList;

import com.metier.business.DataException;
import com.metier.business.Employe;
import com.metier.business.Procedure;
import com.persistance.dao.DAOProcedure;

public class ProcedureManager {
	private DAOProcedure daoprocedure;
	public ProcedureManager() {
		daoprocedure=new DAOProcedure();
	}
	
	public void insererProcedure(Procedure e)
	{
		try {
			daoprocedure.add(e);
		} catch (DataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public Procedure Rechercher(int num)
	{
		return daoprocedure.searchById(num);
	}
	
	public ArrayList<Procedure> listeactive()
	{
		return daoprocedure.getAll();
	}

	public void archiver(ArrayList<Procedure> list) {
		for(Procedure p:list) {
			daoprocedure.archiver(p);
		}

	}
	public Boolean existe(int id) {
		   
		   return daoprocedure.existe(id);
	   }
	
}
