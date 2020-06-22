package com.metier.business;

import javax.swing.JOptionPane;

public class DataException extends Exception {
      public DataException(){
    	 JOptionPane.showMessageDialog(null, "Données invalides");
      }
}
