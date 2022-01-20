package com.torryharris.SpringJPADemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "person")
public class Person {
	@Id
	@Column(name= "aadhar", nullable = false)
	private long aadhar;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private long phone;
	
	public Person() {
		
	}
	
	public Person(long aadhar, String name, String address, long phone) {
		super();
		this.aadhar = aadhar;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public long getAadhar() {
		return aadhar;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [aadhar=" + aadhar + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	

}
