package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.userbean;
import dao.userregisterdao;

public class registerservlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		userbean user=new userbean();
		user.setFirstname(request.getParameter("firstname"));
		user.setLastname(request.getParameter("lastname"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setPhonenumber(request.getParameter("phonenumber"));
		user.setCountry(request.getParameter("country"));
		userregisterdao.userregister(user);
		boolean req=user.isUserValid();
		if(req==true){
			response.sendRedirect("login.jsp");
		}
		else{
			response.sendRedirect("register.jsp");
		}
		
		
		
		
		
	}

}
