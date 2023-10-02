package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserDao;

/**
 * Servlet implementation class usernamecheck
 */
@WebServlet("/usernamecheck")
public class usernamecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String username =request.getParameter("username");
		//System.out.println(username);
		int count=UserDao.selectByname(username);
		//System.out.println(count);
		PrintWriter out=response.getWriter();
		if(count>0) {
			out.print("false");
		}else {
			out.print("true");
		}
		//out.print(flag);
		out.close();
		
	}

	

}
