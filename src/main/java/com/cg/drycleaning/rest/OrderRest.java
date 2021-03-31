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

import com.cg.drycleaning.beans.Order;
import com.cg.drycleaning.service.IOrderService;

import io.swagger.annotations.Api;

@Api(value = "Swagger2DemoRestController")
@RestController
@RequestMapping("/order")
public class OrderRest {
	@Autowired
	private IOrderService iOrderService;

	@PostMapping("/add")
	public Order addOrder(@RequestBody Order order) {
		Order order2 = null;
		order2 = this.iOrderService.addOrder(order);
		return order2;
	}

	@GetMapping("/get/{id}")
	public Order getOrderDetails(@PathVariable("id") long id) {
		Order order = this.iOrderService.getOrderDetails(id);
		return order;
	}

	@DeleteMapping("/delete/{id}")
	public Order removeOrder(@PathVariable("id") long id) {
		Order order = this.iOrderService.removeOrder(id);
		return order;
	}

	@GetMapping("/all")
	public List<Order> getAllOrders() {
		List<Order> orders = this.iOrderService.getAllOrders();
		return orders;
	}

	@PutMapping("/update")
	public Order updateOrder(@PathVariable long id, @RequestBody Order order) {
		Order order2 = this.iOrderService.updateOrder(id, order);
		return order2;
	}

}
