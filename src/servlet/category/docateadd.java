package servlet.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CateDao;
import onlineshop_enity.CATEGORY;

/**
 * Servlet implementation class docateadd
 */
@WebServlet("/newmanage/admin_docateadd")
public class docateadd extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");	
		int parentId =Integer.parseInt(request.getParameter("parentID"));
		String Catename=request.getParameter("Catename");
		
		CATEGORY cate=new CATEGORY(0,Catename,parentId);
		int count=CateDao.insert(cate);
		
		
		if(count>0) {
			response.sendRedirect("admin_cateselect");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败');");
			out.write("location.herf='newmanage/admin_tocateadd';");
			out.write("</script>");
		}
	}

}
