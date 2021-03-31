package com.cg.drycleaning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.CustomerItem;

@Repository
public interface ICustomerItemRepository extends JpaRepository<CustomerItem, Long> {

	@Query(value = "SELECT customerItem FROM CustomerItem customerItem WHERE customerItem.customer.userId=:customerId")
	List<CustomerItem> getItemsByCustomer(@Param(value = "customerId") String customerId);

}