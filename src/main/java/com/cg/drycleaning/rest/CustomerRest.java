package com.cg.drycleaning.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.drycleaning.beans.Customer;
import com.cg.drycleaning.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

	@Autowired
	private ICustomerService iCustomerService;

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer customer2 = null;
		customer2 = this.iCustomerService.addCustomer(customer);
		return customer2;
	}

	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = this.iCustomerService.getAllCustomers();
		return customers;
	}

	@GetMapping("/get/{id}")
	public Customer getCustomer(@PathVariable("id") String custId) {
		Customer customer = this.iCustomerService.getCustomer(custId);
		return customer;
	}

	@DeleteMapping("/delete/{id}")
	public Customer removeCustomer(@PathVariable("id") String custId) {
		Customer customer = this.iCustomerService.removeCustomer(custId);
		return customer;
	}

	@PutMapping("/update/{id}")
	public Customer updateCustomer(@PathVariable("id") String custId, @RequestBody Customer customer) {
		Customer customer2 = this.iCustomerService.updateCustomer(custId, customer);
		return customer2;
	}

}
