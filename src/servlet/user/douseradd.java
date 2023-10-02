package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserDao;
import onlineshop_enity.USER;

/**
 * Servlet implementation class douseradd
 */
@WebServlet("/newmanage/admin_douseradd")
public class douseradd extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{}
	
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String username =request.getParameter("userName");
		String name=request.getParameter("Name");
		String password=request.getParameter("password");
		String sex =request.getParameter("sex"); 
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String sta =request.getParameter("status");
		int status=Integer.parseInt(sta);
		//创建用户实体
		USER u=new USER(username,name,password,sex,birthday,null,email,mobile,address,status);
		//加入到数据库的用户表中
		
		//System.out.print(u);
		int count=UserDao.insert(u);
		//成功或失败重定向到哪里
		if(count>0) {
			response.sendRedirect("admin_douserselect");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.herf='newmanage/admin_useradd.jsp';");
			out.write("</script>");
		}
		}
}

