package servlet.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CateDao;
import Service.OrderDao;
import Service.ProductDao;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.ORDER;
import onlineshop_enity.PRODUCT;
import onlineshop_enity.USER;

/**
 * Servlet implementation class personorderselect
 */
@WebServlet("/personorderselect")
public class personorderselect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		
		HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null&& isLogin.equals("1")) {
			//System.out.println(user.getUSER_ID());
			ArrayList <ORDER> list = OrderDao.selectbyuid(user.getUSER_ID());
			ArrayList<PRODUCT> productlist=ProductDao.selectALLbyid();
			request.setAttribute("order", list);
			request.setAttribute("product", productlist);
			request.getRequestDispatcher("myorder.jsp").forward(request, response);
			
		}
		else {
			
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('请先登录');");
			out.write("location.herf='login.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
	}

	

}
