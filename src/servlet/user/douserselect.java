package servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserDao;
import onlineshop_enity.USER;

/**
 * Servlet implementation class douserselect
 */
@WebServlet("/newmanage/admin_douserselect")
public class douserselect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//获取所有用户记录
		int cpage=1;//当前页变量
		int count=5;//每一页显示多少数据
		
		//获取用户指定页面
		String cp=request.getParameter("cp");
		
		//接收用户搜索的关键字
		String keyword =request.getParameter("keywords");
		
		if (cp!=null) {
			cpage=Integer.parseInt(cp);
			}
		int arr[]=UserDao.totalpage(count,keyword);//从用户dao层获取总页面数
		
		ArrayList<USER> list=UserDao.selectALL(cpage,count,keyword);
		//将对象放到JSP中
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("userlist",list);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("cpage", cpage);

		if(keyword!=null) {
			request.setAttribute("SearchParams", "&keywords="+keyword);
		}
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
		
		
		
	}


}
