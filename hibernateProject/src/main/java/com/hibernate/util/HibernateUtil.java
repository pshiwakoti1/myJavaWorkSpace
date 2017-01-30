package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory = createSessionFactory();

	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}



	private static SessionFactory createSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}

	public static void shutdown() {
		sessionFactory.close();
	}

}
