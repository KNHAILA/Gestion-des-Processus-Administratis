package com.persistance.dao;

import java.util.ArrayList;

import com.metier.business.DataException;
import com.metier.business.Procedure;

public interface InterfaceDAOProcedure {
	boolean add(Procedure p) throws DataException;
	Procedure searchById(int id);
	ArrayList<Procedure> getAll();
	//Boolean update(Procedure i);
}
