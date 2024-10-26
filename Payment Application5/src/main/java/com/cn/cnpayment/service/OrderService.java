package com.cn.cnpayment.service;

import com.cn.cnpayment.dal.OrderDal;
import com.cn.cnpayment.dal.PaymentDAL;
import com.cn.cnpayment.entity.Orders;
import com.cn.cnpayment.entity.Payment;
import com.cn.cnpayment.exception.NotFoundException;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
    Complete the OrderService class as mentioned below:

    a. Autowire OrderDal

    b. Complete the following methods:

      1. getOrderById(int id): This method fetches an Order for a specific Id.

      2. getAllOrders(): This method fetches the list of Orders.

      3. saveOrder(Orders newOrder): This method saves an Order.

      4. delete(int id): This method deletes an Order for a specific Id.
 **/

@Service
public class OrderService {

	// Autowire the OrderDal object.
	@Autowired
	OrderDal orderDal;
	
	@Autowired
	PaymentDAL paymentDAL;

	/**
     1. Complete the method body for getOrderById() by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public Orders getOrderById(int id) {
		Orders order = orderDal.getById(id);
		if(order == null)
			throw new NotFoundException("No order found with id:  " + id);
		return order;
	}


	/**
     1. Complete the method body for getAllOrders().
     2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public List<Orders> getAllOrders() {
		List<Orders> ordersList = orderDal.getAllOrders();
		if (ordersList == null)
			throw new NotFoundException("No order found.");
		return ordersList;
	}


	/**
     1. Complete the method body for saveOrder() method by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public void saveOrder(Orders newOrder) {
		Orders saveOrder = new Orders();
		saveOrder.setAmount(newOrder.getAmount());
		saveOrder.setCategory(newOrder.getCategory());
		saveOrder.setName(newOrder.getName());
		saveOrder.setQuantity(newOrder.getQuantity());
		
		List<Payment> paymentList = new ArrayList<Payment>();
		for(Payment payment: newOrder.getPayments()) {
			Payment currentPayment = paymentDAL.getById(payment.getId());
			paymentList.add(currentPayment);
		}
		saveOrder.setPayments(paymentList);
				
		orderDal.save(saveOrder);
	}


	/**
     1. Complete the method body for delete() method by adding proper arguments.
     2. add proper annotation for registering this method as a Transaction
	 **/
	@Transactional
	public void delete(int id) {
		//		Orders order = orderDal.getById(id);
		//		if(order == null)
		//			throw new NotFoundException("No order found with id:  " + id);

		orderDal.delete(id);
	}


}
