package com.presentation.views;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.metier.business.Employe;

public class ModelEmployeArchive extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Employe> lesEtudiants;
	private String s[]= {"nom","prenom","numero","Date de naissance","Date d'ambauche","Service","Chef","Archive"};
	
	public ModelEmployeArchive(ArrayList<Employe> lesEtudiants) {
		this.lesEtudiants = lesEtudiants;
	}

	@Override
	public int getRowCount() {
		return lesEtudiants.size();
	}

	@Override
	public int getColumnCount() {
		return this.s.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employe e=lesEtudiants.get(rowIndex);
		switch(columnIndex) {
		case 0: return e.getNom();
		case 1: return e.getPrenom();
		case 2: return e.getMatricule();
		
		case 3: return e.getDateNaissance();
		case 4: return e.getDateEmbauche();
		case 5: return e.getService().getNom();
		case 6: return e.getChef();
		case 7: return e.getArchive();
		default : return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return this.s[column];
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0: return String.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return String.class;
		case 4: return String.class;
		case 5: return String.class;
		case 6: return Boolean.class;
		case 7: return Boolean.class;
		default : return null;
		}
	}
	
	public boolean isCellEditable(int row, int column)  
	{  
		if(column==7)
	         return true;  
		return false;
	}  
	
	public void setValueAt(Object value, int row, int column)  
	{  
		if(column==7)
		{
			Employe e=lesEtudiants.get(row);
			e.setArchive(Boolean.valueOf(value.toString()));
		}
	}

	public ArrayList<Employe> getLesEtudiants() {
		return lesEtudiants;
	}

	public void setLesEtudiants(ArrayList<Employe> lesEtudiants) {
		this.lesEtudiants = lesEtudiants;
	}  
	
}
