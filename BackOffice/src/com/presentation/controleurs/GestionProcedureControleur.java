package com.presentation.controleurs;

import java.util.ArrayList;
import java.util.Iterator;

import com.metier.business.Employe;
import com.metier.business.Procedure;
import com.metier.business.Service;
import com.metier.businessmanger.EtapeManager;
import com.metier.businessmanger.ProcedureManager;
import com.presentation.views.Acceuil;
import com.presentation.views.GestionEtapes;
import com.presentation.views.GestionProcedure1;

public class GestionProcedureControleur {

		private GestionProcedure1 gestionprocedure;
		private ProcedureManager proceduremanager=new ProcedureManager();
		public GestionProcedure1 getGestionprocedure() {
			return gestionprocedure;
		}
		public void setGestionetape(GestionProcedure1 gestionetape) {
			this.gestionprocedure = gestionetape;
			gestionetape.setControleur(this);
		}
		public void addProcedure(Procedure  p)
		{
			proceduremanager.insererProcedure(p);
		}
		
		public Procedure searchProcedure(int matricule) {
			return proceduremanager.Rechercher(matricule);
		}
		
		
		public ArrayList<Procedure> listeActive(){
			return proceduremanager.listeactive();
		}
		
		
		
		public void archiver(ArrayList<Procedure> list) {
			proceduremanager.archiver(list);
	
		}
		public Boolean existe(int id) {
			   
			   return proceduremanager.existe(id);
		}
}
