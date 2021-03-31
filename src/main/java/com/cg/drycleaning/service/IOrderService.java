package com.cg.drycleaning.service;

import com.cg.drycleaning.beans.Order;

import java.util.List;

public interface IOrderService {

	Order addOrder(Order order);

	Order removeOrder(long id);

	Order updateOrder(long id, Order order);

	Order getOrderDetails(long id);

	List<Order> getAllOrders();
}
