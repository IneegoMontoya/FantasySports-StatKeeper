/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 * 
 *  This is the query I am using to populate the choice box for updating a players statistics into the stats table.
 *  This choice box associated with this class object will dynamically fill depending on the DB state. 
 * 
 * In theory this will allow for this application to be applied to any sport you desire. 
 */
public class PlayerNames extends DBRequest {
    
    public PlayerNames() {
        input = "select p.playerid, p.fname, p.lname\n" +
"from players as p, teams as t\n" +
"where(p.team_id=t.idteam and t.league = 'NFL');";
    }
    
    
}
