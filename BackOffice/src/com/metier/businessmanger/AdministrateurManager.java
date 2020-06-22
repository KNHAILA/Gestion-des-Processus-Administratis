package com.metier.businessmanger;

import com.metier.business.Administrateur;
import com.persistance.dao.DAOAdministrateur;

public class AdministrateurManager {
	private DAOAdministrateur daoadministrateur;
	public AdministrateurManager() {
		daoadministrateur=new DAOAdministrateur();
	}
	
	public Administrateur getpassword(String Matricule) {
		return daoadministrateur.getPassword(Matricule);
	}

}