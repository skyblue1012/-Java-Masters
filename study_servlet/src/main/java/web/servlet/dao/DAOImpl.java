package web.servlet.dao;

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
			System.out.println("DataSource lookup 성공");
		} catch (NamingException e) {
			e.getMessage();
		}
	}
	public static DAOImpl getInstance() {
		return dao;
	}
	
	//공통로직
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("getConnect 성공");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void addProduct(User user, Product prod) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArrayList<Product> showProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
