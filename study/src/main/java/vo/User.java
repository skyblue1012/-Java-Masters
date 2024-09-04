package vo;

public class User {
    private String id;
    private String password;
    private String userName;
    private String category;
    
    public User() {
	}
    
    
	public User(String id, String password, String userName, String category) {
		super();
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.category = category;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", userName=" + userName + ", category=" + category + "]";
	}








}
