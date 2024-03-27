package sql;

import java.sql.SQLException;

import dao.BaseDAO;

public class AdministratorsDAO extends BaseDAO{
	public boolean select(String name,String pas) {
		String sql="select * from administrators where admin_name='"+name+"' and admin_pass='"+pas+"'";
		try {
			stmt=getConn().prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
