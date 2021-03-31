package com.cg.drycleaning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}
