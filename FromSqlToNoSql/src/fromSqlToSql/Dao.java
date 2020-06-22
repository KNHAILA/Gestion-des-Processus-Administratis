package fromSqlToSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Dao {
	private Connection con = ConnexionDB.Connexion();
	private PreparedStatement pst = null;
	private ResultSet resultSet = null;
	
	public ResultSet getResultSet(String SQL)
	{
		try{
			pst = con.prepareStatement(SQL);
			resultSet = pst.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public ResultSet getResultSetLesProcedures()
	{
		String SQL = "select*from proced where archivee="+false;
		return getResultSet(SQL);
	}
	
	public ResultSet getResultSetLesChefsDeService()
	{
		String SQL = "select*from employe where chef =true and etat=true" ;
		return getResultSet(SQL);
	}
	
	public ResultSet getResultSetLesEmployes()
	{
		String SQL = "select*from employe where chef =false and etat=true";
		return getResultSet(SQL);
	}
	
	public ResultSet getResultSetLesEtapes()
	{
		String SQL = "select*from etape";
		return getResultSet(SQL);
	}
	
	public static void main(String[] args) {
 	//	Dao d=new Dao();
	}
}
