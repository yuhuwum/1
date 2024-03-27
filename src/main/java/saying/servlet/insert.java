package saying.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;

/**
 * Servlet implementation class insert
 */
@WebServlet(urlPatterns =  "/saying/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SayingDAO sayingDAO=new SayingDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String content=request.getParameter("content");
		sayingDAO.insert(name,content);
		request.getRequestDispatcher("LisetServlet").forward(request,response);
	}

}
