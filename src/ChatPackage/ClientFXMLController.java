/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatPackage;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * 
 */
public class ClientFXMLController implements Initializable {

    @FXML
    private Button sendButton;
    @FXML
    private TextField inputTextbox;

    static boolean debugging = true;
    /**
     * Initializes the controller class.
     */
    
    
    
    
    static String message = "";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
        
    @FXML
    private void handleButton(ActionEvent event) {
        //1. Check to see if there is a message fto send
        if("".equals(inputTextbox.getText())){
            //The input textfield is empty, so display error
            if(debugging){
                System.out.println("Error: Empty message cannot be sent");
            }
            inputTextbox.setPromptText("Error: Please enter a message to send.");
            //make the error message text red.
        }
        else{
            //send message to server
            message = inputTextbox.getText();
            inputTextbox.clear();
            if(debugging){
                System.out.println("Sending message (" + message + ") to server");
            }
            
        
        }
    }
    
    
    
    
    
    
}
