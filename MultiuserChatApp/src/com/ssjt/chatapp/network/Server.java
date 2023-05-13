package com.ssjt.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.ssjt.chatapp.utils.ConfigReader;

public class Server {
		ServerSocket serverSocket;
		ArrayList<ServerWorker> workers = new ArrayList<>();//contain all the client socket
		public Server() throws IOException {
			int PORT= Integer.parseInt(ConfigReader.getValue("PORTNO"));
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server Start and Waiting For The Clients to join.... ");
			//per client per thread
			handleClientRequest();
		}
		//multiple client handShaking
         	public void handleClientRequest() throws IOException {
         		while(true) {
    			Socket clientSocket = serverSocket.accept();
         		ServerWorker serverWorker= new ServerWorker(clientSocket,this);//create new thread
        		workers.add(serverWorker);
         		serverWorker.start();
         		}
         	}
		
		

	public static void main(String[] args) throws IOException { 
		// TODO Auto-generated method stub
		Server server = new Server();

	}

}
