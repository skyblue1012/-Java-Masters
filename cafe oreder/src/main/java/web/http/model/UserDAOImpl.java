package web.http.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import config.ServerInfo;

public class UserDAOImpl implements UserDAO{
	private DataSource ds;
	private UserDAOImpl() {
		
		 //connection pooling
		try {
			InitialContext ic = new InitialContext();
			ds= (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		}catch (NamingException e) {
			System.out.println(e);
		}
		
		/*
		 // driver loading
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		*/
	}
	private static UserDAOImpl dao = new UserDAOImpl();
	public static UserDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
		//return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	@Override
	public boolean checkId(String id) {
		boolean flag= false;
		String query="SELECT id FROM user WHERE id=?";
		ResultSet rs = null;
		try(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setString(1, id);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				flag= true;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return flag;
	}
	
	@Override
	public void createAccount(User user) {
		String query="INSERT INTO user(id,pass,name,mobile) VALUES(?,?,?,?)"; 
		try(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setString(1, user.getId());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getName());
			ps.setString(4, user.getMobile());
			
			ps.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public User login(String id, String pass){
		String query="SELECT id,pass,name,mobile FROM user WHERE id=? AND pass=?"; 
		ResultSet rs = null;
		User user = null;
		try(
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
				){
			ps.setString(1, id);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return user;
	}

	/*
	public static void main(String[] args) {
		UserDAOImpl dao = UserDAOImpl.getInstance();
		
		User user = new User("id", "pass", "name", "010");
		dao.createAccount(user);
		User user2= dao.login("id", "pass");
		System.out.println(user2);
		
		System.out.println(dao.checkId("id1")); 
	}
*/

	

}
