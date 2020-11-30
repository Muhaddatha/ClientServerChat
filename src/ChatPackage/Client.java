/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatPackage;

import static ChatPackage.ClientFXController.debugging;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 3pear
 */
public class Client extends Application {
    
    static BufferedReader input;
    static BufferedReader keyboard;
    static PrintWriter out;
    static Socket socket;
    final static String SERVER_IP_ADDR = "127.0.0.1";
    final static int SERVER_PORT_NUM = 9070;

    @Override
    public void start(Stage stage) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Parent root = FXMLLoader.load(getClass().getResource("ClientFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Chat");
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    
    public static void main(String[] args)throws IOException{
        System.out.println("Inside main for Client.");
       
            // TODO
        socket = new Socket(SERVER_IP_ADDR, SERVER_PORT_NUM);
        System.out.println("Successfully connected to server.");
        
        
        input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(socket.getOutputStream(), true);
        
        
        launch(args);
    }
}
