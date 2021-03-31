package com.cg.drycleaning.service;

import java.util.List;

import com.cg.drycleaning.beans.CustomerItem;

public interface ICustomerItemService {

	CustomerItem addItem(CustomerItem customerItem);

	CustomerItem removeItem(long id);

	CustomerItem updateItem(long id, CustomerItem customerItem);

	CustomerItem getItem(long id);

	List<CustomerItem> getItemsByCustomer(String customerId);

}