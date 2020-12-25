package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String user = "sa";
			String pass = "12345678";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=geminishopping";
			connection = DriverManager.getConnection(url, user, pass);
			
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}
