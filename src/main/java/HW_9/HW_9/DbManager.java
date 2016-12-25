package HW_9.HW_9;

import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	
	 public static void addTables(Statement stmt) throws SQLException{
	    	
	    	stmt.execute("DROP TABLE IF EXISTS POST");
			stmt.execute("DROP TABLE IF EXISTS EMPLOYEE");
			stmt.execute("DROP TABLE IF EXISTS HOBBIES");
			stmt.execute("DROP TABLE IF EXISTS EMPLOYEE_HOBBIES");
			
			stmt.execute("CREATE TABLE POST("
					+ "ID_PROFESSION INT AUTO_INCREMENT,"
					+ "Profession VARCHAR(255))");
			
			stmt.execute("CREATE TABLE EMPLOYEE("
					+ "ID_EMPLOYEE INT AUTO_INCREMENT,"
					+ "NAME VARCHAR(255),"
					+ "EXP INT,"
					+ "SALARY FLOAT,"
					+ "ID_PROFESSION INT,"
					+ "FOREIGN KEY (ID_PROFESSION) REFERENCES POST (ID_PROFESSION))");
			
			
			stmt.execute("CREATE TABLE HOBBIES("
					+ "ID_HOBBIES INT AUTO_INCREMENT,"
					+ "KIND_OF_HOBBIES VARCHAR(50))");
			
			stmt.execute("CREATE TABLE EMPLOYEE_HOBBIES("
					+ "ID_EMPLOYEE INT,"
					+ "ID_HOBBIES INT,"
					+ "PRIMARY KEY(ID_EMPLOYEE, ID_HOBBIES),"
					+ "FOREIGN KEY (ID_EMPLOYEE) REFERENCES EMPLOYEE (ID_EMPLOYEE),"
					+ "FOREIGN KEY (ID_HOBBIES) REFERENCES HOBBIES (ID_HOBBIES))");
	    }

	 public static void addData(Statement stmt) throws SQLException{
			stmt.executeUpdate("INSERT INTO POST VALUES(NULL, 'Director')");
			stmt.executeUpdate("INSERT INTO POST VALUES(NULL, 'Programmer')");
			stmt.executeUpdate("INSERT INTO POST VALUES(NULL, 'Tester')");
			stmt.executeUpdate("INSERT INTO POST VALUES(NULL, 'Manager')");
			
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Artes', 23, 25000, 3)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Kate', 43, 26000, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Max', 33, 31000, 4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'David', 5, 35000, 2)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Petya', 3, 32000, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Vasim', 4, 32000, 3)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Artur', 4, 31000, 4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Boris', 23, 1000, 4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Andrey', 23, 12000, 3)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Vasya', 40, 12000, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Denis', 21, 15000, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Oleg', 12, 45000, 2)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Olga', 43, 37000, 3)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Darya', 31, 12000, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE VALUES(NULL, 'Lena', 5, 10000, 4)");
			
			stmt.executeUpdate("INSERT INTO HOBBIES VALUES(NULL, 'Fishing')");
			stmt.executeUpdate("INSERT INTO HOBBIES VALUES(NULL, 'Roading')");
			stmt.executeUpdate("INSERT INTO HOBBIES VALUES(NULL, 'Reading')");
			stmt.executeUpdate("INSERT INTO HOBBIES VALUES(NULL, 'Writing')");
			stmt.executeUpdate("INSERT INTO HOBBIES VALUES(NULL, 'Swimming')");
			
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(1, 4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(1, 5)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(2, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(2, 4)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(2, 5)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(3, 1)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(3, 2)");
			stmt.executeUpdate("INSERT INTO EMPLOYEE_HOBBIES VALUES(3, 3)");
	 }
}
