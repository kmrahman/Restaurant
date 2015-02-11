package kitchen.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/people_db";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static Connection connect () {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
		
		return con;
	}
	
	public static void closeResources (PreparedStatement ps, ResultSet rs, Connection con) {

		try {
			if(ps !=null)
			{
				ps.close();
			}
			
			if(rs !=null)
			{
				rs.close();
			}
			
			if(con !=null)
			{
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		DBConnector.connect();
	}
}
