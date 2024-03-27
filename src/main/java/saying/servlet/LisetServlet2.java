package saying.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson2.JSONArray;

import saying.dao.SayingDAO;
import saying.shiti.Saying;

/**
 * Servlet implementation class LisetServlet
 */
@WebServlet("/saying/LisetServlet2")
public class LisetServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SayingDAO sayingDAO=new SayingDAO();
		List<Saying> list=sayingDAO.select();
		String array=JSONArray.toJSONString(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
	}

}
