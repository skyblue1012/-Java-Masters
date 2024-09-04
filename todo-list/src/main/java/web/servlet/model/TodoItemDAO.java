package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TodoItemDAO {
	public Connection getConnection() throws SQLException;
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	public void addTodoItem(TodoItem vo) throws SQLException;
	public void deleteTodoItem(int id) throws SQLException;
	public ArrayList<TodoItem> showAll() throws SQLException;
	public ArrayList<TodoItem> showCompleted() throws SQLException;
	public ArrayList<TodoItem> showActive() throws SQLException;	
}
