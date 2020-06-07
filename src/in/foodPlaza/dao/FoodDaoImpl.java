package in.foodPlaza.dao;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.foodPlaza.pojo.Food;
import in.foodPlaza.test.utility.DbConnection;

public class FoodDaoImpl implements FoodDao {

	ResultSet rs;
	PreparedStatement ps = null;
	String query;
	int ans;
	Connection conn = null;

	public boolean addFood(Food food) {
		// TODO Auto-generated method stub

		try {
			System.out.println("inside insert food in daoimpl");

			conn = DbConnection.getConnection();

			query = "insert into food_22377(foodname,foodtype,foodcategory,foodprice) values(?,?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodType());
			ps.setString(3, food.getFoodCategory());

			ps.setDouble(4, food.getFoodPrice());
			ans = ps.executeUpdate();
			System.out.println("ans" + ans);
			if (ans > 0)
				return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean updateFood(Food food) {
		try {

			System.out.println("inside update food inf dao impl");
			conn = DbConnection.getConnection();
			query = "update food_22377 set foodname=?,foodcategory=?,foodtype=?,foodprice=? where foodid=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodCategory());
			ps.setString(3, food.getFoodType());
			ps.setDouble(4, food.getFoodPrice());
			ps.setInt(5, food.getFoodId());
			ans = ps.executeUpdate();
			System.out.println(ans);

			if (ans > 0)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteFood(int foodId) {

		try {
			System.out.println(" inside delete odd in daoimpl");

			conn = DbConnection.getConnection();
			query = "delete from food_22377 where foodid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, foodId);
			ans = ps.executeUpdate();
			System.out.println("ans" + ans);
			if (ans > 0)
				return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

	public List<Food> showFoodList() {

		List<Food> foodlist = new ArrayList<Food>();

		try {
			System.out.println("inside foodlist in daoimpl");

			conn = DbConnection.getConnection();
			query = "select * from food_22377";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {

				Food food = new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));

				food.setFoodCategory(rs.getString(4));
				food.setFoodPrice(rs.getDouble(5));

				foodlist.add(food);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return foodlist;
	}

	public Food searchFoodById(int foodId) {
		try {
			Food food = null;
			System.out.println("inside searching in daoimpl");

			conn = DbConnection.getConnection();
			query = "select * from food_22377  where foodid=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, foodId);
			rs = ps.executeQuery();

			while (rs.next()) {

				food = new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));

				food.setFoodCategory(rs.getString(4));
				food.setFoodPrice(rs.getDouble(5));
				;

			}
			return food;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<Food> searchFoodByName(String foodName) {
		Food food = new Food();
		List<Food> fl = new ArrayList<Food>();
		try {

			System.out.println("inside searching in daoimpl");

			conn = DbConnection.getConnection();
			query = "select * from food_22377  where foodname=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, foodName);
			rs = ps.executeQuery();

			while (rs.next()) {

				food = new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));

				food.setFoodCategory(rs.getString(4));
				food.setFoodPrice(rs.getDouble(5));
				;
				fl.add(food);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fl;
	}

	public List<Food> searcFoodByType(String foodType) {
		Food food = new Food();
		List<Food> fl = new ArrayList<Food>();
		try {

			System.out.println("inside searching in daoimpl");

			conn = DbConnection.getConnection();
			query = "select * from food_22377  where foodtype=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, foodType);
			rs = ps.executeQuery();

			while (rs.next()) {

				food = new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));

				food.setFoodCategory(rs.getString(4));
				food.setFoodPrice(rs.getDouble(5));
				;
				fl.add(food);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fl;
	}

	public List<Food> searchFoodByCategory(String foodCategory) {
		Food food = new Food();
		List<Food> fl = new ArrayList<Food>();
		try {

			System.out.println("inside searching in daoimpl");

			conn = DbConnection.getConnection();
			query = "select * from food_22377  where foodcategory=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, foodCategory);
			rs = ps.executeQuery();

			while (rs.next()) {

				food = new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));

				food.setFoodCategory(rs.getString(4));
				food.setFoodPrice(rs.getDouble(5));
				;
				fl.add(food);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return fl;
	}

}
