import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLQuery extends DataBaseUtil{
	private String test[][];
	private int hangshu;
	private String[][] resultString;
	public  SQLQuery(){
	super();
}
public int queryReturnY(String Sql,int ...num){
	ResultSet rs=executeQuery(Sql);
	try {
		rs.last();
		int s; 
		s = rs.getRow();
		rs.beforeFirst();
		resultString=new String[num.length][s];
		int m=0;
		while(rs.next()){
			for(int i=0;i<num.length;i++){
			resultString[i][m]=rs.getString(num[i]);
			System.out.print(resultString[i][m]+"XÊÇ"+i+"YÊÇ"+m);
			}
			m++;
		}
		return m;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
}
public String[][] getData(){
	return resultString;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
