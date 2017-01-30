/*create table department(
department_id integer,
dept_name varchar(40),
primary key(department_id)
);*/



package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department 
{
	@Id    
    @Column(name="department_id")
    private int departmentId;
     
    @Column(name="dept_name")
    private String departmentName;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
     
}
