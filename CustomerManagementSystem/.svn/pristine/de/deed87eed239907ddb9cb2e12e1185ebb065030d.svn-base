package com.s3s.services;

import java.util.List;

import com.s3s.models.Customer;

/**
 * Customer Service to perform various 
 * operation related to customer.
 * @author Biwan Chhetri
 * @since Nov 17, 2016
 */
public interface ICustomerService {
	
	/**
	 * Gets all customers
	 * @return customer list
	 */
	public List<Customer> getCustomers();
	
	/**
	 * Adds customer to the system
	 * @param customer customer instance to add
	 * @return if added successfully or not
	 */
	public boolean addCustomer(Customer customer);
	
	/**
	 * Updates the customer passed
	 * @param customer to be updated
	 * @return if update successful or not
	 */
	public boolean updateCustomer(Customer customer);
	
	
	/**
	 * Remove the customer from system
	 * @param id of customer to be deleted
	 * @return deletion successful or not
	 */
	public boolean deleteCustomer(int id);
	
	
	/**
	 * Gets customer by id
	 * @param id of customer to retrieve
	 * @return customer instance
	 */
	public Customer getCustomerById(int id);
}
