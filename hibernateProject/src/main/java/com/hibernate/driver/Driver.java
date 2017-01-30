package com.hibernate.driver;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.hibernate.model.Customer;

public class Driver {
	
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setFirstName("Samuel");
		customer.setLastName("Jackson");
		customer.setAddress("LA");
		customer.setAge(54);
		customer.setEmail("samuel@hollywood.com");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(customer);
		}
		catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			tx.commit();
			session.close();
			HibernateUtil.shutdown();
		}
		
	}

}
