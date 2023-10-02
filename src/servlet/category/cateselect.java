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
 * Servlet implementation class cateselect
 */
@WebServlet("/newmanage/admin_cateselect")
public class cateselect extends HttpServlet {
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> catelist=CateDao.selectALL();
		request.setAttribute("catelist", catelist);
		request.getRequestDispatcher("admin_cate.jsp").forward(request, response);
	}

	
}
