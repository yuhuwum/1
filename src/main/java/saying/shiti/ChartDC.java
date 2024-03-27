package saying.shiti;

import java.sql.Date;

public class ChartDC {
	private Date date;
	private int count;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ChartDC(Date date, int count) {
		super();
		this.date = date;
		this.count = count;
	}
	public ChartDC() {
		super();
	}
	
}
