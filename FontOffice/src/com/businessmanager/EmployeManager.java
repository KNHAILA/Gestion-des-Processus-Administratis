package com.businessmanager;
import java.util.HashMap;
import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.util.JSON;
import com.persistance.connection.ConnNoSql;

import fromSqlToSql.fromResTojson;

@SuppressWarnings("deprecation")
public class EmployeManager {
	public static void LesEmployes()
	{
		ConnNoSql.getCollection1("Employe").drop();
		HashMap<Integer, JSONObject> d = fromResTojson.LesEmployes();
		try {
			for(JSONObject o: d.values())
	    	{
				BasicDBObject us = (BasicDBObject )JSON.parse(o.toString());
				ConnNoSql.getCollection("Employe").insert(us);
	    	}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void LesChefs()
	{
		ConnNoSql.getCollection1("chef").drop();
		HashMap<Integer, JSONObject> d = fromResTojson.LesChefsDeService();
		try {
			for(JSONObject o: d.values())
	    	{
				BasicDBObject us = (BasicDBObject )JSON.parse(o.toString());
				ConnNoSql.getCollection("chef").insert(us);
	    	}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static boolean TestMotDePasse(String a,String b)
	{
		EmployeManager.LesChefs();
		EmployeManager.LesEmployes();
		Document d=new Document();
		d.append("Matricule", a);
		d.append("Mot_passe", b);
		FindIterable<Document> c;
		c = ConnNoSql.getCollection1("Employe").find(d);
		if(c.first()!=null)
			return true;
		c = ConnNoSql.getCollection1("chef").find(d);
		if(c.first()!=null)
			return true;
		return false;
	}
	
	public static boolean IsChef(String a)
	{
		EmployeManager.LesChefs();
		Document d=new Document();
		d.append("Matricule", a);
		FindIterable<Document> c;
		c = ConnNoSql.getCollection1("chef").find(d);
		if(c.first()!=null)
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		EmployeManager.LesEmployes();
	}
}
