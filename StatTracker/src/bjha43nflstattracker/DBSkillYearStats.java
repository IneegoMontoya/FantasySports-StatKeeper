/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha43
 * Class for getting the yearly stats of players not listed as a quarterback
 * 
 */
public class DBSkillYearStats extends DBRequest {
   
    protected String year;

    public DBSkillYearStats(String year) {
        this.year = year;
        input = "with\n" +
"STAT_PIVOT as (\n" +
"select player,\n" +
"year,\n" +
"MAX(case when year = '" + year +"' and stat_type='Receiving_TD' then stat_value end) as \"Passing_TD\",\n" +
"MAX(case when year = '" + year +"' and stat_type='Receiving_Yards' then stat_value end) as \"Passing_Yards\",\n" +
"MAX(case when year = '" + year +"' and stat_type='Rushing_Yards' then stat_value end) as \"Rushing_Yards\",\n" +
"MAX(case when year = '" + year +"' and stat_type='Rushing_TD' then stat_value end) as \"Rushing_TD\"\n" +
"from stats\n" +
"group by player\n" +
")\n" +
"select p.fname, p.lname, s.Passing_Yards, s.Passing_TD, s.Rushing_Yards, s.Rushing_TD\n" +
"from players p\n" +
"inner join STAT_PIVOT s on (s.player=p.playerid)\n" +
"where(p.position != 'QB')";
    }
    
    
    
}
