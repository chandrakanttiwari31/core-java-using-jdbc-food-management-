package in.foodPlaza.test;

import java.util.List;
import java.util.Scanner;

import in.foodPlaza.dao.CustomerDaoImpl;
import in.foodPlaza.dao.FoodDaoImpl;
import in.foodPlaza.pojo.Customer;
import in.foodPlaza.pojo.Food;

public class CustomerTest {
	public static void main(String[] args) {

		int custId;
		String custName;
		String custEmail;
		String custContact;
		String custAddress;
		String custPassword;
		String custConfirmpassword;

		Customer customer = null;
		CustomerDaoImpl cdi = new CustomerDaoImpl();

		boolean result;

		Scanner sc = new Scanner(System.in);

		int choice;
		char ch;

		do {

			System.out.println("********************Foood Plaza*****************");
			System.out.println("=================================================");
			System.out.println(" 1. Add Food");
			System.out.println(" 2. Update Food ");
			System.out.println(" 3. DeleteFood");
			System.out.println(" 4. Show Food List");
			System.out.println(" 5. Search Food By Id");
			System.out.println(" 6. Search Food By Email");
			System.out.println("===================================================");
			System.out.println("\n Enter Your Choice");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("**********Adding customer process");
				System.out.println("-------------------------------");

//				 
				System.out.println("Enter Customer Name");
				custName = sc.next();
				System.out.println("Enter Customer Email");
				custEmail = sc.next();
				System.out.println("Enter Customer Contact");
				custContact = sc.next();

				System.out.println("Enter Customer Address");
				custAddress = sc.next();
				System.out.println("Enter Customer Password");
				custPassword = sc.next();
				System.out.println("Enter Customer Confirm Password");
				custConfirmpassword = sc.next();

				customer = new Customer(custName, custEmail, custContact, custAddress, custPassword,
						custConfirmpassword);
				result = cdi.addCustomer(customer);
				if (result) {

					System.out.println(" **********Record Inserted***********");
				} else {

					System.out.println(" ***********Record Not Inserted*************");
				}

				break;

			case 2:

				System.out.println("**********Updating customer process");
				System.out.println("-------------------------------");

				System.out.println("Enter Customer Id Which You Want To  Update");
				custId = sc.nextInt();
				System.out.println("Enter Customer Name");
				custName = sc.next();
				System.out.println("Enter Customerr Email");
				custEmail = sc.next();
				System.out.println("Enter Customerr Contact");
				custContact = sc.next();

				System.out.println("Enter Customer Address");
				custAddress = sc.next();
				System.out.println("Enter Customerr Password");
				custPassword = sc.next();
				System.out.println("Enter Customer Confirm Password");
				custConfirmpassword = sc.next();

				customer = new Customer(custId, custName, custEmail, custContact, custAddress, custPassword,
						custConfirmpassword);

				result = cdi.updateCustomer(customer);
				if (result) {

					System.out.println("update");
				} else {

					System.out.println("not update");
				}
				break;

			case 3:
				System.out.println("**********deleting operation*********");
				System.out.println("--------------------------------------");
				System.out.println("Enter  Customer ID");
				custId = sc.nextInt();

				result = cdi.deleteCustomer(custId);
				if (result)
					System.out.println("delete  food successfully");
				else
					System.out.println("food not deleted");

				break;

			case 4:

				System.out.println("***************Customer  List************");
				System.out.println("=====================================");

				List<Customer> custlist = cdi.ShowCustomerList();
				if (!custlist.isEmpty()) {
					for (Customer c : custlist) {

						System.out.println(c);
					}

				} else {

					System.out.println("food list empty");
				}

				break;

			case 5:

				System.out.println("**********Searching  Customer By Id In Record");
				System.out.println("-------------------------------");

				System.out.println("Enter Customer ID");
				custId = sc.nextInt();
				customer = cdi.searchCustomerById(custId);

				if (customer != null)
					System.out.println(customer);
				else
					System.out.println("Record Not Avaliable in This Id");

				break;

			case 6:

				System.out.println("**********Searching  Customer By Email In Record");
				System.out.println("-------------------------------");

				System.out.println("Enter Customer Email");
				custEmail = sc.next();
				customer = cdi.searchCustomerByEmail(custEmail);

				if (customer != null)
					System.out.println(customer);
				else
					System.out.println("Record Not Avaliable in This Email");

				break;

			}
			System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}

}
