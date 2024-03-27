package saying.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.xdevapi.PreparableStatement;

import saying.shiti.ChartDC;
import saying.shiti.Saying;

public class SayingDAO{
	public void insert(String name,String scontent) {
		String sql="insert into saying values(null,'"+name+"','"+scontent+"',now())";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/停车?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Saying> select(){
		String sql="select * from saying order by sid desc";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/停车?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Saying> list=this.map(rs);
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void delete(String[] sids) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/停车?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			PreparedStatement stmt=null;
			for(String sid:sids) {
				String sql="delete from saying where sid=?";
				stmt=conn.prepareStatement(sql);
				stmt.setString(1,sid);
				stmt.executeUpdate();
			}
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<ChartDC> chartDC(){

		String sql="SELECT DATE_FORMAT(stime,'%Y-%m-%d'),COUNT(*) FROM saying GROUP BY DATE_FORMAT(stime,'%Y-%m-%d')";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/停车?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<ChartDC> list=new ArrayList();
			while(rs.next()) {
				list.add(new ChartDC(rs.getDate(1),rs.getInt(2)));
			}
			rs.close();
			stmt.close();
			conn.close();
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	public Map<String,Object> selectPage(int curpage,int pagesize){
		String sql="select * from saying order by sid desc limit "+((curpage-1)*pagesize)+","+pagesize;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/停车?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			List<Saying> list=this.map(rs);
			Map<String,Object> map=new HashMap();
			map.put("liet",list);
			sql="select count(*) from saying";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			rs.next();
			int total=rs.getInt(1);
			map.put("total",total);
			rs.close();
			stmt.close();
			conn.close();
			return map;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private List<Saying> map(ResultSet rs) throws SQLException{
		List<Saying> list=new ArrayList();
		while(rs.next()) {
			Saying saying=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4));
			list.add(saying);
		}
		return list;
	}
}
