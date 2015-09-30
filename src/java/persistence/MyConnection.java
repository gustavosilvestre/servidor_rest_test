package persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gustavo
 */
public final class MyConnection {
    
    private static Connection connection;
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String DB_URL = "jdbc:mysql://localhost/product_cast";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "JASON321";

    private MyConnection() {
        super();
    }
    
    public static Connection getConnection(){
        
        try {
            Class.forName(JDBC_DRIVER);
           connection = DriverManager.getConnection(DB_URL,LOGIN,PASSWORD);
           Logger.getLogger("Connectado com sucesso");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }
    
    
    
}
