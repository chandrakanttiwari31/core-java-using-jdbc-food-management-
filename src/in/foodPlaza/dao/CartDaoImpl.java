package in.foodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.foodPlaza.pojo.Cart;
import in.foodPlaza.pojo.Customer;
import in.foodPlaza.test.utility.DbConnection;

public class CartDaoImpl implements CartDao {

	ResultSet rs;
	PreparedStatement ps = null;
	String query;
	int ans;
	Connection conn = null;

	@Override
	public boolean addCart(Cart c) {

		try {
			conn = DbConnection.getConnection();
			query = "insert into cart_22377 (foodid,custemail,foodquantity) value(?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, c.getFoodId());
			ps.setString(2, c.getCustEmail());
			ps.setInt(3, 1);
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
	public boolean deleteFromCart(int cartId) {
		try {
			conn = DbConnection.getConnection();
			query = " delete  from cart_22377 where cartid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);

			ans = ps.executeUpdate();
			if (ans > 0) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateMyCart(int foodQuantity, int cartId) {
		try {
			conn = DbConnection.getConnection();
			query = "update cart_22377 set foodquantity=? where cartid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, foodQuantity);
			ps.setInt(2, cartId);
			System.out.println(ps);
			ans = ps.executeUpdate();
			if (ans > 0)
				return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> ShowMyCart(String custEmail) {

		List<Cart> cartlist = new ArrayList();
		try {
			conn = DbConnection.getConnection();
			query = "select cartid,foodname,foodtype,foodcategory,foodprice,foodquantity from food_22377 f inner join cart_22377 c on f.foodid=c.foodid where custemail=? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, custEmail);

			rs = ps.executeQuery();
			while (rs.next()) {

				Cart c = new Cart();
				c.setCartId(rs.getInt(1));
				c.setFoodName(rs.getString(2));
				c.setFoodtype(rs.getString(3));
				c.setFoodCategory(rs.getString(4));
				c.setFoodPrice(rs.getInt(5));
				c.setFoodQuantity(rs.getInt(6));

				cartlist.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartlist;
	}

	@Override
	public List<Cart> ShowCartList() {
		List<Cart> clist = new ArrayList();
		try {
			conn = DbConnection.getConnection();
			query = "select cartid,custemail,foodname,foodtype,foodcategory,foodprice,foodquantity from food_22377 f inner join cart_22377 c on f.foodid=c.foodid ";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while (rs.next()) {

				Cart c = new Cart();
				c.setCartId(rs.getInt(1));
				c.setCustEmail(rs.getString(2));
				c.setFoodName(rs.getString(3));
				c.setFoodtype(rs.getString(4));
				c.setFoodCategory(rs.getString(5));
				c.setFoodPrice(rs.getInt(6));
				c.setFoodQuantity(rs.getInt(7));

				clist.add(c);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clist;
	}

	@Override
	public Cart searchCartByid(int cartId) {
		System.out.println("search by id in Dao Impl");
		try {
			conn = DbConnection.getConnection();
			query = "select * from cart_22377 where cartid=?";

			ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Cart c = new Cart();
				c.setCartId(rs.getInt(1));

				c.setCustEmail(rs.getString(2));
				c.setFoodQuantity(rs.getInt(3));

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
