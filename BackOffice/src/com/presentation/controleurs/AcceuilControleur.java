package com.presentation.controleurs;

import com.presentation.views.Acceuil;
import com.presentation.views.Authentification;
import com.presentation.views.GestionEmploye2;
import com.presentation.views.GestionEtapes;
import com.presentation.views.GestionProcedure1;

public class AcceuilControleur {
	
	private Acceuil acceuil;
	
	public AcceuilControleur() {
	}

	public Acceuil getAcceuil() {
		return acceuil;
	}

	public void setAcceuil(Acceuil acceuil) {
		this.acceuil = acceuil;
		acceuil.setControleur(this);
	}
	public void acceder()
	{
		GestionEmploye2 a=new GestionEmploye2();
		a.setSize(acceuil.getSize());
		a.setLocation(acceuil.getLocation());
		//a.setLocationRelativeTo(null);
		acceuil.dispose();
		a.setVisible(true);
	}
	public void acceder1()
	{
	GestionProcedure1 a=new GestionProcedure1();
	a.setSize(acceuil.getSize());
	a.setLocation(acceuil.getLocation());
	//a.setLocationRelativeTo(null);
	acceuil.dispose();
	a.setVisible(true);
	}
	public void acceder2()
	{
	GestionEtapes e=new GestionEtapes();
	e.setSize(acceuil.getSize());
	e.setLocation(acceuil.getLocation());
	//a.setLocationRelativeTo(null);
	acceuil.dispose();
	e.setVisible(true);
	}
}
