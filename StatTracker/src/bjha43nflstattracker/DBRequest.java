/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Byron Hammann - bjha43
 * this is an abstract class which will implement all of the methods I should need to be able to both
 * save data to the database, and retrieve information from the database.
 * 
 * For doing so, I have included the MySQL connector API to the libraries of the project.
 */
public abstract class DBRequest implements DBConnect {
    
     // the username and password for the DB do not change so, made them static and final as to not have them get accidentally altered. 
    protected static final String user = "admin";
    protected static final String password = "password";
    
    protected Connection conn = null;
    protected Statement state = null;
    protected ResultSet set = null;
   
    protected String input = "select * from user";
    //protected String output;
 
    
    public Connection getConnection(){
                       
        try{
        
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sports", user, password);  
            
            
        }catch (Exception ex){
            System.out.println("Connection Failure");
        };
        
        return conn;
    }
 
    
    public ResultSet getResults(){
        
       getConnection();
       
       try{
           state = conn.createStatement();
           
           set = state.executeQuery(input);
           
       }catch(Exception ex){
           System.out.println("Error");
       }
       
       
       return set;
    }   
       
    // method for closing out the the database result set, statement, and connection
    
       public void closer(){
           
        try {
            set.close();
            state.close();
            conn.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
       
       // there are times when you only need to send data to the database, and a result set is not returned. So need a method for just 
       // delivering that information to the database
       protected void executeStatement(){
           getConnection();
        try{
           state = conn.createStatement();
           
           state.executeUpdate(input);
                                
           conn.close();
           state.close();
       }catch(Exception ex){
           System.out.println("Statement Error");
       }
       }
   
    
}
