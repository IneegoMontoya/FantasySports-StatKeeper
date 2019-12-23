/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 * Class to update the statistics for a given player
 */
public class DBUpdateStat extends DBRequest {
    protected String statType;
    protected Integer statValue;
    protected Integer year;
    protected Integer playerID;

    public DBUpdateStat(String statType, Integer statValue, Integer year, Integer playerID) {
        this.statType = statType;
        this.statValue = statValue;
        this.year = year;
        this.playerID = playerID;
        
        input = "update stats set stat_value = '" + statValue + "' where(player = '" + playerID + "' and year = '" + year + "' and stat_type = '" + statType +"')";
        
       executeStatement();
    }
   
    
    
}
