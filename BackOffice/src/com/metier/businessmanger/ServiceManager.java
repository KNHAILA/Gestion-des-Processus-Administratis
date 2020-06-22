package com.metier.businessmanger;

import java.util.ArrayList;
import com.metier.business.Service;
import com.persistance.dao.DAOService;

public class ServiceManager {
	private DAOService daoservice;
	
	public ServiceManager() {
		daoservice=new DAOService();
	}
	
	public ArrayList<Service> ListeService()
	{
		return daoservice.getAll();
	}
	
	public String[] ListeNoms()
	{
		String[]  array = daoservice.getAllNames().toArray(new String[daoservice.getAllNames().size()]);
		return array;
	}
	public Service selectByName(String nom) {
		return daoservice.searchById(nom);
	}
	public static void main(String[] args) {
		ServiceManager s=new ServiceManager();
		System.out.print(s.selectByName("service2"));
	}
}
