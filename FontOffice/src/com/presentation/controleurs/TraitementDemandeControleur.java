package com.presentation.controleurs;

import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;
import com.businessmanager.DecisionManager;
import com.businessmanager.DemandeManger;
import com.businessmanager.EtapeManager;
import com.businessmanager.ProcedureManager;
import com.business.Decision;
import com.presentation.views.TraitementDemande;

public class TraitementDemandeControleur {
	private TraitementDemande traitementdemande;
	
	public TraitementDemandeControleur() {
	}

	public TraitementDemande getConsultdemande() {
		return traitementdemande;
	}

	public void setConsultdemande(TraitementDemande traitementdemande) {
		this.traitementdemande = traitementdemande;
		traitementdemande.setControleur(this);
	}
	public String[] ListeDemande(String s)
	{
		return EtapeManager.DemandesDeEmploye(s).values().toArray(new String[EtapeManager.DemandesDeEmploye(s).values().size()]);
	}

	public static <T, E> T getKeyByValue(HashMap<T, E> map, E value) {
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	public Integer getIdDemande(String a,String s)
	{
		return TraitementDemandeControleur.getKeyByValue(EtapeManager.DemandesDeEmploye(s), a);
	}
	
	public String[] getDemandes(int n)
	{
		return DemandeManger.getDemandes(n);
	}
	
	public String getFile(int n)
	{
		return ProcedureManager.FileOfName1(DemandeManger.getNumeroProcedure(n));
	}
	
	public boolean Decision(Decision d)
	{
		return (DecisionManager.lastDecision(d) && DecisionManager.ajoutDecision(d));
	}
	public static void main(String[] args) {
	}
}
