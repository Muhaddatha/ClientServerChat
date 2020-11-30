/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatPackage;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 3pear
 */
public class ClientFXController implements Initializable, Runnable {

//    private TextArea textArea;
//    @FXML
    @FXML
    private TextField textField;
    @FXML
    private Button sendButton;

    /**
     * Initializes the controller class.
     */
    
    static boolean debugging = true;
    
    //variables needed to connect to the server
    
    
//    BufferedReader input = null;
//    BufferedReader keyboard = null;
//    PrintWriter out = null;
//    
    
    static String message = "";
//    private TextField textbox;
    @FXML
    private TextArea chatLog;
    
//    static BufferedReader input;
//    static BufferedReader keyboard;
//    static PrintWriter out;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton(ActionEvent event) {
        
        if("".equals(textField.getText())){
            
            if(debugging){
                System.out.println("Error: empty message cannot be sent");
            }
            
            textField.setPromptText("Error: Please enter a message to send.");
            
        }
        else{
            message = textField.getText();
            textField.clear();
//            chatLog.setText("YOU: ");
            chatLog.appendText("\n" + message);
            
            if(debugging){
                System.out.println("Message to send= " + message);
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        System.out.println("Inside main in controller");
        
    }
    
    

    @Override
    public void run() {
        
        try{
            while(true){
            
            //String msg = input.readLine();
            System.out.println("Incoming message: " );
            //append to text area
           
            }   
        }
        //input.close();
            //out.close();
            //socket.close();
        
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
