package web.http.model;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDAO {
	Connection getConnection() throws SQLException;
	boolean checkId(String id);
	void createAccount(User user) ;
	User login(String id, String pass);
	
}
