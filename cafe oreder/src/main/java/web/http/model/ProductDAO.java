package web.http.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface ProductDAO {
	Connection getConnection() throws SQLException;
	
	void order(String userId, int totalPrice, LinkedHashMap<Product, Integer>plist );
	
	
	void cancleOrder(int orderId);
	
	
	
	ArrayList<Order> showOrder(String userId);
	
	
	
}
