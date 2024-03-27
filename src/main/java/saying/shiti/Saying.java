package saying.shiti;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import com.mysql.cj.xdevapi.JsonArray;

public class Saying {
	private int sid;
	private String name;
	@JSONField(name  = "c")
	private String content;
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Timestamp stime;
	public Saying(int sid, String name, String content, Timestamp stime) {
		super();
		this.sid = sid;
		this.name = name;
		this.content = content;
		this.stime = stime;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	
}
