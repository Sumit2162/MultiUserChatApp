package com.ssjt.chatapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ssjt.chatapp.dto.UserDTO;
import com.ssjt.chatapp.utils.Encryption;

public class UserDAO {
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, Exception {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try {
			con = CommonDAO.createconnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,userDTO.getUserid());
			String encryptedPwd = Encryption.passwordEncryt(new String(userDTO.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs= pstmt.executeQuery();
			return rs.next();

				}
		finally{
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
//    public add(String userid,String password,byte age,String city){
    	 public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException , Exception{
    		 System.out.println("Rec"+ userDTO.getUserid()+" "+userDTO.getPassword());
    		 Connection connection = null;
    		 Statement stmt =null;//Query
    		 try {//Guarded region
    		 connection =CommonDAO.createconnection();// step 1. connection create
    		 // we do a Query
    		 stmt = connection.createStatement();
//    		  insert into users (userid,password) values('sumit','sumit123');
    		int record=stmt.executeUpdate( "insert into users (userid,password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncryt(new String(userDTO.getPassword()))+"')");
    		return record;
}
    		 finally{//always execute(resourse clean)
    			 if(stmt!=null) {
    			 stmt.close();
    		 }
    			 if(connection!=null) {
    		connection.close();
    		 }
    		 }
//    		return 0;
     }
}
