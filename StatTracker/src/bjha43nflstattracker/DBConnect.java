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

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public interface DBConnect {

    public Connection getConnection();
    public ResultSet getResults();
    
    
}
