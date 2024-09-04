package web.servlet.model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
	private List<TodoItem> todoItems;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public User() {};
	public User(String userId, String password, String name, String email) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
//		this.todoItems = todoItems;
	}
	
	public User(String userId, String password, String name, String email, List<TodoItem> todoItems, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.todoItems = todoItems;
	}
	
	public String getId() {
		return userId;
	}
	public void setId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }
    
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", todoItems=" + todoItems + "]";
	}
		

}
