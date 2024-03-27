package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDAO;
import dao.Mapper;
import shiti.News;

public class NewsDAO extends BaseDAO{
	public void insert(String title,String source) {
		String sql="insert into news value(null,?,?,now())";
		int a=this.execut(sql,title,source);
	}
	public List<News> select(int curpage,int pagesize){
		String sql="select * from news limit ?,?";
		return this.query(sql,new Mapper() {
			public List<News> map(ResultSet rs) throws SQLException {
				List<News> list = new ArrayList<>();
				while(rs.next()) {
					News news = new News(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getTimestamp(4));
					list.add(news);
				}
				return list;
			}
		},(curpage-1)*2,pagesize);
	}
	public List<News> select(){
		String sql="select * from news";
		return this.query(sql,new Mapper() {
			public List<News> map(ResultSet rs) throws SQLException {
				List<News> list = new ArrayList<>();
				while(rs.next()) {
					News news = new News(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getTimestamp(4));
					list.add(news);
				}
				return list;
			}
		});
	}
	public void delete() {
		String sql="DELETE FROM news WHERE MONTH(shij)=MONTH(NOW())-1";
		this.execut(sql);
	}
	public static void main(String[] args) {
		NewsDAO newsDAO=new NewsDAO();
		//newsDAO.insert("张杰顺","。。。。。");
		System.out.println("分页标题：");
		for(int i=0;i<newsDAO.select(1,2).size();i++) {
			System.out.println(newsDAO.select(1,2).get(i).getTitle());
		}
		System.out.println("详情：");
		for(int i=0;i<newsDAO.select().size();i++) {
			System.out.println(newsDAO.select().get(i).getTitle()+"\n"+newsDAO.select().get(i).getSource());
		}
		newsDAO.delete();
	}
}
