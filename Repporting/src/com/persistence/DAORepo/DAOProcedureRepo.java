package com.persistence.DAORepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.bson.Document;

import com.metier.business.Procedure;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.persistance.connection.ConnNoSql;


public class DAOProcedureRepo  {

	MongoCollection<Document> collection;
	DBCollection collection1;
	DBCollection collection2;

	public DAOProcedureRepo() {
		super();
		collection = ConnNoSql.getCollection1("Demande");
		collection1 = ConnNoSql.getCollection("Procedure");
		collection2 = ConnNoSql.getCollection("Demande");
		
	}
	
	public ArrayList<Procedure> getAccepted()
	{
		BasicDBObject searchQuery = new BasicDBObject();
        ArrayList<Procedure> report = new ArrayList<>();
        
        MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find().iterator();
       
        Document doc;
    while(cursor.hasNext()) {
       doc = cursor.next();  
         if(doc.getInteger("ordre")!=null && doc.getInteger("ordre")!=-1 ) {
            Procedure p=new Procedure();
            searchQuery.put("numero", doc.getInteger("Numero_p"));
            DBCursor cursor2 = collection1.find(searchQuery);
           p.setNumero(doc.getInteger("Numero_p"));
     
          p.setNom((String)cursor2.one().get("nom"));
          try {
             report.add(p);
          }catch(Exception e) {
        	  e.printStackTrace();
          }
             cursor2.close();
             }
        }
        cursor.close();
        int total=report.size();
        for(int i=0;i<total;i++)
        {
        	report.get(i).setNombreDemandesAcceptees(Collections.frequency(report, report.get(i)));
        }
        return report;
	}

	public ArrayList<Procedure> getRefused()
	{
		BasicDBObject searchQuery = new BasicDBObject();
        ArrayList<Procedure> report = new ArrayList<>();
        try {
        MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande")
        		.find().iterator();
       
        Document doc;
    while(cursor.hasNext()) {
       doc = cursor.next();  
      
         if(  doc.getInteger("ordre")!=null && doc.getInteger("ordre")==-1) {
            Procedure p=new Procedure();
            searchQuery.put("numero", doc.getInteger("Numero_p"));
            DBCursor cursor2 = collection1.find(searchQuery);
           p.setNumero(doc.getInteger("Numero_p"));
     
          p.setNom((String)cursor2.one().get("nom"));
          
             report.add(p);
             cursor2.close();
             }
        }
        cursor.close();
        int total=report.size();
        for(int i=0;i<total;i++)
        {
        	report.get(i).setNombreDemandesRefusees(Collections
        			.frequency(report, report.get(i)));
        }
        return report;
        }catch(Exception e)
        {
        	 e.printStackTrace();
        }
        return null;
	}
	public ArrayList<Procedure> getEnAttente()
	{
		BasicDBObject searchQuery = new BasicDBObject();
        ArrayList<Procedure> report = new ArrayList<>();
        
        MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find().iterator();
       
        Document doc;
    while(cursor.hasNext()) {
       doc = cursor.next();  
         if( doc.getInteger("ordre")==null ) {
            Procedure p=new Procedure();
            searchQuery.put("numero", doc.getInteger("Numero_p"));
            DBCursor cursor2 = collection1.find(searchQuery);
           p.setNumero(doc.getInteger("Numero_p"));
           
          p.setNom((String)cursor2.one().get("nom"));
             report.add(p);
             cursor2.close();
             }
        }
        cursor.close();
        int total=report.size();
        for(int i=0;i<total;i++)
        {
        	report.get(i).setNombreDemandesEnAttente(Collections.frequency(report, report.get(i)));
        }
        return report;
	}

	public ArrayList<Procedure> getAll()
	{  
		MongoCursor<Document> cursor= ConnNoSql.getCollection1("Procedure").find().iterator();
        ArrayList<Procedure> report1 = new ArrayList<>();
	 while(cursor.hasNext()) {
	       Document doc = cursor.next();  
	       Procedure p=new Procedure();
	       p.setNumero(doc.getInteger("numero"));
	       p.setNom(doc.getString("nom"));
	      report1.add(p);

	 }
	 return report1;
	} 
	public ArrayList<Procedure> getAllDemandes() {
		BasicDBObject searchQuery = new BasicDBObject();
        ArrayList<Procedure> report = new ArrayList<>();
        
        MongoCursor<Document> cursor= ConnNoSql.getCollection1("Demande").find().iterator();
       
        Document doc;
    while(cursor.hasNext()) {
       doc = cursor.next();  
         
            Procedure p=new Procedure();
            searchQuery.put("numero", doc.getInteger("Numero_p"));
            DBCursor cursor2 = collection1.find(searchQuery);
            p.setNumero(doc.getInteger("Numero_p"));
            p.setNom((String)cursor2.one().get("nom"));
            report.add(p);
            cursor2.close();
             
        }
        cursor.close();
        int total=report.size();
    for(int i=0;i<total;i++)
    {
    	report.get(i).setNombreDemandes(Collections.frequency(report, report.get(i)));
    }
    return report;
		
	}
	public int getNbDmd(int num) {
		  BasicDBObject searchQuery = new BasicDBObject();
		  searchQuery.put("Numero_p", num);
		 return  collection2.find(searchQuery).count();
		}
	
	public static void main(String[] args) {
	ArrayList<Procedure> list=new ArrayList<Procedure>();
	DAOProcedureRepo p=new DAOProcedureRepo();
	list=p.getRefused();
	Iterator<Procedure> it=list.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next().toString());
	}
	}
}
