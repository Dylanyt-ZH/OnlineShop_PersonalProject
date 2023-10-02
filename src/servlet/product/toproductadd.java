package servlet.product;

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
 * Servlet implementation class toproductadd
 */
@WebServlet("/newmanage/admin_toproductadd")
public class toproductadd extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("admin_productadd.jsp").forward(request, response);
	}

	

}
