package com.example.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.example.entities.Department;
import com.example.entities.Employee;

public class EmployeeDao 
{
	public static void main(String[] args)
	{
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Department d = new Department();
		d.setDepartmentId(1);
		d.setDepartmentName("Accounts");
		
		Employee e = new Employee();		
		e.setFirstName("Binod");
		e.setLastName("Bimali");
		e.setSalary(90000);
		e.setDept(d);
		
		Employee e1 = new Employee();
		e1.setFirstName("Kapil");
		e1.setLastName("Sharma");
		e1.setSalary(20000);
		e1.setDept(d);
		
		session.save(e);
		session.save(e1);
		
		t.commit();
		
		
		//Department fromDatabase = (Department) session.get(Department.class, 1);
		//System.out.println(fromDatabase.getDepartmentId() + " " + fromDatabase.getDepartmentName());
		
		//to query database
		Criteria c = session.createCriteria(Department.class);
		Criteria c1 = session.createCriteria(Employee.class);
		List<Employee> emplist = c1.list();
		for(Employee emp: emplist){
			System.out.println(emp.getEmpId()+""+emp.getFirstName()+""+emp.getLastName()+""+emp.getSalary());
		}
		//Printing using Iterator 
		Iterator it = emplist.iterator();
		while(it.hasNext()){
			Employee e10= (Employee) it.next();
			System.out.println(e10.getFirstName() + e10.getSalary());			
			
		}
		
		List<Department> deptList = c.list();
		for(Department a: deptList){
			System.out.println(a.getDepartmentId() + " " + a.getDepartmentName());
			
		}
		
		session.close();
		System.out.println("Done");
		
		
	}
}
