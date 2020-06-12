package in.foodPlaza.test;

import java.util.List;
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

		Order order = new Order();
		OrderDaoImpl odi = new OrderDaoImpl();
		boolean result;
		char ch;

		System.out.println("***********Wellcome to food plaza*******");

		System.out.println("==============================================");
do
{
		System.out.println(" 1.place your order");
		System.out.println(" 2.show my orders");
		System.out.println(" 3. shaow all orders");

		System.out.println(" Enter your choice");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
			System.out.println("*********** place order********");
			System.out.println("===================================");
			System.out.println("enter your email");
			custEmail = sc.next();
			order = odi.placeOrder(custEmail);

			if (order != null) {

			
				System.out.println(order);
			}

			else {

				System.out.println(" order not palced");
			}

			break; 
			
			
			
		case 2:
			
			
			System.out.println("Enter Email -Id");
			order.setCustEmail(sc.next());
			List<Order> l=odi.ShowMyOrders(order.getCustEmail());
			if(! l.isEmpty())
			{
				
				for(Order oo:l)
				{
					
					System.out.println(oo);
				}
			}
			else
				System.out.println("record not available for this email-id");
			break;
			
			
		case  3:
			
			System.out.println("Order List");
			List<Order> list=odi.showAllOrders();
			if(! list.isEmpty())
			{
				
				for(Order oo:list)
				{
					
					System.out.println(oo);
				}
			}
			else
				System.out.println("record not available for this email-id");
			break;
			
			
			default:
	    		System.out.println("Bye bye.....");
	     		
	     }
	     System.out.println("Do you want to continue .......if yes enter y.....:");
      ch=sc.next().charAt(0);
	     }while(ch=='y'||ch=='y');
		}

	}


