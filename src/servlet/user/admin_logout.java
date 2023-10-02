package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admin_logout
 */
@WebServlet("/newmanage/admin_logout")
public class admin_logout extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("isLogin");
		session.removeAttribute("isAdminLogin");
		//response.sendRedirect("index.jsp");
		PrintWriter out =response.getWriter();
		out.write("<script>;");
		out.write("alert('管理员用户退出成功');");
		out.write("location.href='adminlogin.jsp';");
		out.write("</script>");
		out.close();
	}

	

}
