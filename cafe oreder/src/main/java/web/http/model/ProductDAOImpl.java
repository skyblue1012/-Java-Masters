package web.http.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class ProductDAOImpl implements ProductDAO{ 
	DataSource ds;
	private ProductDAOImpl() {
		
		try {
			InitialContext ic = new InitialContext();
			ds=	(DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		}catch (NamingException e) {
			System.out.println(e);
		}
		
		/*
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		*/
	}
	private static ProductDAOImpl dao = new ProductDAOImpl();
	public static ProductDAOImpl getInstance() {
		return dao;
	}
	
	
	@Override
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
		//return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD) ;
	}
	

	@Override
	public void order(String userId, int totalPrice, LinkedHashMap<String, Integer> plist) {
		/*
		 * order 테이블에 userId, totalPrice 입력,
		 * order 테이블에서 userId와 totalPrice로 orderId 받아오기, 추후에 id와 시간으로 수정 필요
		 * order_product 테이블에 orderId, Map 입력하기
		 */
		String query1="INSERT INTO orderlist(User_id,orderTime,totalPrice) VALUES(?,now(),?) ";
		String query2="SELECT orderId FROM orderlist WHERE User_id = ? AND totalPrice=?";
		String query3="INSERT INTO order_product(Orderlist_orderId,Product_pNum,quantity) VALUES(?,?,?) ";
		ResultSet rs = null;
		int orderId = 0;
		
		try(
			Connection conn=getConnection();
			PreparedStatement ps1 = conn.prepareStatement(query1);
			PreparedStatement ps2 = conn.prepareStatement(query2);
			PreparedStatement ps3 = conn.prepareStatement(query3);
				){
			ps1.setString(1, userId);
			ps1.setInt(2, totalPrice);
			
			ps1.executeUpdate();
			
			ps2.setString(1, userId);
			ps2.setInt(2, totalPrice);
			rs= ps2.executeQuery();
			if(rs.next()) {
				orderId = rs.getInt("orderId");
			}
			for(Map.Entry<String, Integer> entry : plist.entrySet() ) {
				ps3.setInt(1,orderId);
				ps3.setString(2,entry.getKey());
				ps3.setInt(3,entry.getValue());
				ps3.executeUpdate();
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}

	@Override
	public void cancleOrder(int orderId) {
		//order 테이블과 order_product 테이블에서 orderId로 delete
		String query1="DELETE FROM orderlist WHERE orderId=?";
		String query2="DELETE FROM order_product WHERE orderlist_orderId=?";
		try(
			Connection conn=getConnection();
			PreparedStatement ps1 = conn.prepareStatement(query1);
			PreparedStatement ps2 = conn.prepareStatement(query2);
				){
			ps1.setInt(1, orderId);
			ps1.executeUpdate();
			ps2.setInt(1, orderId);
			ps2.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public ArrayList<Order> showOrder(String userId) {
		/*
		 * order 테이블에서 userId로 정보(orderId,orderTime,totalPrice) 가져오기 
		 * order_product에서 pNum,quantity 받아오기
		 * order 객체 생성 후 list에 담아서 반환
		 */
		String query1="SELECT orderId,User_id,ordertime,totalprice FROM orderlist WHERE user_id=?";
		String query2="SELECT orderlist_orderid,product_pnum,quantity FROM order_product WHERE orderlist_orderid = ?";
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<Integer> orderid= new ArrayList<>();
		
		ArrayList<Order> list =new ArrayList<Order>();
		int idx=0;
		try(
			Connection conn=getConnection();
			PreparedStatement ps1 = conn.prepareStatement(query1);
			PreparedStatement ps2 = conn.prepareStatement(query2);
				){
			ps1.setString(1, userId);
			rs1=ps1.executeQuery();
			while (rs1.next()) {
				Order order = new Order(rs1.getInt(1), userId, rs1.getString(3), rs1.getInt(4), null);
				
				list.add(order);
				orderid.add(rs1.getInt(1));
			}
			for(int id : orderid) {
				ps2.setInt(1, id);
				rs2=ps2.executeQuery();
				LinkedHashMap<Product, Integer> plist = new LinkedHashMap<>();
				while(rs2.next()) {
					Product p = new Product(rs2.getString(2), null, null,0, null);
					
					
					plist.put(p, rs2.getInt(3));
					list.get(idx).setPlist(plist);
				}
				idx++;
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
	
		return list;
	}
	public String getPrice(String pnum) {
		String query="SELECT price FROM product WHERE pnum=?";
		ResultSet rs = null;
		String list = "";
		try(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);	
				){
			
				ps.setString(1, pnum);
				rs=ps.executeQuery();
				if(rs.next()) {
					list = String.valueOf(rs.getInt(1));
				}
			
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
/*	
public static void main(String[] args) {
	ProductDAOImpl dao = ProductDAOImpl.getInstance();
	
//	LinkedHashMap<Product, Integer> plist = new LinkedHashMap<Product, Integer>();
//	Product p1 = new Product("001", "아메리카노", "음료", 4000, "에스프레소에 물을 추가한 커피");
//	Product p2 = new Product("002", "카페라떼", "음료", 4500, "에스프레소에 스팀 밀크를 더한 커피");
//	Product p3 = new Product("003", "카푸치노", "음료", 4500, "에스프레소에 스팀 밀크와 거품을 더한 커피");
//	
//	plist.put(p1, 2);
//	plist.put(p2, 2);
//	plist.put(p3, 4);
//	dao.order("id1", 30000,plist);
//	dao.cancleOrder(12);
	
	dao.showOrder("id1");
}
 */

}
