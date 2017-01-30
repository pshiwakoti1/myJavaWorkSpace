/*create table project(
project_id integer,
project_name varchar(40),
primary key(project_id)
);
*/



package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project 
{
	@Id
	@Column(name = "project_id")
	private int projectId;
	
	@Column(name = "project_name")
	private String projectName;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
