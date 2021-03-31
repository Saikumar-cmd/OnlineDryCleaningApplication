package com.cg.drycleaning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.CustomerItem;
import com.cg.drycleaning.dao.ICustomerItemRepository;
import com.cg.drycleaning.exception.EmptyEntityListException;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityUpdationException;

@Service
@Transactional
public class CustomerItemServiceImpl implements ICustomerItemService {
	@Autowired
	private ICustomerItemRepository customerItemRepository;

	@Override
	public CustomerItem addItem(CustomerItem customerItem) {
		try {
			CustomerItem customerItem2 = customerItemRepository.save(customerItem);
			return customerItem2;
		} catch (Exception e) {
			throw new EntityCreationException("Failed to create CustomerItem.");
		}
	}

	@Override
	public CustomerItem removeItem(long id) {

		Optional<CustomerItem> optionalCustomerItem = customerItemRepository.findById(id);
		CustomerItem customerItem = null;
		if (optionalCustomerItem.isPresent()) {
			customerItem = optionalCustomerItem.get();
			customerItemRepository.deleteById(id);
			return customerItem;
		} else {
			throw new EntityDeletionException("CustomerItem with ID " + id + " Cannot be Found");
		}

	}

	@Override
	public CustomerItem updateItem(long id, CustomerItem customerItem) {
		Optional<CustomerItem> optionalCustomerItem = null;
		CustomerItem customerItem1 = null;

		optionalCustomerItem = customerItemRepository.findById(id);
		if (optionalCustomerItem.isPresent()) {
			customerItem1 = customerItemRepository.save(customerItem);
			return customerItem1;
		} else {
			throw new EntityUpdationException("CustomerItem with ID " + id + " Cannot be Updated");

		}

	}

	@Override
	public CustomerItem getItem(long id) {
		CustomerItem customerItem = null;

		Optional<CustomerItem> optionalCustomerItem = customerItemRepository.findById(id);
		if (optionalCustomerItem.isPresent()) {
			customerItem = optionalCustomerItem.get();
			return customerItem;
		} else {
			throw new EntityNotFoundException("CustomerItem with ID " + id + " Cannot be Found");
		}

	}

	@Override
	public List<CustomerItem> getItemsByCustomer(String customerId) {
		List<CustomerItem> customerItems = new ArrayList<CustomerItem>();
		customerItems = customerItemRepository.getItemsByCustomer(customerId);
		if (!customerItems.isEmpty()) {
			return customerItems;
		} else {
			throw new EmptyEntityListException("No Items Found For Given Customer Id " + customerId);
		}

	}

}