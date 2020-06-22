package com.presentation.controleurs;


import javax.swing.JTextField;

import com.business.Demande;
import com.businessmanager.DemandeManger;
import com.businessmanager.ProcedureManager;
import com.presentation.views.Acceuil;
import com.presentation.views.depotDemande;

public class DepotDemandeControleur {
	private depotDemande depotdemande;
	
	public DepotDemandeControleur() {
	}

	public depotDemande getDepotdemande() {
		return depotdemande;
	}

	public void setDepotdemande(depotDemande depotdemande) {
		this.depotdemande = depotdemande;
		depotdemande.setControleur(this);
	}
	
	public String[] getNomProcedures()
	{
		return ProcedureManager.LesNomsDesProcedures().toArray(new String[ProcedureManager.LesNomsDesProcedures().size()]);
	}
	
	public int getId(String name)
	{
		return ProcedureManager.IdOfName1(name);			
	}
	
	public String getFile(String name)
	{
		return ProcedureManager.FileOfName1(name);			
	}
	
	public void acceder(JTextField c)
	{
		Acceuil a =new Acceuil();
		a.setSize(depotdemande.getSize());
		a.setLocation(depotdemande.getLocation());
		a.setCin(c);
		depotdemande.dispose();
		a.setVisible(true);
	}
	
	public boolean setDemande(Demande d)
	{
		return DemandeManger.setDemande(d);
	}
}
