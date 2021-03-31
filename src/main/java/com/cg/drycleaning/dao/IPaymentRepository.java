package com.cg.drycleaning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.drycleaning.beans.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

}
