package servlet.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.OrderDao;
import onlineshop_enity.USER;

/**
 * Servlet implementation class buyerrecive
 */
@WebServlet("/buyerrecive")
public class buyerrecive extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		String id=request.getParameter("id"); 
		if(user!=null&& isLogin.equals("1")) {
			int count=OrderDao.buyerrecive(id);
			if(count>0) {
			PrintWriter out =response.getWriter();
			out.write("<script>;");
			out.write("location.href='/OnlineShop/indexselect';");
			out.write("</script>");
			out.close();}
		}else {
			PrintWriter out =response.getWriter();
			out.write("<script>;");
			out.write("alert('用户名或密码输入错误，请检查后重新输入');");
			out.write("location.href='/OnlineShop/personorderselect';");
			out.write("</script>");
			out.close();
		}
	}

	

}
