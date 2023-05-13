package com.ssjt.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ssjt.chatapp.network.Client;
import com.ssjt.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea ;
	private Client client ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					try {
						ClientChatScreen frame = new ClientChatScreen();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}
	private void sendIt() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+" - "+ message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		setFont(new Font("Dialog", Font.BOLD, 10));
		setTitle(" Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 6, 624, 265);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 128, 192));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(15, 309, 444, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendit = new JButton("Send Message");
		sendit.setBackground(new Color(128, 128, 64));
		sendit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendit.setFont(new Font("Tahoma", Font.BOLD, 10));
		sendit.setBounds(510, 317, 112, 28);
		contentPane.add(sendit);
		textArea= new JTextArea();
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		client= new Client(textArea);
		
		
		textArea.setFont(new Font("Monospaced", Font.ITALIC, 16));
		//		contentPane.add(textArea);
		//		textArea.setLineWrap(true);
				textArea.setBounds(15, 7, 624, 264);
		setVisible(true);
	}
	
}
