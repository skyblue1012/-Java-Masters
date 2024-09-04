package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TodoItemDAOImpl implements TodoItemDAO {

	private DataSource ds;
	
	private static TodoItemDAOImpl dao = new TodoItemDAOImpl();
	private TodoItemDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Lookup Success");
		}catch (NamingException e) {
			System.out.println("DataSource Lookup Fail");
		}
	}
	public static TodoItemDAOImpl getInstance() {
		return dao;
	}
	
	
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공.");
		return ds.getConnection();
	}
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();		
		if (conn != null) conn.close();
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)	rs.close();
		closeAll(ps, conn);	
	}
	
	// TODO
	@Override
	public void addTodoItem(TodoItem vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("addTodoItem : " + vo.getId() + " , " + vo.getTitle());
		try {
			conn = getConnection();
			String query = "INSERT INTO TodoItem (id, title) VALUES (?,?)";
			ps = conn.prepareStatement(query);

			ps.setInt(1, vo.getId());
			ps.setString(2, vo.getTitle());
			
			System.out.println(ps.executeUpdate() + " 아이템 등록완료");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void deleteTodoItem(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			System.out.println("id : " + id);
			String query = "UPDATE todoItem SET deleted_at=NOW() WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			System.out.println(ps.executeUpdate() + " 아이템 삭제완료");
		}catch (Exception e) {
			System.out.println("deleteTodoItem : " + e);
		}
		finally {
			closeAll(rs, ps, conn);
		}
		
	}

	@Override
	public ArrayList<TodoItem> showAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<TodoItem> list = new ArrayList<TodoItem>();
		
		try {
			conn = getConnection();
			String query = "SELECT id, title FROM todoItem WHERE deleted_at IS NULL";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				TodoItem todo = new TodoItem(rs.getInt("id"), rs.getString("title"));
				list.add(todo);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	// TODO
	@Override
	public ArrayList<TodoItem> showCompleted() throws SQLException {
		return null;
	}

	// TODO
	@Override
	public ArrayList<TodoItem> showActive() throws SQLException {
		return null;
	}

}
