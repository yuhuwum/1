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
 * Servlet implementation class Insert
 */
@WebServlet("/1/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisitsDAO visitsDAO=new VisitsDAO();
		request.setCharacterEncoding("utf-8");
		Date start_time=Date.valueOf(request.getParameter("start-time")),end_time=Date.valueOf(request.getParameter("end-time"));
		visitsDAO.insert(request.getParameter("carID"),
						request.getParameter("phone"),
						start_time,
						end_time,
						request.getParameter("why"),
						request.getParameter("quanxian"),
						request.getParameter("message"));
		request.getRequestDispatcher("zhu").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
