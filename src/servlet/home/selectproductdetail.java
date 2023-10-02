package servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CateDao;
import Service.ProductDao;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.PRODUCT;

/**
 * Servlet implementation class selectproduectdetail
 */
@WebServlet("/selectproductdetail")
public class selectproductdetail extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		String id=request.getParameter("id");
		PRODUCT p=null;
		if(id!=null) {
			p=ProductDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);
		}
		if(p!=null) {
			int fid=p.getPRODUCT_FID();
			ArrayList<PRODUCT> list=ProductDao.selectbyfid(fid);
			request.setAttribute("classlist", list);
		}
		
		//最近浏览的内容
		HttpSession session=request.getSession();
		//从session 获取ids
		ArrayList<Integer> ids= (ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids==null) {
			ids=new ArrayList<Integer>();
		}
		//ids最多放十个记录
		if(ids.size()>=10) {
			ids.remove(0);
		}
		
		//如果有重复记录则不放入ids中
		if(id!=null &&(!ids.contains(Integer.parseInt(id)))) {
			ids.add(Integer.parseInt(id));
		}
		
		session.setAttribute("ids", ids);
		ids=(ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids!=null) {
			ArrayList<PRODUCT> lastview =ProductDao.selectAllById(ids);
			request.setAttribute("lastview", lastview);
		}
		
		
		request.getRequestDispatcher("productview.jsp").forward(request, response);
	}

	

}
