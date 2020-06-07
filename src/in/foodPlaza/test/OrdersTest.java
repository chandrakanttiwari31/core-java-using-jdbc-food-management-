package in.foodPlaza.test;

import java.util.Scanner;

import in.foodPlaza.dao.OrderDaoImpl;
import in.foodPlaza.pojo.Order;

public class OrdersTest {

	public static void main(String[] args) {

		int orderId;
		String custEmail;
		String orderStatus;
		String orderDate;
		int totalBill;

		int choice;
		Scanner sc = new Scanner(System.in);

		Order order = null;
		OrderDaoImpl odi = new OrderDaoImpl();
		boolean result;
		char ch;

		System.out.println("***********Wellcome to food plaza*******");

		System.out.println("==============================================");

		System.out.println(" 1.place your order");
		System.out.println(" 2  . show my orders");
		System.out.println(" 3 . shaow all orders");

		System.out.println(" enter tour choice");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println("*********** place order********");
			System.out.println("===================================");
			System.out.println("enter your email");
			custEmail = sc.next();
			order = odi.placeOrder(custEmail);

			if (order != null) {

				System.out.println("order placed");
				System.out.println(order);
			}

			else {

				System.out.println(" order not palced");
			}

			break;
		}

	}

}
