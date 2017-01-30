package com.hibernate.driver;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.hibernate.model.Customer;
import com.hibernate.model.Order;


public class Driver2 {
	
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setFirstName("Samuel");
		customer.setLastName("Jackson");
		customer.setAddress("LA");
		customer.setAge(54);
		customer.setEmail("samuel@hollywood.com");
		
		Order order1 = new Order();
		order1.setOrderName("Pizza");
		order1.setPrice(22);
		order1.setCustomer(customer);
		
		Order order2 = new Order();
		order2.setOrderName("Burger");
		order2.setPrice(30);
		order2.setCustomer(customer);
		
		Order order3 = new Order();
		order3.setOrderName("Momo");
		order3.setPrice(50);
		order3.setCustomer(customer);
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		customer.setOrders(orders);
		
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
