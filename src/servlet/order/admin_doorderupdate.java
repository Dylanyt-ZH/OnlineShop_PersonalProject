package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.OrderDao;

/**
 * Servlet implementation class admin_doorderupdate
 */
@WebServlet("/newmanage/admin_doorderupdate")
public class admin_doorderupdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id =request.getParameter("orderid");
		String num =request.getParameter("delivery_num");
		int count =OrderDao.adddeliverynum(id,num);
//		System.out.println(id+"++++"+count+"+++++"+num);
		if(count>0) {
			response.sendRedirect("admin_orderselect?cp="+request.getParameter("cpage"));
		}
		else {
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('快递号添加失败');");
			out.write("location.herf='newmanage/admin_toorderupdate?id="+id+"'");
			out.write("</script>");
		}
		}
	}

	


