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
 * Servlet implementation class indexselect
 */
@WebServlet("/indexselect")
public class indexselect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首页分类信息
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		//首页商品信息
		ArrayList<PRODUCT> pro=ProductDao.selectALLbyid();
		ArrayList<PRODUCT> pro1=new ArrayList<PRODUCT>();
		ArrayList<PRODUCT> pro2=new ArrayList<PRODUCT>();
		for(int i=0;i<4;i++) {
			PRODUCT p=pro.get(i);
			pro1.add(p);
		}
		for(int i=4;i<8;i++) {
			PRODUCT p=pro.get(i);
			pro2.add(p);
		}
		request.setAttribute("pro1", pro1);
		request.setAttribute("pro2", pro2);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
}
