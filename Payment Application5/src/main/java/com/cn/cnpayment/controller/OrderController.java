package com.cn.cnpayment.controller;

import com.cn.cnpayment.entity.Orders;
import com.cn.cnpayment.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
    # In the OrderController class complete the methods to handle HTTP requests with the required 
      annotation for the following APIs:

    a. POST "/order/save" ( RequestBody: Orders): It saves an order in the database.

    b. GET "/order/id/{id}": It fetches an order for a specific id.

    c. DELETE /order/id/{id}: It deletes an order for a specific Id.

    d. GET "/order/allOrders": It fetches the list of all orders from the database.

**/

@RestController
@RequestMapping("/order")
public class OrderController {

    // Autowire OrderService.
	@Autowired
	OrderService orderService;

    /**
     1. Call the required service method
     2. Add proper annotation for POST Mapping and attach the request-body to the method parameter.
     **/
	
	@PostMapping("/save")
    public void saveOrder(@RequestBody Orders newOrder){
		orderService.saveOrder(newOrder);
    }

    /**
     1. Call the required service method
     2. Add proper annotation for GET Mapping and attach the path-variable to the method parameter.
     **/
	@GetMapping("/id/{id}")
    public Orders getOrder(@PathVariable int id){
		return orderService.getOrderById(id);
    }

    /**
     1. Call the required service method
     2. Add proper annotation for DELETE Mapping and attach the path-variable to the method parameter.
     **/
	
	@DeleteMapping("/id/{id}")
    public void deleteOrder(@PathVariable int id){
		orderService.delete(id);
    }
    /**
     1. Call the required service method
     **/
	@GetMapping("/allOrders")
    public List<Orders> getAllOrders(){
    	return orderService.getAllOrders();
    }
}
