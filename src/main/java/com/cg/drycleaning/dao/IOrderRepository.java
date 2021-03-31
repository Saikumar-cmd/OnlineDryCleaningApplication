package com.cg.drycleaning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}
