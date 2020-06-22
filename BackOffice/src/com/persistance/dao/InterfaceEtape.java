package com.persistance.dao;
import java.util.ArrayList;

import com.metier.business.Etape;

public interface InterfaceEtape {

	boolean add(Etape i);

	ArrayList<Etape> getAll();

	boolean delete(Etape etape);

	Etape searchById(int id);

}
