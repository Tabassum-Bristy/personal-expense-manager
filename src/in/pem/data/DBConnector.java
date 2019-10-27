package in.pem.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    
    // constants
    static final String DATABASE_URL = "jdbc:mysql://localhost/pem";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "";
    
   
    
    public Connection getConnection() {
        
       Connection connection = null;
       
       try {
           connection = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWORD);
       }
       catch(Exception ex) {
           ex.printStackTrace();
       }
       return connection;
    }
    
}
