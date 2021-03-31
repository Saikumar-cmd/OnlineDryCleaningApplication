package com.cg.drycleaning.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer {
	@Id
	private String userId;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate dob;
	@Embedded
	private Address address;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<CustomerItem> customerItems;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> orders;

	public Customer() {
		super();
	}

	public Customer(String userId, String name, String email, String contactNo, LocalDate dob, Address address,
			List<CustomerItem> customerItems, List<Order> orders) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
		this.customerItems = customerItems;
		this.orders = orders;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonManagedReference
	public List<CustomerItem> getCustomerItems() {
		return customerItems;
	}

	public void setCustomerItems(List<CustomerItem> customerItems) {
		this.customerItems = customerItems;
	}

	@JsonManagedReference
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", dob=" + dob + ", address=" + address + ", customerItems=" + customerItems + ", orders=" + orders
				+ "]";
	}

}