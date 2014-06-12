import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLQuery extends DataBaseUtil{
	private int s,numl;
	private String[][] resultString;
	public  SQLQuery(){
	super();
}
public int getQueryReturnY(String Sql,int ...num){
	ResultSet rs=executeQuery(Sql);
	try {
		rs.last();
		s = rs.getRow();
		numl=num.length;
		rs.beforeFirst();
		int m=0;
		if(numl<=1){
		resultString=new String[numl][s];
		while(rs.next()){
			for(int i=0;i<numl;i++){
			resultString[i][m]=rs.getString(num[i]);
			}
			m++;
		}}
		else {
			resultString=new String[s][numl];
			while(rs.next()){
			for(int i=0;i<numl;i++){
			resultString[m][i]=rs.getString(num[i]);
			}
			m++;
		}}
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
public int getX(){
	return s;
}
public int getY(){
	return numl;
}
	
	
	
	
	
	
	
	
	
	
	
	
}
