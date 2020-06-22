package com.businessmanager;

import com.business.Citoyen;
import com.persistance.dao.DAOCitoyen;

import fromSqlToSql.fromResTojson;

public class CitoyenManger {
	
	private DAOCitoyen daocitoyen;
	
	public CitoyenManger() {
		daocitoyen=new DAOCitoyen();
	}
	
	public boolean setCitoyen(Citoyen c)
	{
		return daocitoyen.setCitoyen(c);
	}
	public static void main(String[] args) {
		System.out.print(fromResTojson.LesProcedures());
	}
}
