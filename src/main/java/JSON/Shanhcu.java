package JSON;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.UeasDAO;

/**
 * Servlet implementation class Shanhcu
 */
@WebServlet("/Shanhcu")
public class Shanhcu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UeasDAO ueas= new UeasDAO();
		if(!(request.getParameter("id")==null)) {
			ueas.insert(Integer.parseInt(request.getParameter("id")));
		}
	}
}
