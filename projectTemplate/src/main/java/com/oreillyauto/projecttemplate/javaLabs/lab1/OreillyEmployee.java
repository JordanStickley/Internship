package com.oreillyauto.projecttemplate.javaLabs.lab1;

import java.io.Serializable;

import java.math.BigDecimal;

public class OreillyEmployee implements Serializable {

	private static final long serialVersionUID = -3576700465505900126L;
	private long id;
	private Integer age;
	private String name;
	private BigDecimal salary;
	private String title;
	
	
	public OreillyEmployee(long id, Integer age, String name, BigDecimal salary, String title) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.title = title;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
