package com.cg.drycleaning.test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.drycleaning.beans.Address;
import com.cg.drycleaning.beans.Booking;
import com.cg.drycleaning.beans.Customer;
import com.cg.drycleaning.beans.Order;
import com.cg.drycleaning.dao.IOrderRepository;
import com.cg.drycleaning.service.IOrderService;

@SpringBootTest
public class OrderServiceTest {
	@Autowired
	private IOrderService orderService;
	@Autowired
	private IOrderRepository orderRepository;
	
	@Test
	public void getOrderDetailsTest()
	{
		assertEquals(500,orderService.getOrderDetails(102).getAmount() );
		assertEquals(102,orderService.getOrderDetails(102).getOrderId() );
		assertEquals("Card",orderService.getOrderDetails(102).getPaymentMethod());
		
	}
	@Test
	void deleteOrderTest()
	{
		long orderId=101;
		 orderService.removeOrder(orderId);
		boolean notexist=orderRepository.findById(orderId).isPresent();

		
	
		assertFalse(notexist);
		
	}
	@Test
	public void addOrderTest()
	{
		
		Address address= new Address("201","de think","Bagla","Pune","MH",404505);

		Customer customer=new Customer("him123","Prashant","pras@gmail.com","9563178533", null, address, null, null);
		
		Order order= new Order(104,40000,null,customer,"Card",null);
		Order savedOrder=orderService.addOrder(order);
		assertNotNull(savedOrder);
		
	}
	@Test
	public void updateOrderTest() {
		Address address= new Address("201","de think","Bagla","Pune","MH",404505);

		Customer customer=new Customer("him123","Prashant","pras@gmail.com","9563178533", null, address, null, null);
		
		Order order= new Order(104,40000,null,customer,"Card",null);
		Order savedOrder=orderService.addOrder(order);
		order.setAmount(4000);
		assertEquals(4000, orderService.updateOrder(104, order).getAmount());
	}
	@Test
	public void getAllOrderTest() {
		assertEquals(3, orderService.getAllOrders().size());
	}
	

}
