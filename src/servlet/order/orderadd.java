package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CartDao;
import Service.OrderDao;
import Service.ProductDao;
import onlineshop_enity.CART;
import onlineshop_enity.ORDER;
import onlineshop_enity.USER;

/**
 * Servlet implementation class orderadd
 */
@WebServlet("/orderadd")
public class orderadd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		
		String eids=request.getParameter("eids");
		String delivery=request.getParameter("delivery");
		
		
		
		if(user!=null&& isLogin.equals("1")) {
			
			String ids[] =eids.split(",");
			
			for(int i=0;i<ids.length;i++) {
				CART es=CartDao.GetCartOrder(ids[i]);
				int amount=es.getCart_quantity();
				ORDER order =new ORDER(
					0,
					es.getCart_p_id(),
					user.getUSER_ID(),
					null,
					amount,
					1,
					delivery,
					null
				);
				OrderDao.insert(order);

				//更新商品库存并且删除购物车记录(改变购物车状态)
				int stock=es.getCart_p_stock()-es.getCart_quantity();
				ProductDao.updatestock(es.getCart_p_id(),stock);

				CartDao.changestatus(Integer.parseInt(ids[i]));
			}
			
			request.getRequestDispatcher("ok.jsp").forward(request, response);
			
		}else {
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
