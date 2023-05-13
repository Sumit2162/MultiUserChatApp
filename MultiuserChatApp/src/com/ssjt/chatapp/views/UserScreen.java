package com.ssjt.chatapp.views;

import com.ssjt.chatapp.dao.UserDAO;
import com.ssjt.chatapp.dto.UserDTO;
import com.ssjt.chatapp.utils.UserInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class UserScreen extends JFrame {
	private JTextField useridtxt;
	Object o;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO = new UserDAO();
	private  void dologin(){
		String userid =useridtxt.getText();
		char []password = passwordField.getPassword();
		
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = " ";
			if(userDAO.isLogin(userDTO)) {
				message = " Welcome "+userid;
				UserInfo.USER_NAME=userid;
				JOptionPane.showMessageDialog(this,  message);
				setVisible(false);
				dispose();
				DashBoard dashboard = new DashBoard(message);
				dashboard.setVisible(true);
			}
			else {
				message = " Invalid Userid or Password";
			}
			//JOptionPane.showMessageDialog(this,  message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void register() {
		String userid =useridtxt.getText();
		char []password = passwordField.getPassword();
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
		int result=userDAO.add(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this,"Register Succussfully");
//			System.out.println("Record Added....");
		}
		else {
			JOptionPane.showMessageDialog(this,"Register fail");

//			System.out.println("Record Not Added");
		}
		}
		catch(ClassNotFoundException | SQLException ex) {
			System.out.println("DB Issue......");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("some generic exception raised..");
		}
		System.out.println("userid"+userid+"password"+password.toString());
	}

	
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(new Color(255, 128, 128));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(174, 10, 219, 104);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(240, 119, 244, 42);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel userlbl = new JLabel("User Id");
		userlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		userlbl.setBounds(93, 114, 139, 42);
		getContentPane().add(userlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		pwdlbl.setBounds(93, 166, 139, 42);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 170, 245, 42);
		getContentPane().add(passwordField);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dologin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(93, 231, 112, 40);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(259, 231, 118, 40);
		getContentPane().add(registerbt);
		setSize( 573, 391);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}