/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 * Class used to delete a user entry in the database
 */
public class DBDeleteUser extends DBRequest {
    
    protected Integer user;

    public DBDeleteUser(Integer user) {
        this.user = user;
        
        input = "delete from user where(iduser = '" + user + "')";
        executeStatement();
    }
    
    
    
}
