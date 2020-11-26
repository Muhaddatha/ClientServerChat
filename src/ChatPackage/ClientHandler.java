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
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
//will handle each client
public class ClientHandler implements Runnable{

    boolean debugging = true;
    private Socket client;
    private static BufferedReader in;
    private static PrintWriter out;
    private ArrayList<ClientHandler> clients;
    
    //new sockets created in the server class are handled here
    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException{
        this.client = clientSocket;
        this.clients = clients;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        
    }
    //abstract method from runnable interface
    @Override
    public void run() {
        
        String request = null;
        
        try {
             
            while(true){
                request = in.readLine();
                if(debugging){
                    System.out.println("Message sent by client: " + request);
                }
            }
        } catch(IOException e){
            System.err.println("IOException from ClientHandeler");
            System.err.println(e.getStackTrace());
            
            //send message to other client
            broadcast(request);
        }
            finally{
            //closing input and output streams
            out.close();
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void broadcast(String msg) {
        for(ClientHandler aClient : clients ){
            //send message to the client
            aClient.out.println(msg);
        }
    }
    
}
