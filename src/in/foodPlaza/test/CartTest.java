package in.foodPlaza.test;

import java.util.List;
import java.util.Scanner;

import in.foodPlaza.dao.CartDaoImpl;
import in.foodPlaza.dao.FoodDaoImpl;
import in.foodPlaza.pojo.Cart;
import in.foodPlaza.pojo.Food;

public class CartTest {
	public static void main(String[] args) {

		int cartId;
		int foodId;
		int foodQuantity;
		String custEmail;

		Scanner sc = new Scanner(System.in);

		int choice;
		Cart cart = null;
		CartDaoImpl cdi = new CartDaoImpl();

		boolean result;
		char ch;

		do {

			System.out.println("********************Foood Plaza*****************");
			System.out.println("=================================================");
			System.out.println(" 1. Add Cart");
			System.out.println(" 2. Update Cart ");
			System.out.println(" 3. Delete Cart");
			System.out.println(" 4. Show MyCart List");
			System.out.println(" 5. Show Cart List");
			System.out.println(" 6. Search Cart By Id");
			System.out.println("===================================================");
			System.out.println("\n Enter Your Choice");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("**********Add to cart**********");
				System.out.println("-------------------------------");
				System.out.println("**********Food List**************");
				List<Food> foodlist = new FoodDaoImpl().showFoodList();
				System.out.println("====================================");

				System.out.println("Enter Food Id");
				foodId = sc.nextInt();
				System.out.println("Enter Customer Email");
				custEmail = sc.next();
				cart = new Cart(custEmail, foodId);
				result = cdi.addCart(cart);
				if (result)
					System.out.println("food added successfully in cart");
				else
					System.out.println("food not added in cart");

				break;

			case 2:
				System.out.println("**********Update to cart**********");
				System.out.println("-------------------------------");
				System.out.println("Enter Cart Id");
				cartId = sc.nextInt();
				System.out.println("Enter  Food Quantity");
				foodQuantity = sc.nextInt();
				result = cdi.updateMyCart(foodQuantity, cartId);
				if (result)
					System.out.println("Update Successfully");
				else
					System.out.println("Not Updated");

			case 3:
				System.out.println("**********Delete to cart**********");
				System.out.println("-------------------------------");
				System.out.println("Ennter Cart id");
				cartId = sc.nextInt();
				result = cdi.deleteFromCart(cartId);
				if (result)
					System.out.println("delete  food successfully");
				else
					System.out.println("food not deleted");

				break;

			case 4:

				System.out.println("================Show My Cart=================");
				System.out.println("-----------------------------------------------");

				System.out.println("Enter Customer Email Id");
				custEmail = sc.next();

				List<Cart> cartlist = cdi.ShowMyCart(custEmail);
				if (!cartlist.isEmpty()) {

					for (Cart c : cartlist)

						System.out.println(c);
				}

				else
					System.out.println("Your Cart is Empty");
				break;

			case 5:

				System.out.println("================Show  CartList=================");
				System.out.println("-----------------------------------------------");
				List<Cart> clist = cdi.ShowCartList();
				for (Cart c : clist) {

					System.out.println(c);
				}
				break;

			case 6:

				System.out.println("================Search Cart By Id=================");
				System.out.println("-----------------------------------------------");
				System.out.println("Enter Cart ID");
				cartId = sc.nextInt();
				Cart c = cdi.searchCartByid(cartId);

				if (c != null)
					System.out.println(c);
				else
					System.out.println("Record Not Avaliable in This Id");

				break;
			}
//			default:
//				System.out.println("Please Enter  Proper Choice");
//			
			System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
