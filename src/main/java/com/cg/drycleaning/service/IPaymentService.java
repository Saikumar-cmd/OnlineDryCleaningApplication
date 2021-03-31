package com.cg.drycleaning.service;

import java.util.List;

import com.cg.drycleaning.beans.Payment;

public interface IPaymentService {

	Payment addPayment(Payment payment);

	Payment removePayment(long id);

	Payment updatePayment(long id, Payment payment);

	Payment getPaymentDetails(long id);

	List<Payment> getAllPaymentDetails();

}
