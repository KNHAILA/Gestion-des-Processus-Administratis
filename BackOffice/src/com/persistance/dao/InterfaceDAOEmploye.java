package com.persistance.dao;

import java.util.ArrayList;
import com.metier.business.*;

public interface InterfaceDAOEmploye {
	boolean add(Employe i);
	Employe searchById(String id);
	ArrayList<Employe> getAll();
	Boolean update(Employe i);
	Boolean isPassWordCorrect(String matricule,String passWord);
	public ArrayList<Employe> getAllActive();
	public Boolean updateArchive(Employe i);
	public  String[] rempcombo();
}
