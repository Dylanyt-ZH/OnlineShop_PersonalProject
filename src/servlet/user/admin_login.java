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
 * Servlet implementation class admin_login
 */
//后台登录
@WebServlet("/newmanage/adminlogin")
public class admin_login extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String username =request.getParameter("userName");
		String password=request.getParameter("passWord");
		
		int count=UserDao.selectByNP(username,password);
		
		if(count>0) {
			
			USER user=UserDao.Getsimple(username,password);
			HttpSession session=request.getSession();
			session.setAttribute("name", user);
			session.setAttribute("isLogin", "1");
			if(user.getUSER_STATUS()==2) {
				session.setAttribute("isAdminLogin", "1");
				response.sendRedirect("admin_index.jsp");
			}else {
				response.sendRedirect("/OnlineShop/indexselect");
			}
			
			
		}
		else {
			PrintWriter out =response.getWriter();
			out.write("<script>;");
			out.write("alert('用户名或密码输入错误，请检查后重新输入');");
			out.write("location.href='/OnlineShop/newmanage/adminlogin.jsp';");
			out.write("</script>");
			out.close();
		}
	}

}
