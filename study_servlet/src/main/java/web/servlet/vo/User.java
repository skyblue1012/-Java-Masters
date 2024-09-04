package web.servlet.vo;

public class User {
	private String id;
	private String password;
	private String nickname;
	private String address;
	public User(String id, String password, String nickname, String address) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.address = address;
	}
	public User() {}
	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", nickname=" + nickname + ", address=" + address + "]";
	}
	
	
}
