/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3pear
 */
public class Server {
    
    
    private static final int PORT_NUM = 9090;
    static String serverTyping = ">Server: ";
    String client1Typeing = ">Client1: ";
    String client2Typeing = ">Client2: ";
    
    
    
    public static void main(String[] args) throws IOException{
     
        ServerSocket connListener = null;
        
        try {
            System.out.println(serverTyping + "Getting ready to establish connection...");
            connListener = new ServerSocket(PORT_NUM);
            //telling the server where the messages will be coming from
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //make connection
        Socket client = connListener.accept(); //returns socket object , need to close socket afterwards
        System.out.println(serverTyping + "Connection established with client");
                

        
        
        
        
        
        
        
        client.close();
        connListener.close();
        
    }
    
}
