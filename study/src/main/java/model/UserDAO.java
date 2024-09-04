package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.User;

public interface UserDAO {
    public Connection getConnection() throws SQLException;
    public void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
    public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
    void signUp(String Id,String password, String userName, String category)throws SQLException;

    User login(String Id, String password)throws SQLException;

}
