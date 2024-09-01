package web.http.model;

import java.util.LinkedHashMap;

public class Order {
	private int orderId;
	private String userId;
	private String orderTime;
	private int totalPrice;
	private LinkedHashMap<Product,Integer> plist;
	
	public Order() {}
	public Order(int orderId, String userId, String orderTime, int totalPrice, LinkedHashMap<Product, Integer> plist) {
		this.orderId = orderId;
		this.userId = userId;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.plist = plist;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LinkedHashMap<Product, Integer> getPlist() {
		return plist;
	}
	public void setPlist(LinkedHashMap<Product, Integer> plist) {
		this.plist = plist;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", orderTime=" + orderTime + ", totalPrice="
				+ totalPrice + ", plist=" + plist + "]";
	}
	
	
	
	
	
}
