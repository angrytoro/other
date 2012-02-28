package pattern.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public abstract class JdbcTemplate {

	public final Object execute(StatementCallback action)throws SQLException{
		Connection con = null;
		Statement stmt = null;
		try{
			stmt = con.createStatement();  
            Object result = action.doInStatement(stmt);   
            return result;
		}catch (SQLException ex) {  
            ex.printStackTrace();  
            throw ex;  
       }  
       finally {  
  
           try {  
        	   stmt.close();  
           } catch (SQLException e) {  
               e.printStackTrace();  
           }  
           try {  
               if(!con.isClosed()){  
                   try {  
                       con.close();  
                   } catch (SQLException e) {  
                       e.printStackTrace();  
                   }  
               }  
           } catch (SQLException e) {  
               e.printStackTrace();  
           } 
       }
	}

	public Object query(StatementCallback stmt)throws SQLException{
		return execute(stmt);
	}
}
