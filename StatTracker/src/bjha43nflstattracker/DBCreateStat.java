/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 * class for creating a statistic in the stats table. Should qualify as saving data.
 */
public class DBCreateStat extends DBRequest {
    protected String statType;
    protected Integer statValue;
    protected Integer year;
    protected Integer playerID;

    public DBCreateStat(String statType, Integer statValue, Integer year, Integer playerID) {
        this.statType = statType;
        this.statValue = statValue;
        this.year = year;
        this.playerID = playerID;
        
        input = "insert into stats values('" + playerID + "', '" + year + "', '" + statType + "', '" + statValue + "')";
        
        executeStatement();
        
    }
    
    
}
