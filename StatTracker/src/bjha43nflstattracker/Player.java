/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 * Class used to store information from the players table. 
 * 
 */
public class Player {
    
    protected Integer playerID;
    protected String firstName;
    protected String lastName;

    public Integer getPlayerID() {
        return playerID;
    }
    protected String name;

    public Player(Integer playerID, String firstName, String lastName) {
        this.playerID = playerID;
        this.firstName = firstName;
        this.lastName = lastName;
        name = firstName + " " + lastName;
    }

    public String getName() {
        return name;
    }
   
    
}
