package com.persistance.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;


public class ConnexionDB {
	static String URL = new String("jdbc:mysql://localhost:3306/projet2");
	static String login=new String("root");
	static String Password= new String("");
	private static ConnexionDB obj;
	
	private ConnexionDB() {
	}
	
	public static ConnexionDB getInstance() {
		if(obj==null)
			obj=new ConnexionDB();
		return obj;
	}
	
	public static Connection Connexion() {
		Connection con=null;
		try {
			Class c = Class.forName("com.mysql.cj.jdbc.Driver");
			Driver pilote =(Driver)c.newInstance();
			DriverManager.registerDriver(pilote);
			con=DriverManager.getConnection(ConnexionDB.URL,ConnexionDB.login,ConnexionDB.Password);
		}catch(Exception e) {
			System.out.println("Erreur :"+e);
		}
		return con;
	}
}
