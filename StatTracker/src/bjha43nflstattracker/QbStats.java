/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

import com.mysql.cj.conf.StringProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Byron Hammann
 * 
 */
public class QbStats {

    protected String firstName;
    protected String lastName;

    protected Integer passingTD;
    protected Integer rushingTD;
    protected Integer passingYards;
    protected Integer rushingYards;

    public QbStats(String firstName, String lastName, Integer passingTD, Integer rushingTD, Integer passingYards, Integer rushingYards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passingTD = passingTD;
        this.rushingTD = rushingTD;
        this.passingYards = passingYards;
        this.rushingYards = rushingYards;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPassingTD() {
        return passingTD;
    }

    public void setPassingTD(Integer passingTD) {
        this.passingTD = passingTD;
    }

    public Integer getRushingTD() {
        return rushingTD;
    }

    public void setRushingTD(Integer rushingTD) {
        this.rushingTD = rushingTD;
    }

    public Integer getPassingYards() {
        return passingYards;
    }

    public void setPassingYards(Integer passingYards) {
        this.passingYards = passingYards;
    }

    public Integer getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(Integer rushingYards) {
        this.rushingYards = rushingYards;
    }

    
}
