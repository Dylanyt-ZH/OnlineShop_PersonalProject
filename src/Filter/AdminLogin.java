package Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLogin
 */
@WebFilter("/newmanage/*")
//后台管理界面过滤器，防止不经过登录直接查看后台管理页面
public class AdminLogin implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");	
		HttpSession session=req.getSession();
		
		String flag=(String)session.getAttribute("isAdminLogin");
		
		//System.out.println("已被拦截");
		String request_uri=req.getRequestURI();
		String ctxpath=req.getContextPath();
		String uri=request_uri.substring(ctxpath.length());
		
		if(uri.contains("admin_")) {//判断要过滤的页面是否为后端页面
			if(flag!=null && flag.equals("1")) {
				chain.doFilter(request, response);
			}
			else {
				PrintWriter out=resp.getWriter();
				out.write("<script>;");
				out.write("alert('请先登录');");
				out.write("location.href='adminlogin.jsp';");
				out.write("</script>");
				out.close();
				return;
			}
		}
		else {//如果不是后端页面，直接放行
			chain.doFilter(request, response);
		}
		
		return;			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
