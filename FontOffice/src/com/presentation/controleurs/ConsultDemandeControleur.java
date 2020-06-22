package com.presentation.controleurs;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

import com.businessmanager.DemandeManger;
import com.businessmanager.ProcedureManager;
import com.persistance.dao.DAODemande;
import com.presentation.views.AcceuilChefDeService;
import com.presentation.views.ConsultDemande;

public class ConsultDemandeControleur {
	private ConsultDemande consultdemande;
	
	public ConsultDemandeControleur() {
	}

	public ConsultDemande getConsultdemande() {
		return consultdemande;
	}

	public void setConsultdemande(ConsultDemande consultdemande) {
		this.consultdemande = consultdemande;
		consultdemande.setControleur(this);
	}
	public String[] ListeDemande()
	{
		return DAODemande.DemandesNonTraités().values().toArray(new String[DAODemande.DemandesNonTraités().values().size()]);
	}

	public static <T, E> T getKeyByValue(HashMap<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	public Integer getIdDemande(String a)
	{
		return ConsultDemandeControleur.getKeyByValue(DAODemande.DemandesNonTraités(), a);
	}
	
	public String[] getDemandes(int n)
	{
		return DemandeManger.getDemandes(n);
	}
	
	public String getFile(int n)
	{
		System.out.println(DemandeManger.getNumeroProcedure(n));
		return ProcedureManager.FileOfName1(DemandeManger.getNumeroProcedure(n));
	}
	
	public void accepter(int n)
	{
		DemandeManger.accepter(n);
	}
	
	public void refuser(int n)
	{
		DemandeManger.refuser(n);
	}
	public void acceder()
	{
		AcceuilChefDeService a =new AcceuilChefDeService();
		a.setSize(consultdemande.getSize());
		a.setLocation(consultdemande.getLocation());
		//a.setCin(b);
		consultdemande.dispose();
		a.setVisible(true);
	}
	public static void main(String[] args) {
		
		ConsultDemandeControleur s =new ConsultDemandeControleur();
		s.getFile(1);
	}
}