package servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CartDao;
import onlineshop_enity.CART;
import onlineshop_enity.USER;

/**
 * Servlet implementation class OrderSelect
 */
@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		String eids=request.getParameter("eids");
		//System.out.println(eids);
		
		if(user!=null&& isLogin.equals("1")) {
			float totalprice=0;
			String ids[]=eids.split(",");
			
			ArrayList<CART> list=new ArrayList<CART>();
			
			for(int i=0;i<ids.length;i++) {
				CART es=CartDao.GetCartOrder(ids[i]);
				float dprice=es.getCart_price()*es.getCart_quantity();
				totalprice=totalprice+dprice;
				
				list.add(es);
				
			}
			request.setAttribute("shoplist", list);
			request.setAttribute("totalprice", totalprice);
			request.setAttribute("eids", eids);
			request.getRequestDispatcher("order.jsp").forward(request, response);
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
