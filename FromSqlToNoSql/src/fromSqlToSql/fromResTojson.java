package fromSqlToSql;

import java.util.HashMap;

import org.json.JSONObject;

public class fromResTojson {
	private static Dao dao=new Dao();
	public static HashMap<Integer,JSONObject> LesProcedures(){
		return jsonServices.getFormattedResult(dao.getResultSetLesProcedures());
	}
	
	public static HashMap<Integer,JSONObject> LesEtapes(){
		return jsonServices.getFormattedResult(dao.getResultSetLesEtapes());
	}
	
	public static HashMap<Integer,JSONObject> LesEmployes(){
		return jsonServices.getFormattedResult(dao.getResultSetLesEmployes());
	}
	
	public static HashMap<Integer,JSONObject> LesChefsDeService(){
		return jsonServices.getFormattedResult(dao.getResultSetLesChefsDeService());
	}
	
	public static void main(String[] args) {
		System.out.println(fromResTojson.LesProcedures());
	}
}
