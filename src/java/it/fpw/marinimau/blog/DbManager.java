package it.fpw.marinimau.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bardoz
 */
public class DbManager {
    
    private static DbManager instance;
    
    private DbManager(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static DbManager getInstance()
    {
        if (instance == null)
            instance = new DbManager();
        
        return instance;
    }
    
    public Connection getDbConnection()
    {
        String db = "jdbc:mysql://ec2-52-47-198-123.eu-west-3.compute.amazonaws.com:443/fpw18_marinimauro?zeroDateTimeBehavior=convertToNull";
        
        try {
            Connection conn = DriverManager.getConnection(db, "fpw18_marinimauro", "marinimau");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
} 

