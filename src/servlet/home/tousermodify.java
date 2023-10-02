package servlet.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onlineshop_enity.USER;

/**
 * Servlet implementation class tousermodify
 */
@WebServlet("/tousermodify")
public class tousermodify extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null&& isLogin.equals("1")) {
			request.setAttribute("name", user);
			request.getRequestDispatcher("usermodify.jsp").forward(request, response);
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
