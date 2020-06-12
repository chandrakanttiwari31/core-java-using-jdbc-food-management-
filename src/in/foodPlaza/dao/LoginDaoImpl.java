package in.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import in.foodPlaza.test.utility.DbConnection;



public class LoginDaoImpl implements LoginDao {
	
	
	
	ResultSet rs;
	PreparedStatement ps = null;
	String query;
	int ans;

	String pass;
	Connection con;
	
	public boolean customerLogin(String emailId, String password) {

		
		query = "select custpassword   from customer_22377 where custemail=?";

	
		try {
			con = DbConnection.getConnection();
		

		
			ps = con.prepareStatement(query);

			ps.setString(1, emailId);

			rs = ps.executeQuery();
			if (rs.next()) {
				pass = rs.getString(1);
			}

			if (password.equals(pass)) {

				return true;
			} else
				return false;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public boolean adminLogin(String adminId, String password) {
		query = "select password   from admin where username=?";

	
		try {
			con = DbConnection.getConnection();
		

		
			ps = con.prepareStatement(query);

			ps.setString(1, adminId);

			rs = ps.executeQuery();
			if (rs.next()) {
				pass = rs.getString(1);
			}

			if (password.equals(pass)) {

				return true;
			} else
				return false;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	public boolean changeCustomerPassword(String emailId, String newPassword) {
		
		try {
			con = DbConnection.getConnection();
		
		query = "update customer_22377 set custpassword=? where custemail=?";
		
			ps = con.prepareStatement(query);

			ps.setString(1, newPassword);
			ps.setString(2, emailId);

			ans = ps.executeUpdate();
			if (ans > 0) {

				return true;
			}

			else
				return false;

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}

	public boolean changeAdminPassword(String adminId, String newPassword) {
		try {
			con = DbConnection.getConnection();
	
		query = "update admin set password=? where username=?";

		
			ps = con.prepareStatement(query);
			ps.setString(1, adminId);
			ps.setString(2, newPassword);

			ans = ps.executeUpdate();
			if (ans > 0)
				return true;
			else
				return false;

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return false;
	}

}
