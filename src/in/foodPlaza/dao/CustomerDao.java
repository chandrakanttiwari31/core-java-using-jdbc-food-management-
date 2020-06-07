package in.foodPlaza.dao;

import java.util.List;

import in.foodPlaza.pojo.Customer;

public interface CustomerDao {


	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int custId);
	
	List<Customer> ShowCustomerList();
	Customer searchCustomerById(int custId);
	Customer searchCustomerByEmail(String custEmail);
	
	
}
