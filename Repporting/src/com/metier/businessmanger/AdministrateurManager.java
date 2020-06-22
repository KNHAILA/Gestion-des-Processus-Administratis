package com.metier.businessmanger;

import com.metier.business.Administrateur;


public class AdministrateurManager {
	private com.persistence.DAORepo.DAOAdministrateur daoadministrateur;
	public AdministrateurManager() {
		daoadministrateur=new com.persistence.DAORepo.DAOAdministrateur();
	}
	
	public Administrateur getpassword(String Matricule) {
		return daoadministrateur.getPassword(Matricule);
	}

}