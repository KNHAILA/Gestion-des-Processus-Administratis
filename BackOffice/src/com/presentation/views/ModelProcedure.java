package com.presentation.views;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.metier.business.Procedure;

;



public class ModelProcedure extends AbstractTableModel {
		private ArrayList<Procedure> mesProcedures;
          
		public ModelProcedure(ArrayList<Procedure> mesProcedures) {
			super();
			
			this.mesProcedures = mesProcedures;
		}

		public ModelProcedure() {
			super();
		}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return mesProcedures.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			Procedure p = mesProcedures.
					get(rowIndex);
			switch(columnIndex) {
			case 0 : return p.genererNumero();
			case 1 : return p.getNom();
			case 2 : return p.getChef().getNom()+' '+ p.getChef().getPrenom();
			case 3 : return p.getNombreEtapes();
			case 4 : return p.getCheminListe();
			
			
			default : return null;
			}
		}
		
		@Override
		public String getColumnName(int columnIndex ) {
			switch(columnIndex) {
			case 0 : return "Numero de Procédure";
			case 1 : return "Nom de Procédure";
			case 2 : return "Chef de Service";
			case 3: return "Nombre des étapes";
			case 4 :return "Chemin de la liste";
			default : return null;
			}
		}
		@Override
		public Class getColumnClass(int columnIndex ) {
			switch(columnIndex) {
			case 0 : return Integer.class;
			case 1 : return String.class;
			case 2 : return String.class;
			case 3 :  return Integer.class;
			case 4 : return String.class;
			default : return Object.class;
			}
		}
		
}
