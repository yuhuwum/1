package file;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shiti.Ueas;
import sql.UeasDAO;

/**
 * Servlet implementation class ZuoyFileDengluok
 */
@WebServlet("/zuoy/file/ZuoyFileDengluok")
//登录
public class ZuoyFileDengluServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UeasDAO ueasDAO=new UeasDAO();
		List<Ueas> list=null;
		if(ueasDAO.select(request.getParameter("name"),request.getParameter("pas")).size()!=0) {
			list=ueasDAO.select(request.getParameter("name"),request.getParameter("pas"));
			request.setAttribute("list",list);
			request.getRequestDispatcher("dengluok.jsp").forward(request,response);
		}else {
			request.setAttribute("ok","登录失败");
			request.getRequestDispatcher("denglu.jsp").forward(request,response);
		}
	}

}
