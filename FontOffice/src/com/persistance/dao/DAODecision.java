package com.persistance.dao;

import java.util.ArrayList;

import org.bson.Document;

import com.business.Decision;
import com.businessmanager.ProcedureManager;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.persistance.connection.ConnNoSql;

public class DAODecision {
	
	public static boolean setDecision(Decision decision) {
		Document d=new Document();
		d.append("numeroDemande",decision.getNumeroDemande());
		d.append("matricule",decision.getMatricule());
		d.append("Rapport",decision.getCheminRapport());
		d.append("Decision",decision.getDecision());
		d.append("ordre", DAODemande.getOrdreDemande(decision.getNumeroDemande()));
		Document d3 = ConnNoSql.getCollection1("Decision").find(d).first();
		if(d3==null)
		{
			ConnNoSql.getCollection1("Decision").insertOne(d);
			DAODemande.traitementDemandeOrdre(decision.getDecision(), decision.getNumeroDemande());
			return true;
		}
		else
			return false;
	}
	public static int ordreDecision(int n)
	{
		BasicDBObject d=new BasicDBObject();
		d.append("numeroDemande", n);
		Document d3 = ConnNoSql.getCollection1("LastDecision").find(d).first();
		return d3.getInteger("ordre");
	}
	
	public static boolean setLastDecision(Decision decision)
	{
		Document d=new Document();
		d.append("numeroDemande",decision.getNumeroDemande());
		ConnNoSql.getCollection1("LastDecision").deleteMany(d);
		d.append("matricule",decision.getMatricule());
		d.append("Rapport",decision.getCheminRapport());
		d.append("Decision",decision.getDecision());
		d.append("ordre", DAODemande.getOrdreDemande(decision.getNumeroDemande()));
		ConnNoSql.getCollection1("LastDecision").insertOne(d);
		return true;
	}
	
	public static ArrayList<Decision> getDecisions()
	{
		ArrayList<Decision> d = new ArrayList<Decision>();
		
		MongoCursor<Document> cursor= ConnNoSql.getCollection1("LastDecision").find().iterator();
		Document doc;
		BasicDBObject demande=new BasicDBObject();
		int n,n1;
		String s;
	    while(cursor.hasNext()) {
            doc = cursor.next();
            demande.append("_id", doc.getInteger("numeroDemande"));
            Document d3 = ConnNoSql.getCollection1("Demande").find(demande).first();
            n1=doc.getInteger("ordre");
            n=d3.getInteger("ordre");
            s=doc.getString("Decision");
            if(n==-3)
            	s="Terminée";
            d.add(new Decision(doc.getInteger("numeroDemande"), ProcedureManager.NameOfId(d3.getInteger("Numero_p")),s, n1));
            }
		return d;
	}
	
}
