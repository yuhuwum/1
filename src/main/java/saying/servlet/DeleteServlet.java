package saying.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;
import saying.shiti.Saying;
import sql.VisitsDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/saying/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       SayingDAO sayingDAO=new SayingDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] sids=request.getParameterValues("sid");
		sayingDAO.delete(sids);
		request.getRequestDispatcher("Listpage?curpage=1&pagesize=2").forward(request,response);
	}
}
