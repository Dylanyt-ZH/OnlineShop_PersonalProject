package servlet.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.OrderDao;
import Service.UserDao;
import onlineshop_enity.ORDER;
import onlineshop_enity.USER;

/**
 * Servlet implementation class admin_toorderupdate
 */
@WebServlet("/newmanage/admin_toorderupdate")
public class admin_toorderupdate extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		
		//通过ID查找用户
		ORDER order =OrderDao.selectbyid(id);
		
		request.setAttribute("order", order);
		request.setAttribute("cpage", request.getParameter("cpage"));
		//获取参数后重定向至用户更新界面
		request.getRequestDispatcher("admin_ordermodify.jsp").forward(request, response);
	}

	

}
