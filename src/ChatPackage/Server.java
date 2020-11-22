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
    
    
    private static final int PORT_NUM = 9080;
    static String serverTyping = ">Server: ";
    String client1Typeing = ">Client1: ";
    String client2Typeing = ">Client2: ";
    
    
    
    
    public static void main(String[] args) throws IOException{
        
        boolean debugging = true;
     
        ServerSocket connListener = null;
        Socket client = null;
        
        try {
            System.out.println(serverTyping + "Getting ready to establish connection...");
            connListener = new ServerSocket(PORT_NUM);
            client = connListener.accept(); //returns socket object , need to close socket afterwards
            //telling the server where the messages will be coming from
            
            if(debugging){
                if(connListener == null){
                    System.out.println("Connection listener is null.");
                }
                else{
                    System.out.println("Connection listener is not null.");
                }
                
                if(client == null){
                    System.out.println("Client is null");
                }
                else{
                    System.out.println("Client is not null");
                }
            }
        } catch (IOException ex) {
            System.out.println(serverTyping + "Encountered error establishing connection with client.");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //make connection
        
//        System.out.println(serverTyping + "Connection established with client");
                

        
        
        
        
        
        
        
//        client.close();
//        connListener.close();
        
    }
    
}
