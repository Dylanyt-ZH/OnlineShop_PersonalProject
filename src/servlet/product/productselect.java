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
import Service.UserDao;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.PRODUCT;

/**
 * Servlet implementation class productselect
 */
@WebServlet("/newmanage/admin_productselect")
public class productselect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage=1;//当前页变量
		int count=5;//每一页显示多少数据
		//获取用户指定页面
		String cp=request.getParameter("cp");
				
		//接收用户搜索的关键字
		String keyword =request.getParameter("keywords");		
		if (cp!=null) {
			cpage=Integer.parseInt(cp);
			}
		int arr[]=ProductDao.totalpage(count,keyword);//从用户dao层获取总页面数
		ArrayList<PRODUCT> productlist=ProductDao.selectALL(cpage,count,keyword);
		ArrayList<CATEGORY> catelist=CateDao.selectALL();
		request.setAttribute("catelist", catelist);
		request.setAttribute("plist", productlist);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", cpage);
		if(keyword!=null) {
			request.setAttribute("SearchParams", "&keywords="+keyword);
		}
		request.getRequestDispatcher("admin_product.jsp").forward(request, response);
	}

	

}
