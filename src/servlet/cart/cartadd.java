package servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.CartDao;
import Service.ProductDao;
import onlineshop_enity.CART;
import onlineshop_enity.PRODUCT;
import onlineshop_enity.USER;

/**
 * Servlet implementation class cartadd
 */
@WebServlet("/cartadd")
public class cartadd extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PRODUCT p=null;
		String pid=request.getParameter("id");
		String count=request.getParameter("count");
		String url=request.getParameter("url");
		
		HttpSession session=request.getSession();
		
		String isLogin= (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null&& isLogin.equals("1")) {
			//此时用户已经登录
			String uid=(String)user.getUSER_ID();
			p=ProductDao.selectById(Integer.parseInt(pid));
			
			//判断购买量小于库存量
			if(!(p.getPRODUCT_STOCK()>Integer.parseInt(count))) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out =response.getWriter();
				
				out.write("<script>;");
				out.write("alert('库存不足，无法购买');");
				out.write("location.href='indexselect';");
				out.write("</script>");
				out.close();
			}
			else {
			//先判断用户所购买的商品在购物车中是否存在
			CART ori_product= CartDao.getCartShop(uid,pid);
			if(ori_product!=null) {
				int ori_num= ori_product.getCart_quantity();
				
				int newcount =ori_num+Integer.parseInt(count);
				if(newcount >5) {
					newcount=5;
				}
				
				
			
				
				CartDao.updatenum(ori_product.getCart_id(),newcount);
				
			}
			else {
			
			
				
				
				if(pid!=null) {
					p=ProductDao.selectById(Integer.parseInt(pid));
					
				}
				CART cart=new CART(
						0,
						p.getPRODUCT_PICTURE(),
						p.getPRODUCT_NAME(),
						p.getPRODUCT_PRICE(),
						Integer.parseInt(count),
						p.getPRODUCT_STOCK(),
						p.getPRODUCT_ID(),
						uid,
						1
						);
				
				CartDao.insert(cart);
				}
			}
				
			}else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out =response.getWriter();
				
				out.write("<script>");
				out.write("alert('请先登录');");
				out.write("location.herf='login.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
			
			if(url.equals("z")) {
				response.sendRedirect("showcart");
			}
			else {
				response.sendRedirect("selectproductdetail?id="+pid);
			}
		
	}

	

}
