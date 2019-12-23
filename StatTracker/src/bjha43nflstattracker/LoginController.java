/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bjha43nflstattracker;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Byron Hammann - bjha43
 */
public class LoginController extends Switchable implements Initializable {
    
   
    @FXML
    private Button loginButton;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private Label failure;
    
    @FXML
    private TextField userEntry;
    
    
    Integer userID;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameText;
    @FXML
    private TextField fNameText;
    @FXML
    private TextField lNameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField passwordText;
    @FXML
    private Button createButton;
    @FXML
    private Button deleteButton;
    
    protected Integer userNumber = 0;
    protected Integer pwNumber = null;
    private DBCreateUser create;
    private final String blank = "";
    private LoginUser login;
    
    @FXML
    private void loginAction(ActionEvent event) {
       
        if(verify()){
             userEntry.clear();
             passwordText.clear();
             
             Switchable.switchTo("MainPage");
        }else failure.setText("Invalid Username/Password");
        
        
    }
    
    @FXML
    private void exitAction(ActionEvent event){
        exit();
    }
    
    
    @FXML
    private void createAction(ActionEvent event){
        
        if(fNameText.getText().length() == 0)
        {
            failure.setText("First name cannot be blank");
        }
        if(lNameText.getText().length() == 0)
        {
            failure.setText("Last Name cannot be blank");
        }
        if(emailText.getText().length() == 0)
        {
            failure.setText("Email cannot be blank");
        }
        if(passwordText.getText().length() == 0)
        {
            failure.setText("Password cannot be blank");
        }
        if(usernameText.getText().length() == 0)
        {
            failure.setText("Username cannot be blank");
        }
        
        if(usernameText.getText().length()!= 0 && fNameText.getText().length()!= 0 && lNameText.getText().length()!= 0 && emailText.getText().length()!= 0 && passwordText.getText().length()!= 0){
            create = new DBCreateUser(fNameText.getText(), lNameText.getText(), emailText.getText(), passwordText.getText(), usernameText.getText());   
            usernameText.setText(blank);
            fNameText.setText(blank);
            lNameText.setText(blank);
            emailText.setText(blank);
            passwordText.setText(blank);
            failure.setText(blank);
        }

        
    }
    
    @FXML
    private void deleteAction(ActionEvent event){
        
        if(verify()){
           
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Confirm Deletion");
            alert.setContentText("Are you sure you want to delete your account?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get().equals(ButtonType.OK)){
                DBDeleteUser delete = new DBDeleteUser(userNumber);
            }
            
        }
            
        
    }
    
    private boolean verify(){     
                
        if(userEntry.getText().isEmpty() || passwordField.getText().isEmpty())
        {
            failure.setText("Invalid or Password");
        }else if(!userEntry.getText().isEmpty() && !passwordField.getText().isEmpty())
        {
       
            login = new LoginUser(userEntry.getText());
            userNumber = login.getUserID();
           
            login.setStatement(passwordField.getText());
            pwNumber = login.getUserID();
           
        }
        if(pwNumber.equals(userNumber) && !userNumber.equals(0))
        {
            return true;
            
        }else return false;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
