package com.cg.drycleaning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.Payment;
import com.cg.drycleaning.dao.IPaymentRepository;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityUpdationException;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {

		try {
			Payment payment2 = paymentRepository.save(payment);
			return payment2;
		} catch (Exception e) {
			throw new EntityCreationException("Failed to Create Payment");
		}
	}

	@Override
	public Payment removePayment(long id) {

		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		Payment payment = null;
		if (optionalPayment.isPresent()) {
			payment = optionalPayment.get();
			paymentRepository.deleteById(id);
			return payment;

		} else {
			throw new EntityDeletionException("Payment with Id " + id + " cannot be found");
		}

	}

	@Override
	public Payment updatePayment(long id, Payment payment) {
		Optional<Payment> optionalPayment = null;
		Payment payment2 = null;
		optionalPayment = paymentRepository.findById(id);
		if (optionalPayment.isPresent()) {
			payment2 = paymentRepository.save(payment);
			return payment2;
		} else {
			throw new EntityUpdationException("Payment with Id " + id + " cannot be updated");
		}

	}

	@Override
	public Payment getPaymentDetails(long id) {
		Payment payment = null;
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		if (optionalPayment.isPresent()) {
			payment = optionalPayment.get();
			return payment;
		} else {
			throw new EntityNotFoundException("Payment with Id " + id + " cannot be found");
		}

	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> allPayments = new ArrayList<Payment>();
		allPayments = paymentRepository.findAll();
		if (!allPayments.isEmpty()) {
			return allPayments;
		} else {
			throw new EntityNotFoundException("No Payments Found");
		}

	}

}