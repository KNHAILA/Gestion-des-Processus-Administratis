package com.persistance.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import com.business.Demande;
import com.businessmanager.ProcedureManager;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.persistance.connection.ConnNoSql;


public class DAODemande {
	
	public boolean setDemande(Demande demande) {
		Document d=new Document();
		d.append("_id", demande.getNumero());
		d.append("CIN",demande.getCitoyen().getCIN());
		d.append("Numero_p",demande.getNumeroProcedure());
		d.append("jeton", false);
		d.append("Demandes",demande.getFichiers());
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		if(d3==null)
		{
			ConnNoSql.getCollection1("Demande").insertOne(d);
			return true;
		}
		else
			return false;
	}
	
	public static Integer getOrdreDemande(int id) {
		Document d=new Document();
		d.append("_id", id);
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		if(d3!=null)
		{
			return d3.getInteger("ordre");
		}
		return null;
	}
	
	
	public int getProcedure(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("_id", n);
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		if(d3!=null)
		{
			return d3.getInteger("Numero_p");
		}
		else
			return -1;
	}
	
	public String[] getDocuments(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("_id", n);
		Document str = ConnNoSql.getCollection1("Demande").find(d).first();
		if(str!=null) {
			List<String> DemandesList = (List<String>) str.get("Demandes", List.class);
		    Set<String> DemandesSet = new HashSet<>(DemandesList);
		    String[] myArray = new String[DemandesList.size()];
		    DemandesSet.toArray(myArray);
		    return myArray;
		}
		return null;
	}
	
	public static HashMap<Integer, String> DemandesNonTraités() {
		HashMap<Integer, String> list=new HashMap<Integer, String>();
		BasicDBObject d=new BasicDBObject();
		d.append("jeton", false);
		MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find(d).iterator();
		Document doc;
	    while(cursor.hasNext()) {
            doc = cursor.next();
            if(doc.getInteger("ordre")==null)
            {
            	list.put(doc.getInteger("_id"),"Demande numero "+doc.getInteger("_id")+" Concernant la procedure "
            		+ProcedureManager.NameOfId(doc.getInteger("Numero_p")));
            }
	    }
	    return list;
	}
	
	public static HashMap<Integer, String> DemandesAcceptesParLeChef() {
		HashMap<Integer, String> list=new HashMap<Integer, String>();
		BasicDBObject d=new BasicDBObject();
		d.append("jeton", true);
		MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find(d).iterator();
		Document doc;
	    while(cursor.hasNext()) {
            doc = cursor.next();
            if(doc.getInteger("ordre")==null && doc.getInteger("ordre")!=-1)
            {
            	list.put(doc.getInteger("_id"),"Demande numero "+doc.getInteger("_id")+" Concernant la procedure "
            		+ProcedureManager.NameOfId(doc.getInteger("Numero_p")));
            }
	    }
	    return list;
	}
	public void accepter(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("_id", n);
		BasicDBObject d3 = new BasicDBObject();
		d3.append("$set", new BasicDBObject().append("jeton",true).append("ordre", 0));
		ConnNoSql.getCollection1("Demande").updateOne(d, d3);
	}
	public Integer getProcedureId(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("_id", n);
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		return d3.getInteger("Numero_p");
	}
	public void refuser(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("_id", n);
		BasicDBObject d3 = new BasicDBObject();
		d3.append("$set", new BasicDBObject().append("ordre", -1));
		ConnNoSql.getCollection1("Demande").updateOne(d, d3);
	}
	
	
	public static void traitementDemandeOrdre(String s, int n)
	{
		BasicDBObject d=new BasicDBObject();
		BasicDBObject newDocument;
		d.append("_id", n);
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		if(d3!=null)
		{
			if(s.equals("Acceptée"))
			{
				if((d3.getInteger("ordre")+1)==ProcedureManager.NombreDesEtapes(d3.getInteger("Numero_p")))
				{
					System.out.println("entre");
					newDocument = 
							new BasicDBObject().append("$set",
									new BasicDBObject().append("ordre", -3));
					ConnNoSql.getCollection1("Demande").updateOne(d, newDocument);
				}
				else
				{
					 newDocument =
						new BasicDBObject().append("$inc",
						new BasicDBObject().append("ordre", 1));
					ConnNoSql.getCollection1("Demande").updateOne(d, newDocument);
				}
				
			}
			if(s.equals("Refusée"))
			{
				if(d3.getInteger("ordre")>=1)
				{
					newDocument =
					new BasicDBObject().append("$inc",
					new BasicDBObject().append("ordre", -1));
					ConnNoSql.getCollection1("Demande").updateOne(d, newDocument);
				}
			}
			if(s.equals("Rejetée"))
			{
				newDocument=new BasicDBObject().append("$set",
						new BasicDBObject().append("ordre", -2));
				ConnNoSql.getCollection1("Demande").updateOne(d, newDocument);
			}
			if(s.equals("Mise-à-jour"))
			{
				newDocument=new BasicDBObject().append("$set",
						new BasicDBObject().append("jeton",false));
				ConnNoSql.getCollection1("Demande").updateOne(d,newDocument);
			}
			}else 
			{	
				System.out.println("Erreuuuuuur");
			}
		}
	public static HashMap<Integer, String> DemandesDunCitoyen(String s) {
		HashMap<Integer, String> list=new HashMap<Integer, String>();
		BasicDBObject d=new BasicDBObject();
		d.append("CIN",s);
		MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find(d).iterator();
		Document doc;
	    while(cursor.hasNext()) {
            doc = cursor.next();
            if(doc.getInteger("ordre")!=null && doc.getInteger("ordre")!=-1)
            	list.put(doc.getInteger("_id"),"Demande numero "+doc.getInteger("_id")+" Concernant la procedure "
            		+ProcedureManager.NameOfId(doc.getInteger("Numero_p")));
	    }
	    return list;
	}
	
	public static int ordreDemande(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("_id", n);
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		return d3.getInteger("ordre");
	}
	
	
	
	public static String etatDemande(int numeroDemande)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("numeroDemande", numeroDemande);
		Document d3 = ConnNoSql.getCollection1("LastDecision").find(d).first();
		return d3.getString("Decision");
	}
	
	public static String RapportDemande(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("numeroDemande", n);
		Document d3 = ConnNoSql.getCollection1("LastDecision").find(d).first();
		if(d3==null)
			return null;
		return d3.getString("Rapport");
	}
	public static void main(String[] args) {
		DAODemande d=new DAODemande();
		System.out.print(d.etatDemande(380660116));		
	}

	public static void updateDemande(int n, ArrayList<String> l) {
		BasicDBObject d=new BasicDBObject();
		BasicDBObject newDocument;
		d.append("_id", n);
		Document d3 = ConnNoSql.getCollection1("Demande").find(d).first();
		if(d3!=null)
		{
			newDocument = 
					new BasicDBObject().append("$set",
							new BasicDBObject().append("Demandes",l).append("jeton", true));
			ConnNoSql.getCollection1("Demande").updateOne(d, newDocument);
		}
	}
}
