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
 * Servlet implementation class ZuoyFileZhuc
 */
@WebServlet("/zuoy/file/ZuoyFileZhuc")
@MultipartConfig
//注册
public class ZuoyFileZhucServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UeasDAO ueasDAO=new UeasDAO();
		request.setCharacterEncoding("utf-8");
		System.out.println(ueasDAO.select(request.getParameter("name")));
		if(ueasDAO.select(request.getParameter("name"))) {
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
				request.setAttribute("ok","注册成功");
				ueasDAO.insert(request.getParameter("name"),request.getParameter("pas"),request.getParameter("phone"),request.getParameter("diz"),rnname+exl);
			}else {
				request.setAttribute("ok","注册失败");
			}
			
		}
		request.getRequestDispatcher("denglu.jsp").forward(request,response);
	}

}
