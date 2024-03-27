package shiti;

import java.sql.Date;
import java.sql.Timestamp;

public class News {
	private int id;
	private String title;
	private String source;
	private Timestamp shij;
	public News(int id, String title, String source, Timestamp shij) {
		super();
		this.id = id;
		this.title = title;
		this.source = source;
		this.shij = shij;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Timestamp getShij() {
		return shij;
	}
	public void setShij(Timestamp shij) {
		this.shij = shij;
	}
	
}
