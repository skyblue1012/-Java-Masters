package web.servlet.dao;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.servlet.vo.Product;
import web.servlet.vo.User;

public class DAOImpl implements DAO{
	private DataSource ds; //DataSource 필드를 추가해 주어야 함
	
	private static DAOImpl dao = new DAOImpl();
	private DAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("ic.lookup 실행 성공");
		} catch (NamingException e) {
			e.getMessage();
			System.out.println("ic.lookup 실행 실패");
		}finally {
			System.out.println("ic.lookup 실행 완료");
		}
	}
	public static DAOImpl getInstance() {
		return dao;
	}
	
	//공통로직
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("getConnect() 실행 성공");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
		System.out.println("closeAll() 실행 성공");
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}
	@Override
	public User login(String id, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id, password, nickname, address FROM user WHERE id=? AND password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.executeQuery();
			rs = ps.getResultSet();
			if(rs.next()){
				user = new User(rs.getString("id"),
								rs.getString("password"),
								rs.getString("nickname"),
								rs.getString("address")
								);
			}//if
			System.out.println("login() 실행 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 실행 실패");
		}finally {
			closeAll(rs, ps, conn);
			System.out.println("login() 실행 완료");
		}
		//try-catch-finally
		
		return user;
	}//login
}//DAOImpl
