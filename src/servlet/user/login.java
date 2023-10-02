package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserDao;
import onlineshop_enity.USER;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String username =request.getParameter("username");
		String password=request.getParameter("password");
		
		int count=UserDao.selectByNP(username,password);
		
		if(count>0) {
			HttpSession session=request.getSession();
			USER user=UserDao.Getsimple(username,password);
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			response.sendRedirect("indexselect");
		}
		else {
			PrintWriter out =response.getWriter();
			out.write("<script>;");
			out.write("alert('用户名或密码输入错误，请检查后重新输入');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
