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

import com.cg.drycleaning.beans.CustomerItem;
import com.cg.drycleaning.service.ICustomerItemService;

@RestController
@RequestMapping("/customeritem")
public class CustomerItemRest {
	@Autowired
	private ICustomerItemService iCustomerItemService;

	@PostMapping("/add")
	public CustomerItem addItem(@RequestBody CustomerItem customerItem) {
		CustomerItem customerItem2 = this.iCustomerItemService.addItem(customerItem);
		return customerItem2;
	}

	@DeleteMapping("/delete/{id}")
	public CustomerItem removeItem(@PathVariable long id) {
		CustomerItem customerItem = this.iCustomerItemService.removeItem(id);
		return customerItem;
	}

	@PutMapping("/update/{id}")
	public CustomerItem updateItem(@PathVariable long id, @RequestBody CustomerItem customerItem) {
		CustomerItem customerItem2 = this.iCustomerItemService.updateItem(id, customerItem);
		return customerItem2;
	}

	@GetMapping("/get/{id}")
	public CustomerItem getItem(@PathVariable long id) {
		CustomerItem customerItem = this.iCustomerItemService.getItem(id);
		return customerItem;
	}

	@GetMapping("/getbycustomer/{id}")
	public List<CustomerItem> getItemsByCustomer(@PathVariable("id") String customerId) {
		List<CustomerItem> customerItems = this.iCustomerItemService.getItemsByCustomer(customerId);
		return customerItems;
	}

}
