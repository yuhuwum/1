package tinc;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.VisitsDAO;

/**
 * Servlet implementation class Sql
 */
@WebServlet(urlPatterns = "/1/zhu")
public class Zhu extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisitsDAO visitsDAO=new VisitsDAO();
		request.setCharacterEncoding("utf-8");
		int curpage=1;
		if(request.getParameter("curpage")!=null) {
			curpage = Integer.parseInt(request.getParameter("curpage"));
		}
		request.setAttribute("curpage",curpage);
		int pagesize = 5;
		if(request.getParameter("pagesize")!=null) {
			pagesize = Integer.parseInt(request.getParameter("pagesize"));
		}
		String carpai=null,reason_text=null,states=null;
		if(request.getParameter("carpai")!=null) {
			carpai = request.getParameter("carpai").toString();
		}
		if(request.getParameter("reason_text")!=null) {
			reason_text =request.getParameter("reason_text").toString();
		}
		if(request.getParameter("states")!=null) {
			states = request.getParameter("states");
			System.out.println(states);
		}
		Date start_time=null,end_time=null;
		if(request.getParameter("start_time")!=null&&!request.getParameter("start_time").equals("")) {
			 start_time=Date.valueOf(request.getParameter("start_time"));
		}
		if(request.getParameter("end_time")!=null&&!request.getParameter("end_time").equals("")) {
			end_time=Date.valueOf(request.getParameter("end_time"));
		}
		
		//获取当前页的数据
		request.setAttribute("list",visitsDAO.select(curpage,pagesize,carpai,reason_text,states,start_time,end_time));
		System.out.println(visitsDAO.select(curpage,pagesize,carpai,reason_text,states,start_time,end_time));
		//总数
		request.setAttribute("total",visitsDAO.count(carpai,reason_text,states,start_time,end_time));
		System.out.println(visitsDAO.count(carpai,reason_text,states,start_time,end_time));
		//转到 jsp
		request.getRequestDispatcher("zhu.jsp").forward(request, response);
	}

}