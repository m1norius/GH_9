package HW_9.HW_9;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
   
			Statement stmt = Db_connector.getInstance().getConnection().createStatement();
			
			DbManager.addTables(stmt);
			DbManager.addData(stmt);
			
			//Director, Programmer, Tester, Manager
			
			getSalary(stmt, "Tester");

			 
    }
    
    public static void getSalary(Statement stmt, String profession) throws SQLException{

		ResultSet rs_1 = stmt.executeQuery("SELECT SALARY FROM POST, EMPLOYEE WHERE "
				+ "POST.ID_PROFESSION = EMPLOYEE.ID_PROFESSION "
				+ "AND "
				+ "POST.Profession = '"
				+ profession
				+ "' ");
		
		getResult(rs_1);
    	
    }
    
    public static void getResult(ResultSet rs) throws SQLException{
		Double sum = 0.0;
		 while ( rs.next() ) {
		        int numColumns = rs.getMetaData().getColumnCount();
		        for ( int i = 1 ; i <= numColumns ; i++ ) {
		        	sum = sum + (Double) rs.getObject(i); 
		           	
		        }
		    }
		 System.out.print( ""+sum +", " );
    }
    
}
