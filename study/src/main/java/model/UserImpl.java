package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import vo.User;

public class UserImpl implements UserDAO {
	private DataSource ds;
	private static UserImpl dao = new UserImpl();
	
	private UserImpl() {
		//Naming Service작업 진행.
		try {
		InitialContext ic = new InitialContext();
		ds= (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		System.out.println("DataSource lookup...Succuece");
		}catch(NamingException e) {
			System.out.println("DataSource lookup...Fail");
		}
	}
	public static UserImpl getInstance() {
		return dao;
	}
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비 연결 성공");
		return ds.getConnection();
	
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!= null) ps.close();
		if(conn!=null)conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps,conn);
		if (rs!=null) rs.close();
	}

	@Override
	public void signUp(String Id, String password, String userName, String category)throws SQLException {
		String query ="insert into user (id,password,username,category) values(?,?,?,?)";
		try(Connection conn=getConnection(); PreparedStatement ps = conn.prepareStatement(query);){
			ps.setString(1, Id);
			ps.setString(2, password);
			ps.setString(3, userName);
			ps.setString(4, category);
			
			ps.executeUpdate();
			System.out.println("유저등록 완료");
		}
	}

	@Override
	public User login(String Id, String password) throws SQLException {
		String query = "select id,password,username,category from user where id =? and password=?;";
		User vo = new User();
		try(Connection conn= getConnection(); PreparedStatement ps = conn.prepareStatement(query);){
			ps.setString(1, Id);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				 vo= new User(Id,password,rs.getString("username"),rs.getString("category"));
			}
		}
		return vo;
	}

}
