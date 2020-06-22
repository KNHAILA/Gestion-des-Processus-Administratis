package fromSqlToSql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;


public class jsonServices {
	
	public static HashMap<Integer, JSONObject> getFormattedResult(ResultSet rs)
	{
		HashMap<Integer, JSONObject> resList = new HashMap<Integer, JSONObject>();
		try {
			ResultSetMetaData rsMeta=rs.getMetaData();
			int columnCnt = rsMeta.getColumnCount();
			List<String> columnNames=new ArrayList<String>();
			for(int i=1;i<=columnCnt;i++)
			{
				columnNames.add(rsMeta.getColumnName(i));
			}
			int j=1;
			while(rs.next())
			{
				JSONObject obj=new JSONObject();
				for(int i=1;i<=columnCnt;i++)
				{
					String key=columnNames.get(i-1);
					obj.put(key, rs.getObject(i));
				}
				resList.put(j++, obj);
			}
		}catch(Exception e) {
				System.out.println(e);
		}
		return resList;
	}
	public static void main(String[] args) {
	//	jsonServices s=new jsonServices();
		//Dao d=new Dao();
	//	System.out.println(s.getFormattedResult(d.getResultSetLesProcedures()));
	}
}
