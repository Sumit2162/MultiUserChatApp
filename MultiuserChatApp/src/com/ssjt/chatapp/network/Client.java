package com.ssjt.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.ssjt.chatapp.utils.ConfigReader;
public class Client {
	Socket socket;
	InputStream in;
	OutputStream out;
	ClientWorker worker;
	JTextArea textArea;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT =Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		readMessage();

	}
	public void sendMessage(String message) throws IOException {
		message = message +"\n";
		out.write(message.getBytes());
	}
	public void readMessage() {
		worker = new ClientWorker(in, textArea);
		worker.start();
	}


}