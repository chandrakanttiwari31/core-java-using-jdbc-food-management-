package in.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import in.foodPlaza.pojo.Order;
import in.foodPlaza.test.utility.DbConnection;

public class OrderDaoImpl implements OrderDao {

	Order o;
	ResultSet rs;
	PreparedStatement ps = null;
	String query;
	int ans;
	Connection conn = null;

	@Override
	public Order placeOrder(String custEmail) {

		double total = 0;
		try {
			conn = DbConnection.getConnection();
			query = "select sum(foodprice*foodquantity) as total  from food_22377 f inner join cart_22377 c on f.foodid=c.foodid where custemail=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, custEmail);
			rs = ps.executeQuery();

			if (rs.next()) {
				total = rs.getDouble(1);
				System.out.println("total" + total);
				;

			}

			String orderdate = new Date().toString();

			query = "insert into order_22377(custemail,orderdate,totalbill)values(?,?,?)";

			ps = conn.prepareStatement(query);
			ps.setString(1, custEmail);
			ps.setString(2, orderdate);
			ps.setDouble(3, total);

			ans = ps.executeUpdate();
			if (ans > 0)
				query = "select  * from order_22377 where custemail=? and orderdate=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, custEmail);
			ps.setString(2, orderdate);
			rs = ps.executeQuery();

			if (rs.next()) {

				o = new Order();
				o.setOrderId(rs.getInt(1));
				o.setCustEmail(rs.getString(2));
				o.setOrderStatus(rs.getString(3));
				o.setOrderDate(rs.getString(4));
				o.setTotalBill(rs.getInt(5));
			}
			return o;

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
	public List<Order> ShowMyOrders(String custEmail) {
		List<Order> l = new ArrayList<Order>();
		Order o = null;
		try {
			conn = DbConnection.getConnection();
			query = "select orderid ,custemail,orderstatus,orderdate,totalbill from order_22377 where custemail=?";
			;
			ps = conn.prepareStatement(query);
			ps.setString(1, custEmail);
			rs = ps.executeQuery();
			while (rs.next()) {

				o = new Order();
				o.setOrderId(rs.getInt(1));
				o.setCustEmail(rs.getString(2));
				o.setOrderStatus(rs.getString(3));
				o.setOrderDate(rs.getString(4));
				o.setTotalBill(rs.getInt(5));

				l.add(o);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Order> showAllOrders() {
		List<Order> l = new ArrayList<Order>();
		Order o = null;
		try {
			conn = DbConnection.getConnection();
			query = "select orderid ,custemail,orderstatus,orderdate,totalbill from order_22377 ";
			;
			ps = conn.prepareStatement(query);
					rs = ps.executeQuery();
			while (rs.next()) {

				o = new Order();
				o.setOrderId(rs.getInt(1));
				o.setCustEmail(rs.getString(2));
				o.setOrderStatus(rs.getString(3));
				o.setOrderDate(rs.getString(4));
				o.setTotalBill(rs.getInt(5));

				l.add(o);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

}
