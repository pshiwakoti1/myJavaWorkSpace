package com.s3s.dao;

import java.util.List;
import com.s3s.models.Customer;

/**
 * Data access for customer
 * 
 * @author Biwan chhetri
 * @since Nov 17, 2016
 */
public interface ICustomerDao {
	
	/**
	 * adds customer to the database.
	 * @param customer to be added
	 * @return success or fail
	 */
	public boolean add(Customer customer);
	
	/**
	 * Gets customer by id
	 * @param id of the customer
	 * @return customer object
	 */
	public Customer getById(int id);
	
	/**
	 * Update customer
	 * @param customer to be updated
	 * @return success or fail
	 */
	public boolean update(Customer customer);
	
	/**
	 * Gets all customer
	 * @return list of customer;
	 */
	public List<Customer> getAll();
	
	/**
	 * Delete customer by id
	 * @param id of customer
	 * @return delete success or not
	 */
	public boolean delete(int id);
	
	
	/**
	 * Adds all the customers to the database
	 * @param customers
	 * @return
	 */
	public boolean addAllCustomer(List<Customer> customers);

}
