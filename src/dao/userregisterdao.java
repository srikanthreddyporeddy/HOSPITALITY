package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.userbean;

public class userregisterdao {
	
	public static userbean userregister(userbean user){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hospitality","hospitality");
			
			PreparedStatement pstmt1=conn.prepareStatement("select * from hospitalityuser");
			ResultSet rs=pstmt1.executeQuery();
			 boolean req=rs.next();
			 System.out.println(req);
			String username=rs.getString("username");
			System.out.println(username);
			if(username.equals(user.getUsername())){
				
				user.setUserValid(false);	
			}
			else{
			user.setUserValid(true);
			PreparedStatement pstmt=conn.prepareStatement("insert into hospitalityuser (firstname,lastname,username,password,email,phonenumber,country) values (?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhonenumber());
			pstmt.setString(7, user.getCountry());
			int k=pstmt.executeUpdate();
			System.out.println(k);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
		return user;
		
	}

}
