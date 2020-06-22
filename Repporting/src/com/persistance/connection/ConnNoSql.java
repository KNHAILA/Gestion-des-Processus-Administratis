package com.persistance.connection;


import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnNoSql {
	private final static String DB_Name="mylib";
	private final static String DB_ADDRESS="localhost";
	private final static Integer DB_PORT = 27017;
	
	private final static MongoClient MONGOCLIENT=new MongoClient(DB_ADDRESS,DB_PORT);
	private final static DB MONGODB=MONGOCLIENT.getDB(DB_Name);
	private final static MongoDatabase MONGODB1 =  MONGOCLIENT.getDatabase(DB_Name);
	   
	
	public static DBCollection getCollection(String CollectionName){
		DBCollection coll = MONGODB.getCollection(CollectionName);
		return coll;
	}
	
	public static MongoCollection<Document> getCollection1(String collectionName ){
	    MongoCollection<Document> coll = MONGODB1.getCollection(collectionName);
	    return coll;
	}
	
}
