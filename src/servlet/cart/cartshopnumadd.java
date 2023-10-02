package servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.CartDao;

/**
 * Servlet implementation class cartshopnumadd
 */
@WebServlet("/cartshopnumadd")
public class cartshopnumadd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String count=request.getParameter("count");
		String esid=request.getParameter("esid");
		
		CartDao.updatenum(Integer.parseInt(esid), Integer.parseInt(count));
		 
	}

	

}
