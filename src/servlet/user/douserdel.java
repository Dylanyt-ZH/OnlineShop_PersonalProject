package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserDao;

/**
 * Servlet implementation class douserdel
 */
@WebServlet("/newmanage/admin_douserdel")
public class douserdel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String id =request.getParameter("id");
		
		int count=UserDao.del(id);
		
		if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
		}
		else {
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败')");
			out.write("location.herf='admin_douserselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String ids[] =request.getParameterValues("id[]");
		
		for(int i=0;i<ids.length;i++) {
			int count=UserDao.del(ids[i]);
			
			if(count==0) {
				PrintWriter out =response.getWriter();
				out.write("<script>");
				out.write("alert('用户删除失败')");
				out.write("location.herf='/OnlineShop/newmanage/admin_douserselect'");
				out.write("</script>");
			}

		}
			
		
		
		response.sendRedirect("/OnlineShop/newmanage/admin_douserselect");
		
		
	}
}
