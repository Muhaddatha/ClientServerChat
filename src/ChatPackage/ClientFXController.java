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
    final static String SERVER_IP_ADDR = "127.0.0.1";
    final static int SERVER_PORT_NUM = 9080;
    
//    BufferedReader input = null;
//    BufferedReader keyboard = null;
//    PrintWriter out = null;
//    
    
    static String message = "";
//    private TextField textbox;
    @FXML
    private TextArea chatLog;
    
    
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
            chatLog.appendText("YOU: " + message + "\n");
            
            if(debugging){
                System.out.println("Message to send= " + message);
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException{
        Socket socket = null;
        if(debugging){
            System.out.println("Inside initialize method in the controller.");
        }
        try {
            // TODO
            socket = new Socket(SERVER_IP_ADDR, SERVER_PORT_NUM);
            if(debugging){System.out.println("Sucessfully connected to server");}
        } catch (IOException ex) {
            //Logger.getLogger(ClientFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BufferedReader input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
