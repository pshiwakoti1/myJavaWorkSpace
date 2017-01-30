package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Customer;

public class CustomerDao {

	private SessionFactory sessionFactory;
	
	
	public boolean add(Customer customer){
		
	   Session session = sessionFactory.getCurrentSession();
		session.save(customer);
	   return false;
		
	}
	@Transactional
	@Override
	public boolean delete(int id) {
		boolean status = false;
		Session session = sessionFactory.getCurrentSession();
		try {
			Customer customer = session.get(Customer.class, id);
			session.delete(customer);
			status = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return status;
	}
	@Transactional
	@Override
	public boolean addAllCustomer(List<Customer> customers) {
		boolean result = false;
		if (customers == null || customers.size() == 0) {
			return false;
		}
		Session session = sessionFactory.getCurrentSession();
		for (int i = 0; i < customers.size(); i++) {
			session.save(customers.get(i));
			if (i % 20 == 0) { // 20, same as the JDBC batch size
				// flush a batch of inserts and release memory:
				session.flush();
				session.clear();
			}
			boolean isLastCustomer = customers.size() - 1 == i;
			if (isLastCustomer) {
				result = true;
				break;
			}
		}
		return result;
	}

    
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
