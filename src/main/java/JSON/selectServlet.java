package JSON;

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
import shiti.Ueas;
import sql.UeasDAO;

/**
 * Servlet implementation class delete
 */
@WebServlet("/zuoy/JSON/select")
public class selectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UeasDAO ueas= new UeasDAO();
		if(!(request.getParameter("id")==null)) {
			List<Ueas> list=ueas.insert(Integer.parseInt(request.getParameter("id")));
			String array=JSONArray.toJSONString(list);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(array);
		}else {
		UeasDAO ueas2= new UeasDAO();
		List<Ueas> list=ueas2.select();
		String array=JSONArray.toJSONString(list);
		System.out.println(array);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(array);
		}
	}

}
