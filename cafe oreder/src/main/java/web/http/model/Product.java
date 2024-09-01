package web.http.model;

public class Product {
	private String pNum;
	private String pName;
	private String category;
	private int price;
	private String description;
	
	public Product() {}
	public Product(String pNum, String pName, String category, int price, String description) {
		this.pNum = pNum;
		this.pName = pName;
		this.category = category;
		this.price = price;
		this.description = description;
	}
	public String getpNum() {
		return pNum;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [pNum=" + pNum + ", pName=" + pName + ", category=" + category + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
	
}
