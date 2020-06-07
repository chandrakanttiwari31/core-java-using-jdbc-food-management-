package in.foodPlaza.dao;

import java.util.List;

import in.foodPlaza.pojo.Cart;

public interface CartDao {

	boolean addCart(Cart c);

	boolean deleteFromCart(int cartId);

	boolean updateMyCart(int foodQuantity, int cartId);

	List<Cart> ShowMyCart(String custEmail);

	List<Cart> ShowCartList();

	Cart searchCartByid(int cartId);

}
