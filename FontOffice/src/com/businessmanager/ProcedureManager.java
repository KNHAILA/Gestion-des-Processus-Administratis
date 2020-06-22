package com.businessmanager;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import com.persistance.connection.ConnNoSql;

import fromSqlToSql.fromResTojson;

@SuppressWarnings("deprecation")
public class ProcedureManager {
	public static ArrayList<String> LesNomsDesProcedures()
	{
		ArrayList<String> list=new ArrayList<String>();
		 ConnNoSql.getCollection1("Procedure").drop();
		HashMap<Integer, JSONObject> d = fromResTojson.LesProcedures();
		try {
			for(JSONObject o: d.values())
	    	{
				BasicDBObject us = (BasicDBObject )JSON.parse(o.toString());
				ConnNoSql.getCollection("Procedure").insert(us);
	    	}
			MongoCursor<Document> cursor= ConnNoSql.getCollection1("Procedure").find().iterator();
			Document doc;
		    while(cursor.hasNext()) {
	            doc = cursor.next();
	            list.add(doc.getString("nom").toString());
		    }
		    return list;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static int IdOfName1(String name) {
		Document d=new Document();
		d.append("nom", name);
		FindIterable<Document> c = ConnNoSql.getCollection1("Procedure").find(d);
		if(c.first()!=null)
			return c.first().getInteger("numero");
		else 
			return -1;
	}
	
	public static String NameOfId(int id) {
		Document d=new Document();
		d.append("numero", id);
		FindIterable<Document> c = ConnNoSql.getCollection1("Procedure").find(d);
		if(c.first()!=null)
			return c.first().getString("nom");
		else 
			return null;
	}
	
	public static String FileOfName1(String name) {
		Document d=new Document();
		d.append("nom", name);
		FindIterable<Document> c = ConnNoSql.getCollection1("Procedure").find(d);
		if(c.first()!=null)
			return c.first().getString("chemin");
		else 
			return null;
	}
	
	public static String FileOfName1(int n) {
		Document d=new Document();
		d.append("numero", n);
		FindIterable<Document> c = ConnNoSql.getCollection1("Procedure").find(d);
		if(c.first()!=null)
			return c.first().getString("chemin");
		else 
			return null;
	}
	
	public static Integer NombreDesEtapes(int n) {
		ProcedureManager.LesNomsDesProcedures();
		Document d=new Document();
		d.append("numero", n);
		FindIterable<Document> c = ConnNoSql.getCollection1("Procedure").find(d);
		if(c.first()!=null)
			return c.first().getInteger("nombreEtapes");
		else 
			return null;
	}
	public static void main(String[] args) {
		System.out.println(ProcedureManager.LesNomsDesProcedures());
		System.out.println(ProcedureManager.FileOfName1("Procedure2"));
	}

}
