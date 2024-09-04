package web.servlet.model;

import java.time.LocalDateTime;

public class TodoItem {
	private int id;
	private String title;
	private String description;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	private String userId;
	
	public TodoItem() {}

	public TodoItem(int id, String title) {
		this.id = id;
		this.title = title;
//		this.userId = userId;
	}

//	public TodoItem(int id, String title, String description, String userId, LocalDateTime createdAt, LocalDateTime updatedAt,LocalDateTime deletedAt) {
//		this.id = id;
//		this.title = title;
//		this.description = description;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.deletedAt = deletedAt;
//		this.userId = userId;
//	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
	
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", title=" + title + ", description=" + description + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", userId=" + userId + "]";
	}
}
