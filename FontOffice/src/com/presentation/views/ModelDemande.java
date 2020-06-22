package com.presentation.views;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import com.business.Decision;

public class ModelDemande extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Decision> lesDecisions;
	private String s[]= {"Demande","Procedure","Etat","Etape"};
	
	public ModelDemande(ArrayList<Decision> lesDecisions) {
		this.lesDecisions = lesDecisions;
	}

	@Override
	public int getRowCount() {
		return lesDecisions.size();
	}

	@Override
	public int getColumnCount() {
		return this.s.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Decision e=lesDecisions.get(rowIndex);
		switch(columnIndex) {
		case 0: return e.getNumeroDemande();
		case 1: return e.getNomProcedure();
		case 2: return e.getDecision();
		case 3: return e.getNumeroEtape();
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
		case 0: return Integer.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return Integer.class;
		default : return null;
		}
	}
}
