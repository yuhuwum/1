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

/**
 * Servlet implementation class File
 */
@WebServlet("/file/File")
@MultipartConfig
public class image extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part=request.getPart("file");
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
		System.out.println(root);
		//创建images子文件夹
		File images=new File(root,"images");
		if(!images.exists()) {
			images.mkdirs();
		}
		String photo=root+"/images/"+rnname+exl;
		part.write(photo);
		request.setAttribute("photo",rnname+exl);
		request.getRequestDispatcher("file.jsp").forward(request,response);
	}

}
