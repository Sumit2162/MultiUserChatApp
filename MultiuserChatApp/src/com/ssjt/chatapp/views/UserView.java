package com.ssjt.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame {
	int counter;
	public UserView() {
		  counter =0;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,450);
		setTitle("login");
		setResizable(false);
		setLocationRelativeTo(null);
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,45));
		Container container = this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(150, 70, 200, 80);
		container.add(welcome);
		JButton button = new JButton("SSJT");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				welcome.setText("Count"+counter);
			}
		});
	    button.setBounds(100, 250, 250, 40);
		container.add(button);
		setVisible(true);
	}
    public static void main(String[] args) {
		UserView userView = new UserView();
	}
}
