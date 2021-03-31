package com.cg.drycleaning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.drycleaning.beans.Order;
import com.cg.drycleaning.dao.IOrderRepository;
import com.cg.drycleaning.exception.EmptyEntityListException;
import com.cg.drycleaning.exception.EntityCreationException;
import com.cg.drycleaning.exception.EntityDeletionException;
import com.cg.drycleaning.exception.EntityUpdationException;

@Service
@Transactional

/************************************************************************************
 *          @author          Saikumar Tati
 *          Description      It is a service class that provides the services for adding new orders,remove orders,
 *          				update order and retrieve all the orders.
  *         Version             1.0
  *         Created Date    23-MARCH-2021
 ************************************************************************************/

public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	/************************************************************************************
	 * Method: addOrder
                *Description: To add the new orders
	 * @param Order       - order reference
	 * @returns Order     -returns Order Object
	 * @throws EntiryCreationException - It is raised due to problem in Entity  Creation.
                *Created By                                - Saikumar Tati
                *Created Date                            - 24-MARCH-2021                           
	 
	 ************************************************************************************/

	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			Order order1 = orderRepository.save(order);
			return order1;

		} catch (Exception e) {
			throw new EntityCreationException("Failed to Create Order.");
		}

	}
	
	/************************************************************************************
	 * Method: removeOrder
                *Description: To remove the existing orders
	 * @param id       - order id reference
	 * @returns Order  -returns Order Object
	 * @throws EntiryDeletionException - It is raised due to problem in Entity  Creation.
                *Created By                                - Saikumar Tati
                *Created Date                            - 24-MARCH-2021                           
	 
	 ************************************************************************************/

	@Override
	public Order removeOrder(long id) {

		Optional<Order> optionalOrder = orderRepository.findById(id);
		Order order = null;
		if (optionalOrder.isPresent()) {
			order = optionalOrder.get();
			orderRepository.deleteById(id);
			return order;
		} else {
			throw new EntityDeletionException("Order With Id " + id + " does not Exist.");
		}

	}

	@Override
	public Order updateOrder(long id, Order order) {
		Optional<Order> optionalOrder = null;
		Order order2 = null;

		optionalOrder = orderRepository.findById(id);
		if (optionalOrder.isPresent()) {
			order2 = orderRepository.save(order);
			return order2;
		} else {
			throw new EntityUpdationException("order With Id " + id + " does Not Exist.");
		}
	}

	@Override
	public Order getOrderDetails(long id) {
		Optional<Order> optionalorder = null;
		Order order = null;

		optionalorder = orderRepository.findById(id);
		if (optionalorder.isPresent()) {
			order = optionalorder.get();
			return order;
		} else {
			throw new EntityUpdationException("Order With Id " + id + " does Not Exist.");
		}
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> allOrderers = new ArrayList<Order>();

		allOrderers = orderRepository.findAll();
		if (!allOrderers.isEmpty()) {
			return allOrderers;
		} else {
			throw new EmptyEntityListException("No Orders Found.");
		}
	}

}
