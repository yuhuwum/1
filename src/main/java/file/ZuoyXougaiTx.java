package file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import sql.UeasDAO;

/**
 * Servlet implementation class ZuoyXougaiTx
 */
@WebServlet("/zuoy/file/ZuoyXougaiTx")
@MultipartConfig
public class ZuoyXougaiTx extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UeasDAO ueasDAO=new UeasDAO();
		request.setCharacterEncoding("utf-8");
			Part part=request.getPart("tx");
			if(part!=null) {
				String name=part.getHeader("content-disposition");
				//文件名
				String name1= name.split(";")[2].split("=")[1].replaceAll("\"","");
				//文件后缀
				int pos=name1.lastIndexOf('.');
				String exl=name1.substring(pos);
				//随机
				String rnname=UUID.randomUUID().toString().toUpperCase();
				//获取发布后的工程目录
				String root=this.getServletContext().getRealPath("");
				//创建images子文件夹
				File images=new File(root,"images");
				if(!images.exists()) {
					images.mkdirs();
				}
				String photo=root+"/images/"+rnname+exl;
				part.write(photo);
				if(ueasDAO.update(Integer.parseInt(request.getParameter("id")),rnname+exl)!=0) {
					request.setAttribute("no","修改成功");
					request.setAttribute("list",ueasDAO.select(Integer.parseInt(request.getParameter("id"))));
				}
				
			}else {
				request.setAttribute("no","修改失败");
			}
		request.getRequestDispatcher("dengluok.jsp").forward(request,response);
	}

}
