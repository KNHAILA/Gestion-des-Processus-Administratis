	package com.persistence.DAORepo;

	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Iterator;

	import org.bson.Document;

import com.metier.business.Employe;
import com.metier.business.Procedure;
import com.mongodb.BasicDBObject;
	import com.mongodb.DBCollection;
	import com.mongodb.DBCursor;
	import com.mongodb.DBObject;
	import com.mongodb.client.MongoCollection;
	import com.mongodb.client.MongoCursor;
	import com.persistance.connection.ConnNoSql;

public  class DAOEmploye {

		MongoCollection<Document> collection;
		DBCollection collection1;
		DBCollection collection2;

		public DAOEmploye() {
			super();
			collection = ConnNoSql.getCollection1("Decision");
			collection1 = ConnNoSql.getCollection("Employe");
			collection2= ConnNoSql.getCollection("Etape");
			
		}
		
		public ArrayList<Employe> getValidees()
		{
			BasicDBObject searchQuery = new BasicDBObject();
	        ArrayList<Employe> report = new ArrayList<>();
	        
	        MongoCursor<Document> cursor= ConnNoSql.getCollection1("Decision").find().iterator();
	       
	        Document doc;
	    while(cursor.hasNext()) {
	       doc = cursor.next();  
	         if(doc.getString("Decision").equals("Acceptée")) {
	            Employe e=new Employe();
	            searchQuery.put("Matricule", doc.getString("matricule"));
	            DBCursor cursor2 = collection1.find(searchQuery);
	            e.setMatricule(doc.getString("matricule"));
	           e.setNom((String)cursor2.one().get("nom"));
	           e.setPrenom((String)cursor2.one().get("prenom"));
	          try {
	             report.add(e);
	          }catch(Exception d) {
	        	  d.printStackTrace();
	          }
	             cursor2.close();
	             }
	        }
	        cursor.close();
	        int total=report.size();
	        for(int i=0;i<total;i++)
	        {
	        	report.get(i).setNombreEtapesValidees(Collections.frequency(report, report.get(i)));
	        	report.get(i).setNombreEtapes(this.getNbEtapes(report.get(i).getMatricule()));
	        }
	        return report;
		}
		public ArrayList<Employe> getNombreEtapes()
		{
			BasicDBObject searchQuery = new BasicDBObject();
	        ArrayList<Employe> report = new ArrayList<>();
	        
	        MongoCursor<Document> cursor= ConnNoSql.getCollection1("Etape").find().iterator();
	       
	       
	        Document doc;
	    while(cursor.hasNext()) {
	       doc = cursor.next();  
	            Employe e=new Employe();
	            searchQuery.put("Matricule", doc.getString("Matricule_e"));
	            DBCursor cursor2 = collection1.find(searchQuery);
	            e.setMatricule(doc.getString("Matricule_e"));
	           e.setNom((String)cursor2.one().get("nom"));
	           e.setPrenom((String)cursor2.one().get("prenom"));
	          try {
	             report.add(e);
	          }catch(Exception d) {
	        	  d.printStackTrace();
	          }
	             cursor2.close();
	             }
	        cursor.close();
	        int total=report.size();
	        for(int i=0;i<total;i++)
	        {
	        	report.get(i).setNombreEtapes(Collections.frequency(report, report.get(i)));
	        	
	        }
	        return report;
		}
		public int getNbEtapes(String mat) {
		  BasicDBObject searchQuery = new BasicDBObject();
		  searchQuery.put("Matricule_e", mat);
		 return  collection2.find(searchQuery).count();
		}
		public int getTotal() {
			 return  collection2.find().count();
			}
		
	public static void main(String[] args) {
		ArrayList<Employe> list=new ArrayList<Employe>();
		DAOEmploye e=new DAOEmploye();
		list=e.getValidees();
		Iterator<Employe> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		
		}
		}


	
}
