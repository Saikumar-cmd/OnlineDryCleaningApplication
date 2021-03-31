package com.cg.drycleaning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.Customer;
import com.cg.drycleaning.dao.ICustomerRepository;
import com.cg.drycleaning.exception.EmptyEntityListException;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityUpdationException;
import com.cg.drycleaning.validators.InputValidator;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private InputValidator inputValidator;

	@Override
	public Customer addCustomer(Customer customer) {

		if (!inputValidator.nameValidator(customer.getName()))
			throw new EntityCreationException("Enter a Valid Customer Name.");
		if (!inputValidator.userIdValidator(customer.getUserId()))
			throw new EntityCreationException("Enter a Valid UserId.");
		if (!inputValidator.contactValidator(customer.getContactNo()))
			throw new EntityCreationException("Enter a valid Contact Number.");
		if (!inputValidator.emailValidator(customer.getEmail()))
			throw new EntityCreationException("Enter a valid Email.");
		Customer customer2 = customerRepository.save(customer);
		return customer2;

	}

	@Override
	public Customer removeCustomer(String custId) {

		Optional<Customer> optionalCustomer = customerRepository.findById(custId);
		Customer customer = null;
		if (optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
			customerRepository.deleteById(custId);
			return customer;
		} else {
			throw new EntityDeletionException("Customer With Id " + custId + " does Not Exist.");
		}

	}

	@Override
	public Customer updateCustomer(String custId, Customer customer) {
		Optional<Customer> optionalCustomer = null;
		Customer customer2 = null;
		optionalCustomer = customerRepository.findById(custId);
		if (optionalCustomer.isPresent()) {
			customer2 = customerRepository.save(customer);
			return customer2;
		} else {
			throw new EntityUpdationException("Customer With Id " + custId + " does Not Exist.");
		}

	}

	@Override
	public Customer getCustomer(String custId) {
		Optional<Customer> optionalCustomer = null;
		Customer customer = null;
		optionalCustomer = customerRepository.findById(custId);
		if (optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
			return customer;
		} else {
			throw new EntityUpdationException("Customer With Id " + custId + " does Not Exist.");
		}

	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = new ArrayList<Customer>();
		allCustomers = customerRepository.findAll();
		if (!allCustomers.isEmpty()) {
			return allCustomers;
		} else {
			throw new EmptyEntityListException("No Customers Found.");
		}

	}

}
