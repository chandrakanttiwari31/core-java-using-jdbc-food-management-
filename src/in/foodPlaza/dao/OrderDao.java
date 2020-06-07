package in.foodPlaza.dao;

import java.util.List;

import in.foodPlaza.pojo.Order;

public interface OrderDao {

	
	Order placeOrder(String  custEmail);
	List<Order> ShowMyOrders(String custEmail);
	List<Order> showAllOrders();
	
}
