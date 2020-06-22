package com.business;

public class Decision {
	private String cheminRapport;
	private int NumeroDemande;
	private String matricule;
	private String decision;
	private String nomProcedure;
	private int NumeroEtape;
	
	public Decision(String cheminRapport, int numeroDemande, String matricule, String decision) {
		this.cheminRapport = cheminRapport;
		this.NumeroDemande = numeroDemande;
		this.matricule = matricule;
		this.decision = decision;	
	}
	
	public Decision(int numeroDemande,String nomProcedure, String decision, int numeroEtape) {
		this.NumeroDemande = numeroDemande;
		this.nomProcedure = nomProcedure;
		this.decision = decision;
		this.NumeroEtape=numeroEtape;
	}

	public String getCheminRapport() {
		return cheminRapport;
	}

	public void setCheminRapport(String cheminRapport) {
		this.cheminRapport = cheminRapport;
	}

	public int getNumeroDemande() {
		return NumeroDemande;
	}

	public void setNumeroDemande(int numeroDemande) {
		NumeroDemande = numeroDemande;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	
	public int getNumeroEtape() {
		return NumeroEtape;
	}

	public void setNumeroEtape(int numeroEtape) {
		NumeroEtape = numeroEtape;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	@Override
	public String toString() {
		return "Decision [cheminRapport=" + cheminRapport + ", NumeroDemande=" + NumeroDemande + ", matricule="
				+ matricule + ", decision=" + decision + "]";
	}
	
	
	
	public String getNomProcedure() {
		return nomProcedure;
	}

	public void setNomProcedure(String nomProcedure) {
		this.nomProcedure = nomProcedure;
	}

	public void afficher()
	{
		System.out.println(this.toString());
	}

}
