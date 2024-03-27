package sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDAO;
import shiti.Visits;

public class VisitsDAO extends BaseDAO {
	public int insert(String cars_number,String visit_phone,Date start_time, Date end_time,String reason_text,String permission_text,String notes) {
		String sql="INSERT INTO visits VALUES(NULL,'"+cars_number+"','"+visit_phone+"',now(),'"+start_time+"','"+end_time+"','"+reason_text+"','"+permission_text+"','待审批','"+notes+"',1)";
		return this.execut(sql);
	}
	public int delete(int visitsId) {
		String sql="update visits set pd=0 where visit_id="+visitsId;
		return this.execut(sql);
	}
	public List<Visits> select(int curpage,int pagesize,String cars_number,String reason_text,String states,Date start_time,Date end_time) {
		
	}
	public int count(String cars_number,String reason_text,String states,Date start_time,Date end_time) {
		int cou=0;
		try {
			StringBuffer sql=new StringBuffer("select count(*) from visits ");
			sql.append("where 1=1 and pd=1");
			if(cars_number!=null&&!cars_number.equals("")||reason_text!=null&&!reason_text.equals("")||start_time!=null&&!start_time.equals("")||end_time!=null&&!end_time.equals("")) {
				
				if(cars_number!=null&&!cars_number.equals("")) {
					sql.append(" and cars_number like '%"+cars_number+"%'");
				}
				if(reason_text!=null&&!reason_text.equals("")) {
					sql.append(" and reason_text like '%"+reason_text+"%'");
				}
				if(states!=null&&!states.equals("")) {
					sql.append(" and state like '%"+states+"%'");
				}
				if(start_time!=null&&!start_time.equals("")) {
					sql.append(" and start_time like '%"+start_time+"%'");
				}
				if(end_time!=null&&!end_time.equals("")) {
					sql.append(" and end_time like '%"+end_time+"%'");
				}
			}
			System.out.println(sql);
			stmt=getConn().prepareStatement(sql.toString());
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				cou=rs.getInt(1);
			}
			rs.close();
			stmt.close();
			return cou;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cou;
	}
}
