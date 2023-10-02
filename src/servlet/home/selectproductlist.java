package servlet.home;

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
 * Servlet implementation class selectproductlist
 */
@WebServlet("/selectproductlist")
public class selectproductlist extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		String fid=request.getParameter("fid");
		String cid=request.getParameter("cid");
		int id=0;
		ArrayList<PRODUCT> list=null;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			request.setAttribute("ftitle",CateDao.selectById(id).getCATE_NAME());
			list=ProductDao.selectbyfid(id);
			
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			request.setAttribute("ctitle",CateDao.selectById(id).getCATE_NAME());
			int fatherid=CateDao.selectById(id).getCATE_PARENT_NAME();
			String fathername=CateDao.selectById(fatherid).getCATE_NAME();
			request.setAttribute("ftitle",fathername);
			list=ProductDao.selectbycid(id);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	}

	

}
