package servlet.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CateDao;
import onlineshop_enity.CATEGORY;

/**
 * Servlet implementation class tocateupdate
 */
@WebServlet("/newmanage/admin_tocateupdate")
public class tocateupdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		CATEGORY cate=CateDao.selectById(id);
		ArrayList<CATEGORY> catelist=CateDao.selectALL();
		request.setAttribute("catelist", catelist);
		request.setAttribute("cate1", cate);
		request.getRequestDispatcher("admin_catemodify.jsp").forward(request, response);
	}

	

}
