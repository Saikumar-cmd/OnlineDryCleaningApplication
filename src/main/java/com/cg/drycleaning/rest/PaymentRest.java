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

import com.cg.drycleaning.beans.Payment;
import com.cg.drycleaning.service.IPaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentRest {

	@Autowired
	private IPaymentService iPaymentService;

	@PostMapping("/add")
	public Payment addPayment(@RequestBody Payment payment) {
		Payment payment2 = null;
		payment2 = this.iPaymentService.addPayment(payment);
		return payment2;
	}

	@DeleteMapping("/remove/{id}")
	public Payment removePayment(@PathVariable("id") long id) {
		Payment payment = this.iPaymentService.removePayment(id);
		return payment;
	}

	@PutMapping("/update/{id}")
	public Payment updatePayment(@PathVariable("id") long id, @RequestBody Payment payment) {
		Payment payment2 = this.iPaymentService.updatePayment(id, payment);
		return payment2;
	}

	@GetMapping("/get/{id}")
	public Payment getPaymentDetails(@PathVariable("id") long id) {
		Payment payment = this.iPaymentService.getPaymentDetails(id);
		return payment;
	}

	@GetMapping("/all")
	public List<Payment> getAllPaymentDetails() {
		List<Payment> payments = this.iPaymentService.getAllPaymentDetails();
		return payments;
	}
}
