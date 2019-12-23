/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

/**
 *
 * @author Byron Hammann - bjha3
 * Class for getting the career stats for players not listed as a quarterback.
 */
public class DBSkillData extends DBRequest {
    
    public DBSkillData() {
        
        input = "with\n" +
"STAT_PIVOT as (\n" +
"select player,\n" +
"SUM(case when stat_type='Receiving_TD' then stat_value end) as \"Passing_TD\",\n" +
"SUM(case when stat_type='Receiving_Yards' then stat_value end) as \"Passing_Yards\",\n" +
"SUM(case when stat_type='Rushing_Yards' then stat_value end) as \"Rushing_Yards\",\n" +
"SUM(case when stat_type='Rushing_TD' then stat_value end) as \"Rushing_TD\"\n" +
"from stats\n" +
"group by player\n" +
")\n" +
"select p.fname, p.lname, s.Passing_TD, s.Rushing_TD, s.Passing_Yards, s.Rushing_Yards\n" +
"from players p\n" +
"inner join STAT_PIVOT s on (s.player=p.playerid)\n" +
"where(p.position != 'QB')";
        
    }
    
    
    
}
