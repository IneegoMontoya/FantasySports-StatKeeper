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
 * As I wanted to do a complete spectrum of fantasy sports, but realized rather quickly that it would be a monumentous undertaking 
 * I decided to focus on just football for now, and will be able to use the framework to expand upon this project later.
 * It is my hope that this can be recoginzed, and not that I have not turned in a complete application.
 */
public class SkillStats {
    
    protected String firstName;
    protected String lastName;

    protected Integer receivingTD;
    protected Integer rushingTD;
    protected Integer receivingYards;
    protected Integer rushingYards;

    public SkillStats(String firstName, String lastName, Integer receivingTD, Integer rushingTD, Integer receivingYards, Integer rushingYards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.receivingTD = receivingTD;
        this.rushingTD = rushingTD;
        this.receivingYards = receivingYards;
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

    public Integer getReceivingTD() {
        return receivingTD;
    }

    public void setReceivingTD(Integer receivingTD) {
        this.receivingTD = receivingTD;
    }

    public Integer getRushingTD() {
        return rushingTD;
    }

    public void setRushingTD(Integer rushingTD) {
        this.rushingTD = rushingTD;
    }

    public Integer getReceivingYards() {
        return receivingYards;
    }

    public void setReceivingYards(Integer receivingYards) {
        this.receivingYards = receivingYards;
    }

    public Integer getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(Integer rushingYards) {
        this.rushingYards = rushingYards;
    }

    
    
}
