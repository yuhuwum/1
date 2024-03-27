package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public abstract class BaseDAO {
	//获取链接对象
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/停车?useSSL=false&serverTimezone=GMT&characterEncoding=utf-8","root","123456");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close(ResultSet rs,Statement stmt,Connection conn) {
		
			try {
				if(rs!=null) {
					rs.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//释放资源
	public void close(Statement stmt,Connection conn) {
		this.close(null,stmt,conn);
	}
	
	//绑定参数
	public void bindParameters(PreparedStatement stmt,Object...params) {
		if(params!=null){
			for(int i=0;i<params.length;i++) {
				try {
					stmt.setObject(i+1,params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	//执行insert，update，delete语句
	public int execut(String sql,Object...params) {
		
		
		try {
			//获取链接对象
			Connection conn=this.getConnection();
			//创建语句对象
			PreparedStatement stmt = conn.prepareStatement(sql);
			//绑定参数
			this.bindParameters(stmt,params);
			//执行sql语句
			int a=stmt.executeUpdate();
			//释放资源
			this.close(stmt,conn);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public <E> List<E> query(String sql,Mapper<E> mapper,Object...params){
		try {
			//获取链接对象
			Connection conn=this.getConnection();
			//创建语句对象
			PreparedStatement stmt = conn.prepareStatement(sql);
			//绑定参数
			this.bindParameters(stmt,params);
			//执行sql语句
			ResultSet rs=stmt.executeQuery();
			//转list
			List<E> list=mapper.map(rs);
			//释放资源
			this.close(rs,stmt,conn);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Object singleObject(String sql,Object...params) {
		List<Object> list=this.query(sql,new Mapper<Object>() {
			public List<Object> map(ResultSet rs) throws SQLException {
				List<Object> list=new ArrayList();
				while(rs.next()) {
					Object obj=rs.getObject(1);
					list.add(obj);
				}
				return list;
			}
		},params);
		return list.get(0);
	}
}