package com.businessmanager;

import java.util.ArrayList;
import java.util.HashMap;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import com.persistance.connection.ConnNoSql;

import fromSqlToSql.fromResTojson;

@SuppressWarnings("deprecation")
public class EtapeManager {
	public static ArrayList<ArrayList<Integer>> LesEtapesDunEmploye(String s)
	{
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		ConnNoSql.getCollection1("Etape").drop();
		HashMap<Integer, JSONObject> d = fromResTojson.LesEtapes();
		Document m=new Document();
		m.append("Matricule_e",s);
		try {
			for(JSONObject o: d.values())
	    	{
				BasicDBObject us = (BasicDBObject )JSON.parse(o.toString());
				ConnNoSql.getCollection("Etape").insert(us);
	    	}
			MongoCursor<Document> cursor= ConnNoSql.getCollection1("Etape").find(m).iterator();
			Document doc;
		    while(cursor.hasNext()) {
	            doc = cursor.next();
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(doc.getInteger("numero_p"));
	            l.add(doc.getInteger("ordre"));
	            list.add(l);
		    }
		    //select numero_p , ordre from etape where Matricule_a="M1"
		    return list;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static HashMap<Integer, String> DemandesDeEmploye(String s) {
		HashMap<Integer, String> list=new HashMap<Integer, String>();
		ArrayList<ArrayList<Integer>> etapes=null;
		ArrayList<Integer> etape=new ArrayList<Integer>();
		etapes=EtapeManager.LesEtapesDunEmploye(s);
		if(etapes!=null)
		{
			for(int i=0;i<etapes.size();i++)
			{
				etape=etapes.get(i);
				BasicDBObject d=new BasicDBObject();
				d.append("jeton", true);
				d.append("Numero_p",etape.get(0));
				d.append("ordre", etape.get(1));
				MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find(d).iterator();
				Document doc;
				while(cursor.hasNext()) {
					doc = cursor.next();
						list.put(doc.getInteger("_id"),"Demande numero "+doc.getInteger("_id")+" est à l'étape numero "
							+doc.getInteger("ordre")+" de la procedure "+ProcedureManager.NameOfId(etape.get(0)));
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(EtapeManager.DemandesDeEmploye("M2"));
	}
}
