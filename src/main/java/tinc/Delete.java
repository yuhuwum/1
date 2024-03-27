package tinc;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.VisitsDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/1/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		VisitsDAO visitsDAO=new VisitsDAO();
		request.setCharacterEncoding("utf-8");
		
		System.err.println(visitsDAO.delete(Integer.parseInt(request.getParameter("visitsId"))));
		response.sendRedirect("zhu");
	}

}
