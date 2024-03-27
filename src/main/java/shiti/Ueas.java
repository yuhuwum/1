package shiti;

public class Ueas {
	private int id;
	private String name;
	private String pas;
	private String diz;
	private String phone;
	
	public Ueas(int id, String name, String pas, String diz, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.pas = pas;
		this.diz = diz;
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPas() {
		return pas;
	}
	public void setPas(String pas) {
		this.pas = pas;
	}
	public String getDiz() {
		return diz;
	}
	public void setDiz(String diz) {
		this.diz = diz;
	}
	
}
