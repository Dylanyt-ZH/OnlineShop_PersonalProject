package servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CateDao;
import Service.ProductDao;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.PRODUCT;

/**
 * Servlet implementation class toproductupdate
 */
@WebServlet("/newmanage/admin_toproductupdate")
public class toproductupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toproductupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		PRODUCT product=ProductDao.selectById(id);
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("admin_productmodify.jsp").forward(request, response);
	}

	

}
