package com.spring.restful.TestREST;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee")
public class Employee {

	public Employee() {}
	
	public Employee(long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	private long id;
	private String name;
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
