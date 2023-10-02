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
import Service.CateDao;
import onlineshop_enity.CART;
import onlineshop_enity.CATEGORY;
import onlineshop_enity.USER;

/**
 * Servlet implementation class showcart
 */
@WebServlet("/showcart")
public class showcart extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		ArrayList<CATEGORY> fcatelist=CateDao.selectCate("father");
		request.setAttribute("flist", fcatelist);
		ArrayList<CATEGORY> clist=CateDao.selectCate("child");
		request.setAttribute("clist", clist);
		HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null&& isLogin.equals("1")) {
			String uid=(String)user.getUSER_ID();
			
			ArrayList<CART> list =CartDao.getCart(uid);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		
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
