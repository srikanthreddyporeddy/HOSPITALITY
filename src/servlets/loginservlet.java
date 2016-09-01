package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.userbean;
import dao.userlogindao;

public class loginservlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		userbean user=new userbean();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		userlogindao.userlogin(user);
		boolean loginstatus=user.isUserValid();
		if(loginstatus){
			
			HttpSession session=request.getSession(true);
			session.setAttribute("hospitalityuser", user);
			response.sendRedirect("userindex.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	}
}
