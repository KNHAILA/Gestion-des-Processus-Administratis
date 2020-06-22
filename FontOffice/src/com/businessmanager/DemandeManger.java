package com.businessmanager;

import java.util.ArrayList;
import java.util.HashMap;

import com.business.Demande;
import com.persistance.dao.DAODemande;

public class DemandeManger {
	private static DAODemande daodemande=new DAODemande();
	
	public static boolean setDemande(Demande d)
	{
		return daodemande.setDemande(d);
	}
	
	public static String[] getDemandes(int n)
	{
		return daodemande.getDocuments(n);
	}
	public static int getNumeroProcedure(int n)
	{
		return daodemande.getProcedure(n);
	}
	public static void accepter(int n)
	{
		daodemande.accepter(n);
	}
	public static void refuser(int n)
	{
		daodemande.refuser(n);
	}
	public static int OrdreDemande(int n)
	{
		return DAODemande.ordreDemande(n);
	}
	
	public static String etatDemande(int n)
	{
		return DAODemande.etatDemande(n);
	}
	
	public  static HashMap<Integer, String> getDemandeCitoyen(String s)
	{
		return DAODemande.DemandesDunCitoyen(s);
	}
	public static String RapportDemande(int n)
	{
		return DAODemande.RapportDemande(n);
	}
	public static String ProcedureDemande(int n)
	{
		return ProcedureManager.NameOfId(daodemande.getProcedure(n));
	}
	public static void updateDemande(int n, ArrayList<String> l)
	{
		DAODemande.updateDemande(n,l);
	}
}
