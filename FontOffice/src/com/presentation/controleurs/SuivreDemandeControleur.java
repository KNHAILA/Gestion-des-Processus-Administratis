package com.presentation.controleurs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import javax.swing.JTextField;

import java.util.Map.Entry;

import com.businessmanager.DecisionManager;
import com.businessmanager.DemandeManger;
import com.businessmanager.EtapeManager;
import com.presentation.views.Acceuil;
import com.presentation.views.SuivreDemande;

public class SuivreDemandeControleur {
	private SuivreDemande suivredemande;
	
	public SuivreDemandeControleur() {
	}

	public SuivreDemande  getSuivredemande() {
		return suivredemande;
	}

	public void setSuivredemande(SuivreDemande suivredemande) {
		this.suivredemande = suivredemande;
		suivredemande.setControleur(this);
	}
	public String[] ListeDemande(String s)
	{
		return DemandeManger.getDemandeCitoyen(s).values().toArray(new String[DemandeManger.getDemandeCitoyen(s).values().size()]);
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
		return SuivreDemandeControleur.getKeyByValue(DemandeManger.getDemandeCitoyen(s), a);
	}
	
	public int OrdreDemande(int n)
	{
		return DemandeManger.OrdreDemande(n);
	}
	
	public int OrdreDecision(int n)
	{
		return DecisionManager.ordreDecision(n);
	}
	
	public String RapportDemande(int n)
	{
		return DemandeManger.RapportDemande(n);
	}
	public String etatDemande(int n)
	{
		return DemandeManger.etatDemande(n);
	}
	public String ProcedureDemande(int n)
	{
		return DemandeManger.ProcedureDemande(n);
	}
	public static void main(String[] args) {
	}

	public void acceder(JTextField cin) {
			Acceuil a =new Acceuil();
			a.setSize(suivredemande.getSize());
			a.setLocation(suivredemande.getLocation());
			a.setCin(cin);
			suivredemande.dispose();
			a.setVisible(true);
		}

	public void update(int demande, ArrayList<String> l) {
		DemandeManger.updateDemande(demande, l);	
	}
		
}
