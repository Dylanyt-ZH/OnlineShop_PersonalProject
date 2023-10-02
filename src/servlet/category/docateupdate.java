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
 * Servlet implementation class docateupdate
 */
@WebServlet("/newmanage/admin_docateupdate")
public class docateupdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int parentId =Integer.parseInt(request.getParameter("parentID"));
		String Catename=request.getParameter("Catename");
		
		CATEGORY cate=new CATEGORY(id,Catename,parentId);
		int count=CateDao.update(cate);
		
		
		if(count>0) {
			response.sendRedirect("admin_cateselect");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('分类修改失败');");
			out.write("location.herf='newmanage/admin_tocateupdate';");
			out.write("</script>");
		}
	}

}
