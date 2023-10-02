package servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserDao;
import onlineshop_enity.USER;

/**
 * Servlet implementation class touserupdate
 */
@WebServlet("/newmanage/admin_touserupdate")
public class touserupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id=request.getParameter("id");
		
		//通过ID查找用户
		USER u= UserDao.selectByID(id);
		
		request.setAttribute("user", u);
		request.setAttribute("cpage", request.getParameter("cpage"));
		//获取参数后重定向至用户更新界面
		request.getRequestDispatcher("admin_usermodify.jsp").forward(request, response);
	}

	

}
