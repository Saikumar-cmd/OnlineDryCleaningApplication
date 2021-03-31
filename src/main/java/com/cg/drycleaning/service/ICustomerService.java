package com.cg.drycleaning.service;

import java.util.List;

import com.cg.drycleaning.beans.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer);

	Customer removeCustomer(String custId);

	Customer updateCustomer(String custId, Customer customer);

	Customer getCustomer(String custId);

	List<Customer> getAllCustomers();
}