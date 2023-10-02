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
 * Servlet implementation class doproductupdate
 */
@WebServlet("/newmanage/admin_doproductupdate")
public class doproductupdate extends HttpServlet {
	

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
				String productid=req1.getParameter("id");
				
				PRODUCT p= new PRODUCT(
					Integer.parseInt(productid),
					pname,
					pdescribe,
					Float.parseFloat(pprice),
					Integer.parseInt(pstock),
					Integer.parseInt(id.split("-")[0]),
					Integer.parseInt(id.split("-")[1]),
					filename
				);
				int count=ProductDao.update(p);
				if(count>0) {
					response.sendRedirect("admin_productselect");
				}
				else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out =response.getWriter();
					out.write("<script>");
					out.write("alert('商品修改失败');");
					out.write("location.herf='/OnlineShop/newmanage/admin_productselect';");
					out.write("</script>");
				}
				}
	}


