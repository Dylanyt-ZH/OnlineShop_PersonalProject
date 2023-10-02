package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.ProductDao;
import Service.UserDao;

/**
 * Servlet implementation class doproductdel
 */
@WebServlet("/newmanage/admin_doproductdel")
public class doproductdel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String id =request.getParameter("id");
		
		int count=ProductDao.del(id);
		
		if(count>0) {
			response.sendRedirect("admin_productselect?cp="+request.getParameter("cpage"));
		}
		else {
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('商品删除失败')");
			out.write("location.herf='admin_productselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
		}
	}
		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		String ids[] =request.getParameterValues("id[]");
		
		for(int i=0;i<ids.length;i++) {
			int count=ProductDao.del(ids[i]);
			
			if(count==0) {
				PrintWriter out =response.getWriter();
				out.write("<script>");
				out.write("alert('商品删除失败')");
				out.write("location.herf='/OnlineShop/newmanage/admin_productselect'");
				out.write("</script>");
			}

		}
			
		
		
		response.sendRedirect("/OnlineShop/newmanage/admin_productselect");
	}

}
