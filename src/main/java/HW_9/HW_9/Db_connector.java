package HW_9.HW_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connector {
	
    private static Db_connector db_connector;
    private static Connection connect ;

    private Db_connector() {

    }

    public static Db_connector getInstance(){
    	if(db_connector == null){
    		db_connector = new Db_connector();
    	}
    	return db_connector;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException{

        if(connect == null){
        	
        	String host = "jdbc:h2:tcp://localhost/~/test";
        	String username = "minorius";
        	String password = "170190";
        	String JDBC_DRIVER = "org.h2.Driver";
        	
        	Class.forName(JDBC_DRIVER);
        	connect = DriverManager.getConnection( host, username, password );
        }
		return connect;
    }
}
