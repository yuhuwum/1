package saying.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;

/**
 * Servlet implementation class LisetServlet
 */
@WebServlet("/saying/LisetServlet")
public class LisetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SayingDAO sayingDAO=new SayingDAO();
		request.setAttribute("list",sayingDAO.select());
		request.getRequestDispatcher("liuy.jsp").forward(request,response);
	}

}
