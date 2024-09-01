package config;

public interface ServerInfo {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; //public static final
	String URL = "jdbc:mysql://127.0.0.1:3306/cafeorder?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASSWORD = "1234";
}
