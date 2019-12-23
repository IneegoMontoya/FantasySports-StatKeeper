/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann
 */
public class StatValue extends DBRequest {
    
    protected String statType;
    protected Integer playerID;
    protected Integer year;

    public StatValue(String statType, Integer playerID, Integer year) {
        this.statType = statType;
        this.playerID = playerID;
        this.year = year;
        
        input = "select stat_value from stats where(player = '" + playerID +"' and year = '" + year.toString() +"' and stat_type = '" + statType +"')";
        
        
    }
    
}
