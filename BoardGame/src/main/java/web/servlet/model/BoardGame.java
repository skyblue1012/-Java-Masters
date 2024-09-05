package web.servlet.model;

public class BoardGame {
	private int number;
	private String name;
	private float level;
	private int price;
	private String designer;
	private String publisher;
	public BoardGame(int number, String name, float level, int price, String designer, String publisher) {
		super();
		this.number = number;
		this.name = name;
		this.level = level;
		this.price = price;
		this.designer = designer;
		this.publisher = publisher;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLevel() {
		return level;
	}
	public void setLevel(float level) {
		this.level = level;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "BoardGame [number=" + number + ", name=" + name + ", level=" + level + ", price=" + price
				+ ", designer=" + designer + ", publisher=" + publisher + "]";
	}
	
	

	

}
