package in.foodPlaza.test.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	static Connection conn=null;
	public static Connection getConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("driver loaded");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza_22377", "root", "12345678");
		//System.out.println("connected to db");
		return conn;
	}
	
	
}
