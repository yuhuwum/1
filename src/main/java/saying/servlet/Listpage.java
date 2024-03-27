package saying.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;

/**
 * Servlet implementation class Listpage
 */
@WebServlet("/saying/Listpage")
public class Listpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listpage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    SayingDAO sayingDAO=new SayingDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int curpage=1;
		if(request.getParameter("curpage")!=null) {
			curpage=Integer.parseInt(request.getParameter("curpage"));
		}
		request.setAttribute("curpage",curpage);
		int pagesize=5;
		if(request.getParameter("pagesize")!=null) {
			 pagesize=Integer.parseInt(request.getParameter("pagesize"));
		}
		request.setAttribute("pagesize",pagesize);
		Map<String ,Object> map=sayingDAO.selectPage(curpage,pagesize);
		request.setAttribute("map",map);
		
		request.getRequestDispatcher("list-paage.jsp").forward(request,response);
	}

}
