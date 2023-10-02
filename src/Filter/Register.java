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
 * Servlet Filter implementation class Register
 */
@WebFilter("/register")
public class Register implements Filter {

    /**
     * Default constructor. 
     */
    public Register() {
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
	//前端界面登录过滤器
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");	
		
		String username =req.getParameter("userName");
		String name =req.getParameter("name");
		String password =req.getParameter("password");
		String repassword =req.getParameter("repassword");
		String address=req.getParameter("address");
		String veryCode=req.getParameter("veryCode");
		HttpSession session=req.getSession();
		String syscode =(String)session.getAttribute("code");
		
		
		
		PrintWriter out=resp.getWriter();
		
		if(username.equals("")) {
			out.write("<script>;");
			out.write("alert('用户名称不能为空');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(name.equals("")) {
			out.write("<script>;");
			out.write("alert('用户姓名不能为空');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(address.equals("")) {
			out.write("<script>;");
			out.write("alert('收货地址不能为空');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		if(!veryCode.equals(syscode)) {
			out.write("<script>;");
			out.write("alert('验证码输入有错，请检查后重新输入');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		}	
		
		if(!password.equals(repassword)) {
			out.write("<script>;");
			out.write("alert('两次密码输入不一致，请检查后重新输入');");
			out.write("location.href='reg.jsp';");
			out.write("</script>");
			out.close();
			return;
		}
		
		chain.doFilter(req, resp);//通过过滤器直接执行这条语句
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
