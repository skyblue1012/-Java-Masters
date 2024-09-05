package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardGameDAOImpl implements BoardGameDAO{
	private DataSource ds;
	private static BoardGameDAOImpl dao = new BoardGameDAOImpl();
	private BoardGameDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup...Success~~!!");
		} catch(NamingException e) {
			System.out.println("DataSource lookup...Fail~~!!");
			
		}
	}
	public static BoardGameDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("DB 연결 성공...");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerBoardGame(BoardGame vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "INSERT INTO boardgame(name, level, price, designer, publisher) VALUES(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getName());
			ps.setFloat(2, vo.getLevel());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getDesigner());
			ps.setString(5, vo.getPublisher());
			
			ps.executeUpdate();

		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<BoardGame> showAllBoardGame() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BoardGame> list = new ArrayList<BoardGame>();
		
		try {
			conn = getConnect();
			String query = "SELECT number, name, level, price, designer, publisher From boardgame";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new BoardGame(rs.getInt("number"),
									   rs.getString("name"),
									   rs.getFloat("level"),
									   rs.getInt("price"),
									   rs.getString("designer"),
									   rs.getString("publisher")));
			}
					
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
}//class
