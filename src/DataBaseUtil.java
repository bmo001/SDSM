

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseUtil {
	
 private  static Connection con;
 private static Statement statement;
 public static Connection getConnectionAndStatement() {
        	  if(con==null)
        	  {
        		  try{  Class.forName("com.mysql.jdbc.Driver");
        	      }
        	      catch(ClassNotFoundException e) {
        	         System.out.print(e);
        	      }
        	      try { String url="jdbc:mysql://localhost:3306/team7?"
        	                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
        	          con=DriverManager.getConnection(url);
        	          System.out.println("连接成功");
        	          statement=con.createStatement();

        		    }
        		   catch(SQLException e1) { 
        		         System.out.println(e1);
        		      }
        	  }
	     return con;
}
 
public ResultSet executeQuery(String sql) {
		try {
			if(statement==null)
			getConnectionAndStatement();
			return statement.executeQuery(sql);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		finally {
		}
}
 
public  boolean executeUpdate(String sql) {//
	 try {
			if(statement==null)
			getConnectionAndStatement();
			int i=statement.executeUpdate(sql);
			if(i<=0){
				System.out.print("执行失败");
				return false;
			}
			else {
				System.out.print("执行成功");
				return true;
			}
			
		} 
	 catch (SQLException e) {
			 e.printStackTrace();
			 return false;
		} 
	 finally {
		}
}
 

public DataBaseUtil(){
	getConnectionAndStatement();
        
}

   public static Connection getCon() {
	return con;
}

public static void main(String args[]) 
   {
	getConnectionAndStatement();
   }
}
