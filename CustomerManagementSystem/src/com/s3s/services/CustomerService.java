package com.s3s.services;

import java.util.List;
import com.s3s.dao.CustomerDao;
import com.s3s.dao.ICustomerDao;
import com.s3s.models.Customer;


/**
 * Customer Service to expose various 
 * operation for customer
 * @author Biwan Chhetri
 * @since Nov 18, 2016
 */
public class CustomerService implements ICustomerService {

	ICustomerDao customerDao = new CustomerDao();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Customer> getCustomers() {
		return customerDao.getAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addCustomer(Customer customer) {
		boolean validate = false;
		if (customer.getId() > 0) {
			Customer c = customerDao.getById(customer.getId());
			if (c != null) {
				validate = false;
			}
		} else {
			validate = customerDao.add(customer);

		}
		return validate;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateCustomer(Customer customer) {
		return customerDao.update(customer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteCustomer(int id) {
		return customerDao.delete(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getById(id);
	}

}
