package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.example.entities.Employee;
import com.example.entities.Project;

public class EmployeeDao
{
	public static void main(String[] args)
	{
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Project p1 = new Project();
		p1.setProjectId(1);
		p1.setProjectName("Spring");
		Project p2 = new Project();
		p2.setProjectId(2);
		p2.setProjectName("Struts");		
		Project p3 = new Project();
		p3.setProjectId(200);
		p3.setProjectName("Hibernate");
		
		List<Project>p = new ArrayList<Project>();
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		Employee e1 = new Employee();
		e1.setFirstName("prakash");
		e1.setLastName("shiwakoti");
		e1.setSalary(100000);
		e1.setProjects(p);
		
		Employee e2 = new Employee();
		e2.setFirstName("Binod");
		e2.setLastName("Bimali");
		e2.setSalary(2000);
		e2.setProjects(p);
		
		Employee e3 = new Employee();
		e3.setFirstName("Binod");
		e3.setLastName("Bimali");
		e3.setSalary(2000);
		e3.setProjects(p);	
		
		
		session.save(e1);
		session.save(e2);
		
		t.commit();
		session.close();
		System.out.println("Done");
	}
}
