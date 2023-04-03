package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	public Connection getConnect() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/new_servlet";
		String user = "root";
		String password = "040520";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
