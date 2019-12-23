/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 */
public class LoginUser extends DBRequest {
    
    protected String username;
    
    public LoginUser(String username){
        this.username = username;
        input = "select iduser from user where(username = '" + username + "')";
       
    }
    
    public int getUserID(){
        int x = 0;
        
        getConnection();
        try{
           state = conn.createStatement();
           
           set = state.executeQuery(input);
           
           if(set.next()){
            int userID = set.getInt("iduser");
            x = userID;
           }
           
           
       }catch(Exception ex){
           System.out.println("Error");
       }

        return x;
    }
    
     public void setStatement(String column) {
        input = "select iduser from user where(password = '" + column + "' and username = '" + username +  "')";
    }
    
}
