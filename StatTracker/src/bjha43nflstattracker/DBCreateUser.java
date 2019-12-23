/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha3
 * Class used to create a user in the database.
 */
public class DBCreateUser extends DBRequest {
    
    protected String fName;  
    protected String lName;  
    protected String username;  
    protected String email; 
    protected String password; 
    protected String idUser; 
    protected int userID;
    
    protected String output;

    
    public DBCreateUser(String fName, String lName, String email, String password, String username ){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.username = username;
        
        input = "insert into user values(default, '" + fName + "', '" + lName + "', '" + email + "', '" + password + "', '" + username+ "')";
        System.out.println(input);
        
        executeStatement();
    }

    
    
}
