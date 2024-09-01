package web.http.model;

public class User {
	private String id;
	private String pass;
	private String name;
	private String mobile;
	
	public User() {}
	public User(String id, String pass, String name, String mobile) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.mobile = mobile;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
	
	
	
	
}
