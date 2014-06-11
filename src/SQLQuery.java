import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLQuery extends DataBaseUtil{
	private String test[][];
	public  SQLQuery(){
	super();
}
public String[][] getquery(String Sql,int ...num){
	ResultSet rs=executeQuery(Sql);
	try {
		rs.last();
		int s; 
		s = rs.getRow();
		rs.beforeFirst();
		String resultString[][]=new String[s][num.length];
		int m=0;
		while(rs.next()){
			for(int i=0;i<num.length;i++){
			resultString[m][i]=rs.getString(num[i]);}
			m++;
		}
		return resultString;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return test;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
