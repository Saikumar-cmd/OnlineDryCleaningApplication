package com.cg.drycleaning.beans;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	private long orderId;
	private double amount;
	private LocalDate billingDate;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private String paymentMethod;
	@OneToOne
	private Booking bookingDetails;

	public Order() {
		super();
	}

	public Order(long orderId, double amount, LocalDate billingDate, Customer customer, String paymentMethod,
			Booking bookingDetails) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customer = customer;
		this.paymentMethod = paymentMethod;
		this.bookingDetails = bookingDetails;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Booking getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(Booking bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
				+ customer + ", paymentMethod=" + paymentMethod + ", bookingDetails=" + bookingDetails + "]";
	}

}
