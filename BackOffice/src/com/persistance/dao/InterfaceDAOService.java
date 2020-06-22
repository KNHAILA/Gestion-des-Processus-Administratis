package com.persistance.dao;

import java.util.ArrayList;

import com.metier.business.Service;

public interface InterfaceDAOService {
	
	ArrayList<Service> getAll();
	ArrayList<String> getAllNames();
	public Service searchById(String nom);

}
