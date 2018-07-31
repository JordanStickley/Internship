package com.oreillyauto.projecttemplate.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Immutable
@Table(name = "yahoo")
@Entity
public class Yahoo implements Serializable {

	private static final long serialVersionUID = 7544709035371614421L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INTEGER")
	private String id;

	@Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(64)")
	private String firstName;
	
	@Column(name = "LAST_NAME", columnDefinition = "VARCHAR(64)")
	private String lastName;

	@Column(name = "AGE", columnDefinition = "INTEGER")
	private Integer age;
	
	@Column(name = "START_DATE", columnDefinition = "DATE")
	private Date startDate;
	
	@Column(name = "ACTIVE", columnDefinition = "BOOLEAN")
	private Boolean active;

	
	

	public Yahoo() {
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}




	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}




	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}




	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}




	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}




	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}




	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public Yahoo(String id, String firstName, String lastName, Integer age, Date startDate, Boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.startDate = startDate;
		this.active = active;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Yahoo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", startDate=" + startDate + ", active=" + active + "]";
	}

	
}
