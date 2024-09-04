package web.servlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import web.servlet.vo.Product;
import web.servlet.vo.User;

public interface DAO {
	//공통로직
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	//비즈니스로직
	//1. 로그인
	User login(String id, String password) throws SQLException;
}
