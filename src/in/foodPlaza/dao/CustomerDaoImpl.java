package in.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.foodPlaza.pojo.Customer;
import in.foodPlaza.test.utility.DbConnection;

public class CustomerDaoImpl implements CustomerDao {

	ResultSet rs;
	PreparedStatement ps = null;
	String query;
	int ans;
	Connection conn = null;

	@Override
	public boolean addCustomer(Customer customer) {
		try {
			System.out.println("Inside Add customer in daoimpl");

			conn = DbConnection.getConnection();

			query = "insert into customer_22377(custname,custemail,custcontact,custaddress,custpassword,custconfirmpassword) values(?,?,?,?,?,?)";

			ps = conn.prepareStatement(query);

			ps.setString(1, customer.getCustName());
			ps.setString(2, customer.getCustEmail());

			ps.setString(3, customer.getCustContact());

			ps.setString(4, customer.getCustAddress());

			if (customer.getCustPassword().equals(customer.getCustConfirmpassword())) {
				ps.setString(5, customer.getCustPassword());
				ps.setString(6, customer.getCustConfirmpassword());
				ans = ps.executeUpdate();

			}

			else
				System.out.println("Password Not Match!!!!!! please Enter The Valid Password");

			System.out.println("Ans=" + ans);

			if (ans > 0)
				return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {

		System.out.println("Inside upadate customer in  Dao Impl");
		try {
			conn = DbConnection.getConnection();
			query = "update customer_22377 set custname=?,custemail=?,custcontact=?,custaddress=?,custpassword=?,custconfirmpassword=? where custid=? ";
			ps = conn.prepareStatement(query);

			ps.setString(1, customer.getCustName());
			ps.setString(2, customer.getCustEmail());
			ps.setString(3, customer.getCustContact());
			ps.setString(4, customer.getCustAddress());
			ps.setString(5, customer.getCustPassword());
			ps.setString(6, customer.getCustConfirmpassword());
			ps.setInt(7, customer.getCustId());
			ans = ps.executeUpdate();

			if (ans > 0)
				return true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCustomer(int custId) {

		System.out.println("Delete  Customer Record In Dao Impl");

		try {
			conn = DbConnection.getConnection();
			query = "delete from customer_22377 where custid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, custId);
			ans = ps.executeUpdate();
			System.out.println("Ans" + ans);
			if (ans > 0)
				return true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Customer> ShowCustomerList() {

		List<Customer> custList = new ArrayList<Customer>();

		System.out.println("Inside Customer Show in Dao Impl");

		try {
			conn = DbConnection.getConnection();
			query = "select * from customer_22377";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustContact(rs.getString(4));
				c.setCustAddress(rs.getString(5));
				c.setCustPassword(rs.getString(6));
				c.setCustConfirmpassword(rs.getString(7));

				custList.add(c);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return custList;
	}

	@Override
	public Customer searchCustomerById(int custId) {

		System.out.println("search by id in Dao Impl");
		try {
			conn = DbConnection.getConnection();
			query = "select * from customer_22377 where custid=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, custId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustContact(rs.getString(4));
				c.setCustAddress(rs.getString(5));
				c.setCustPassword(rs.getString(6));
				c.setCustConfirmpassword(rs.getString(7));
				return c;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Customer searchCustomerByEmail(String custEmail) {

		System.out.println("search by id in Dao Impl");
		try {
			conn = DbConnection.getConnection();
			query = "select * from customer_22377 where custemail=?";

			ps = conn.prepareStatement(query);
			ps.setString(1, custEmail);
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustContact(rs.getString(4));
				c.setCustAddress(rs.getString(5));
				c.setCustPassword(rs.getString(6));
				c.setCustConfirmpassword(rs.getString(7));
				return c;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
