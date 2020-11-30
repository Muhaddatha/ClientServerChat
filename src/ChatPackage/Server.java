/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3pear
 */
public class Server {
    
    
    private static final int PORT_NUM = 9070;
    static String serverTyping = ">Server: ";
    String client1Typeing = ">Client1: ";
    String client2Typeing = ">Client2: ";
    
    
    //stores cleint threads in an arraylist
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService p = Executors.newFixedThreadPool(2); //only handle two clients
    
    public static void main(String[] args) throws IOException{
        
        boolean debugging = true;
     
        
        //returns socket object , need to close socket afterwards
        //telling the server where the messages will be coming from
        ServerSocket listener = new ServerSocket(PORT_NUM);
        while(true){
            System.out.println(serverTyping + "Waiting for client to connect");
            Socket client = listener.accept();
            System.out.println(serverTyping + "Connected to client");
            ClientHandler clientThread = new ClientHandler(client, clients); //passing client socket
            clients.add(clientThread); //new client added to client thread collection
            
            p.execute(clientThread);
        }
        
        //listen to connections in a loop
        
        
        
        
 
    }
    
}
