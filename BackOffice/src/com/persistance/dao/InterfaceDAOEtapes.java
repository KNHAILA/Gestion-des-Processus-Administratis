package com.persistance.dao;

import java.util.ArrayList;

import com.metier.business.Etape;

public interface InterfaceDAOEtapes {

	//boolean add(Etape i) ;
	ArrayList<Etape> getAll();



	Etape searchById(int id);
	boolean delete(int id);
	
	



	boolean add(int numep, String nomep, String numemp, int proc,int ord);




}
