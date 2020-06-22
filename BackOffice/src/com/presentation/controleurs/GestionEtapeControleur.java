package com.presentation.controleurs;


import java.util.ArrayList;

import com.metier.business.Etape;
import com.metier.business.Procedure;
import com.metier.businessmanger.EtapeManager;
import com.metier.businessmanger.ProcedureManager;

import com.presentation.views.GestionEtapes;

public class GestionEtapeControleur {
	private GestionEtapes gestionetape;
	private EtapeManager etapemanager=new EtapeManager();
	//private EtapeManager etapemanager=new EtapeManager();
	public GestionEtapes getGestionetape() {
		return gestionetape;
	}
	public void setGestionetape(GestionEtapes gestionetape) {
		this.gestionetape = gestionetape;
		gestionetape.setControleur(this);
	}
	public void addEtape(int numero,String nom,String mat,int num_p,int ordre)
	{
		etapemanager.insererEtape(numero, nom, mat, num_p, ordre);
	}
	
	public Etape searchEtape(int matricule) {
		return etapemanager.Rechercher(matricule);
	}
	
	
	public ArrayList<Etape> listeAll(){
		return etapemanager.liste();
	}
	
	
	public boolean supprimer(int id) {
		return etapemanager.supprimer(id);
	 }
	public int getOrdre(int numproc)
	{
		return etapemanager.getOrdre(numproc);
	}

}
