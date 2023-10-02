package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import Service.ProductDao;
import onlineshop_enity.PRODUCT;

/**
 * Servlet implementation class doproductadd
 */
@WebServlet("/newmanage/admin_doproductadd")
public class doproductadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public doproductadd() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建smartupload对象
				SmartUpload su=new SmartUpload();
				//初始化
				su.initialize(this.getServletConfig(),request,response);
				//上传过程
				
				try {
					su.upload();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//获取上传文件对象
				Files fs=su.getFiles();
				File f=fs.getFile(0);
				//获取上传的图片名称s
				String filename=f.getFileName();
				try {
					su.save("images/product");
				} catch (ServletException | IOException | SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Request req1= su.getRequest();
				String pname=req1.getParameter("Productname");
				String id=req1.getParameter("parentID");
				String pprice=req1.getParameter("Productprice");
				String pdescribe=req1.getParameter("Productdescribe");
				String pstock=req1.getParameter("Productstock");
				
				PRODUCT p= new PRODUCT(
					0,
					pname,
					pdescribe,
					Float.parseFloat(pprice),
					Integer.parseInt(pstock),
					Integer.parseInt(id.split("-")[0]),
					Integer.parseInt(id.split("-")[1]),
					filename
				);
				int count=ProductDao.insert(p);
				if(count>0) {
					response.sendRedirect("admin_productselect");
				}
				else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out =response.getWriter();
					
					out.write("<script>");
					out.write("alert('商品添加失败');");
					out.write("location.herf='newmanage/admin_toproductadd';");
					out.write("</script>");
				}
				}
	}


