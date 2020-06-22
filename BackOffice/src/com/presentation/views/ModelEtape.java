package com.presentation.views;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.metier.business.Etape;




public class ModelEtape extends AbstractTableModel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private ArrayList<Etape> mesEtapes;
		private String s[]= {"numero Etape","Nom Etape","Nom Employe"};
          
		public ModelEtape(ArrayList<Etape> mesEtapes) {
			super();
			
			this.mesEtapes = mesEtapes;
		}

	//	public ModelEtape() {
		//	super();
	//	}
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return mesEtapes.size();
		}

		@Override
		public int getColumnCount() {
		  
			return this.s.length;
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			Etape p = mesEtapes.get(rowIndex);
			switch(columnIndex) {
			case 0 : return p.getNumeroetape(p.getNom(), p.getNumero_p());
			case 1 : return p.getNom();
			case 2 : return p.getEmploye().getNom()+" "+p.getEmploye().getPrenom();
		
			
			
			default : return null;
			}
		}
		
		@Override
		public String getColumnName(int columnIndex ) {
			switch(columnIndex) {
			case 0 : return "Numero de l'etape";
			case 1 : return "Nom de l'etape";
			case 2 : return "Nom de l'employe";
			
			default : return null;
			}
		}
		@Override
		public Class<?> getColumnClass(int columnIndex ) {
			switch(columnIndex) {
			case 0 : return Integer.class;
			case 1 : return String.class;
			case 2 : return String.class;
			
			default : return null;
			}
		}
		
}