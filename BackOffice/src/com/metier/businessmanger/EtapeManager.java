package com.metier.businessmanger;

import java.util.ArrayList;

import com.metier.business.DataException;
import com.metier.business.Employe;
import com.metier.business.Etape;
import com.metier.business.Procedure;
import com.persistance.dao.DAOEtape3;
import com.persistance.dao.DAOProcedure;

public class EtapeManager {
	private DAOEtape3 daoetape;
	public EtapeManager() {
		daoetape=new DAOEtape3();
	}
	
	public void insererEtape(int numero,String nom,String mat,int num_p,int ordre)
	{
		try {
			daoetape.add(numero, nom, mat, num_p, ordre);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public Etape Rechercher(int num)
	{
		return daoetape.searchById(num);
	}
	
	public ArrayList<Etape> liste()
	{
		return daoetape.getAll();
	}

	public Boolean supprimer(int id) {
			return daoetape.delete(id);
		

	}
	public int getOrdre(int numproc)
	{
		return daoetape.getOrdre(numproc);
	}
}
