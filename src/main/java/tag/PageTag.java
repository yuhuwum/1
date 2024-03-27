package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageTag extends SimpleTagSupport{
	private String controller;//Web组件名
	private int curpage=1;//当前页
	private int pagesize;//页大小
	private int total;//总记录数
	private String where="";//其他请求参数
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	private int pages() {
		return (this.total-1)/this.pagesize+1;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		String url="%s?curpage=%d&pagesize=%d&where=%s";
		String a="<a href="+url+">%s</a>";
		//第一页
		String first = String.format(a, "../"+this.controller,1,this.pagesize,this.where,"第一页");
		//上一页
		String pre=null;
		if(curpage==1) {
			pre="<a href=javascript:alert('已经是第一页了')>上一页</a>";
		}else {
			pre = String.format(a, "../"+this.controller,this.curpage-1,this.pagesize,this.where,"上一页");
		}
		//下拉
		String xial=null;
		xial="<select onchange='' id='xia'>";
		for(int i=1;i<=this.pages();i++) {
			if(i==curpage) {
				xial+="<option selected>"+i+"</option>";
			}else {
			xial+="<option value='"+i+"'>"+i+"</option>";
			}
		}
		xial+="</select>";
		xial+="<script>"
				+ "		var v=document.querySelector(\"#xia\");"
				+ "		v.onchange=function(){"
				+ "			document.location.href=\""+"../"+this.controller+"?curpage=\"+this.value+\"&pagesize="+this.pagesize+"&"+this.where+"\""
				+ "		}"
				+ "</script>";
		//下一页
		String next=null;
		if(curpage==this.pages()) {
			next="<a href=javascript:alert('已经是最后一页了')>下一页</a>";
		}else {
		next = String.format(a,"../"+this.controller,this.curpage+1,this.pagesize,this.where,"下一页");
		}
		//最后一页
		String last = String.format(a, "../"+this.controller,this.pages(),this.pagesize,this.where,"最后一页");
		
		String info=String.format("第%d页/共%d页 共%d条记录", this.curpage,this.pages(),this.total);
		//拼接
		StringBuffer sb=new StringBuffer();
		sb.append("<div class='p'>").append(first).append(pre).append(xial).append(next).append(last).append(info).append("</div>");
		//输出
		JspWriter out=this.getJspContext().getOut();
		out.print(sb);
	}
}