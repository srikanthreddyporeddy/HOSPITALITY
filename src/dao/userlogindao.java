package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Beans.userbean;

public class userlogindao {
	
	public static userbean userlogin(userbean user){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hospitality","hospitality");
			PreparedStatement pstmt=conn.prepareStatement("select * from hospitalityuser where username=? and password=?");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs=pstmt.executeQuery();
			boolean req=rs.next();
			System.out.println(req);
			if(req){
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setCountry(rs.getString("country"));
				user.setUserValid(true);
			}else{
				user.setUserValid(false);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		return user;
		
	}

}
