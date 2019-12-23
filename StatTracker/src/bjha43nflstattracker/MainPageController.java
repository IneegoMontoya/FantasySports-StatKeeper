/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

/**
 *
 * @author Byron Hammann - bjha43
 */
public class MainPageController extends Switchable implements Initializable {
    
      
    @FXML
    private TableView<QbStats> table;
    @FXML
    private Label errorLabel;
    
    @FXML
    private TextField statText;
    
    @FXML
    private ChoiceBox<String> positionOption  = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> yearOption  = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> playerName  = new ChoiceBox<>();
    @FXML
    private ChoiceBox<Integer> yearChoice  = new ChoiceBox<>();
    @FXML
    private ChoiceBox<String> statChoice  = new ChoiceBox<>();

    
    
    @FXML
    private TableColumn<QbStats, String> col_fname;
    @FXML
    private TableColumn<QbStats, String> col_lname;
    @FXML
    private TableColumn<QbStats, Integer> col_3;
    @FXML
    private TableColumn<QbStats, Integer> col_4;
    @FXML
    private TableColumn<QbStats, Integer> col_5;
    @FXML
    private TableColumn<QbStats, Integer> col_6;
    
    private ObservableList<QbStats> qbStatList = FXCollections.observableArrayList();
  
    private ArrayList<String> players = new ArrayList<>();
    private ArrayList<Player> player = new ArrayList<>();
    private Player plays;
    private Integer DBStat;
    private Integer userInput;
    private String startingValue = "";
    
    @FXML
    private Button updateButton;
    @FXML
    private Button filterButton;
    
    @FXML
    private void filterAction(ActionEvent event){
        
        table.getItems().clear();
        qbStatList.clear();
        if(positionOption.getValue().equals("QB")){
            col_4.textProperty().set("Passing TD");
            col_3.textProperty().set("Passing Yards");
            if(yearOption.getValue().equals("Career")){
                try{
                    DBQBData qb = new DBQBData();
                    ResultSet set = qb.getResults();
                    while(set.next()) {
                        qbStatList.add(new QbStats(set.getString("p.fname"),
                            set.getString("p.lname"),
                            set.getInt("Passing_TD"),
                            set.getInt("Rushing_TD"),
                            set.getInt("Passing_Yards"),
                            set.getInt("Rushing_yards")));
                    }
                    set.close();
                    qb.closer();
                }catch(Exception ex){
                    System.out.println("Error");
                }           
        }else{
            try{
            DBQBYearStats qb = new DBQBYearStats(yearOption.getValue().toString());    
            ResultSet set = qb.getResults();
            while(set.next()) {
                qbStatList.add(new QbStats(set.getString("p.fname"),
                        set.getString("p.lname"),
                        set.getInt("Passing_TD"),
                        set.getInt("Rushing_TD"),
                        set.getInt("Passing_Yards"),
                        set.getInt("Rushing_yards")));
            }
            set.close();
            qb.closer();
        }catch(Exception ex){
            System.out.println("Error");
        }}}           
        if(positionOption.getValue().equals("Skill")){
            col_4.textProperty().set("Receiving TD");
            col_3.textProperty().set("Receiving Yards");
           if(yearOption.getValue().equals("Career")){
                try{
                    DBSkillData qb = new DBSkillData();
                    ResultSet set = qb.getResults();
                    while(set.next()) {
                        qbStatList.add(new QbStats(set.getString("p.fname"),
                            set.getString("p.lname"),
                            set.getInt("Passing_TD"),
                            set.getInt("Rushing_TD"),
                            set.getInt("Passing_Yards"),
                            set.getInt("Rushing_yards")));
                    }
                    set.close();
                    qb.closer();
                }catch(Exception ex){
                    System.out.println("Error");
                }           
        }else{
            try{
            DBSkillYearStats qb = new DBSkillYearStats(yearOption.getValue().toString());    
            ResultSet set = qb.getResults();
            while(set.next()) {
                qbStatList.add(new QbStats(set.getString("p.fname"),
                        set.getString("p.lname"),
                        set.getInt("Passing_TD"),
                        set.getInt("Rushing_TD"),
                        set.getInt("Passing_Yards"),
                        set.getInt("Rushing_yards")));
            }
            set.close();
            qb.closer();
        }catch(Exception ex){
            System.out.println("Error");
        }}} 
        
                
    }
    
    
    @FXML
    private void updateAction(ActionEvent event){
        
        errorLabel.setText(startingValue);
        int x;
        int playerID;
        

            x = players.indexOf(playerName.getValue().toString());
            players.get(x);
            playerID = player.get(x).getPlayerID();
        
               try{ 
            StatValue getStat = new StatValue(statChoice.getValue().toString(),playerID,yearChoice.getValue());
            ResultSet statResult = getStat.getResults();
            
                if(statResult.next()==false){
                    DBStat = 0;
                }
                else {
                    do{
                                   
                    DBStat = statResult.getInt("stat_value");
                        }while(statResult.next());
                
                    }
                    
                }catch(SQLException ex){
                   errorLabel.setText("Error! Please make valid selections before updating stats.");
                }
            try{   
             userInput = Integer.parseInt(statText.getText());
             statText.setText("0");
            }catch(Exception ex){
                errorLabel.setText("Non-Numeric input is not allowed");
                statText.setText("0");
            }        
   
                
            userInput += DBStat;
            
            if(DBStat.equals(0)){
                
                DBCreateStat createStat = new DBCreateStat(statChoice.getValue(), userInput, yearChoice.getValue(), playerID);      
            }else{
                DBUpdateStat updateStat = new DBUpdateStat(statChoice.getValue(), userInput, yearChoice.getValue(), playerID);
            }
                
            statText.setText("0");
            
            
    }
    
    @FXML
    private void exitAction(ActionEvent event){
        exit();
    }
    
    @FXML
    private void logoutAction(ActionEvent event){
        Switchable.switchTo("LoginScene");
    }
    
    @FXML
    private void aboutAction(ActionEvent event){
        
        
           
        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                            "This application was developed and written by Byron Hammann as a means of tracking sports statistics \n "
                                    + "The idea is to be able to add this application into a fantasy sports application in the future.",
                            ButtonType.OK);
        alert.setTitle("About");
        alert.setHeaderText("NFL Stat Tracker");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        
        alert.show();    
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        yearOption.getItems().addAll("Career", "2018", "2017", "2016", "2015" );
        positionOption.getItems().addAll("QB", "Skill");
        yearOption.setValue("2018");
        positionOption.setValue("QB");
        
        
        DBQBYearStats qb = new DBQBYearStats(yearOption.getValue().toString());
        PlayerNames play = new PlayerNames();
        
        try{
            ResultSet set = qb.getResults();
            while(set.next()) {
                qbStatList.add(new QbStats(set.getString("p.fname"),
                        set.getString("p.lname"),
                        set.getInt("Passing_TD"),
                        set.getInt("Rushing_TD"),
                        set.getInt("Passing_Yards"),
                        set.getInt("Rushing_yards")));
            }
            set.close();
            qb.closer();
        }catch(Exception ex){
            System.out.println("Error");
        }
        
        try{
        ResultSet rs = play.getResults();
        while(rs.next()){
            plays = new Player(rs.getInt("playerid"), rs.getString("fname"), rs.getString("lname"));
            player.add(plays);
            players.add(plays.getName());
        }
            rs.close();
            play.closer();
            
        }catch(Exception ex){
            System.out.println("Error loading Names");
        }
        playerName.getItems().addAll(players);
       
        
        yearChoice.getItems().addAll(2015,2016,2017,2018);
        statChoice.getItems().addAll("Passing_Yards", "Passing_TD", "Rushing_Yards", "Rushing_TD", "Receiving_Yards", "Receiving_TD");
        
        col_fname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_lname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_3.setCellValueFactory(new PropertyValueFactory<>("passingYards"));
        col_4.setCellValueFactory(new PropertyValueFactory<>("passingTD"));
        col_5.setCellValueFactory(new PropertyValueFactory<>("rushingYards"));
        col_6.setCellValueFactory(new PropertyValueFactory<>("rushingTD"));
        
        table.setItems(qbStatList);
        
        
    }
    
}
