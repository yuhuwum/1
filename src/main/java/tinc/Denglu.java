package tinc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.AdministratorsDAO;

/**
 * Servlet implementation class Denglu
 */
@WebServlet("/1/Denglu")
public class Denglu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdministratorsDAO administrators=new AdministratorsDAO();
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		String pas=request.getParameter("pas");
		if(administrators.select(name,pas)) {
			request.getRequestDispatcher("zhu").forward(request,response);
		}else {
			
		}
	}

}
