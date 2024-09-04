package web.servlet.vo;

public class Product {
	private int prodNum;
	private String prodName;
	private String prodPrice;
	public Product(int prodNum, String prodName, String prodPrice) {
		super();
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public Product() {}
	public Product(String prodName, String prodPrice) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public int getProdNum() {
		return prodNum;
	}
	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	@Override
	public String toString() {
		return "Product [prodNum=" + prodNum + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}
}
