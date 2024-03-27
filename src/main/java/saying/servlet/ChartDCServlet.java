package saying.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import saying.dao.SayingDAO;
import saying.shiti.ChartDC;
import saying.shiti.Saying;

/**
 * Servlet implementation class ChartDCServlet
 */
@WebServlet("/saying/ChartDCServlet")
public class ChartDCServlet extends HttpServlet {
	private SayingDAO sayingDAO=new SayingDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ChartDC> list=sayingDAO.chartDC();
		
		int total=0;
		for(ChartDC vo:list) {
			total+=vo.getCount();
		}
		request.setAttribute("list",list);
		request.setAttribute("total",total);
		request.getRequestDispatcher("toji.jsp").forward(request,response);
	}

}
