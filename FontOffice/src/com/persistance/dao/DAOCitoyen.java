package com.persistance.dao;

import org.bson.Document;

import com.business.Citoyen;
import com.business.Demande;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.model.Updates;
import com.persistance.connection.ConnNoSql;

public class DAOCitoyen {
	
	public Citoyen getCitoyen(Document document) {
	  Document documentdem=(Document) document.get("Citoyen");
		if(documentdem!=null)
		{
			return new Citoyen(documentdem.getString("_id"));
		}
		return null;
	}

	public boolean setCitoyen(Citoyen c)
	{
		BasicDBObject document=new BasicDBObject();
		DBObject document1=new BasicDBObject();
		document.put("_id", c.getCIN());
		document1=ConnNoSql.getCollection("Citoyen").findOne(document);
		if(document1==null) {
			ConnNoSql.getCollection("Citoyen").insert(document);
			return true;
		}
		else
			System.out.println("Inseré");
		return false;
	}
	public boolean addDemande(Demande c) {
		BasicDBObject document=new BasicDBObject();
		document.put("_id", c.getNumero());
		DBObject document1=new BasicDBObject();
		DBObject document2=new BasicDBObject();
		document1.put("_id", c.getCitoyen().getCIN());
		document2=ConnNoSql.getCollection("Citoyen").findOne(document1);
		if(document2!=null) {
			ConnNoSql.getCollection1("Citoyen").updateOne(document, Updates.addToSet("Demandes", document1));
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DAOCitoyen d=new DAOCitoyen();
		System.out.println(d.setCitoyen(new Citoyen("M")));
		
	}
}
