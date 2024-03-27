package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDAO;
import dao.Mapper;
import shiti.Ueas;

public class UeasDAO extends BaseDAO{
	public List<Ueas> select(){
		String sql="select * from ueas ";
		return this.query(sql,new Mapper() {
			public List<Ueas> map(ResultSet rs) throws SQLException {
				List<Ueas> list=new ArrayList();
				while (rs.next()) {
					Ueas ueas=new Ueas(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					list.add(ueas);
				}
				return list;
			}
		});
	}
	public List<Ueas> insert(int id) {
		String sql="delete from ueas where uis=?";
		this.execut(sql,id);
		return this.select();
	}
}
