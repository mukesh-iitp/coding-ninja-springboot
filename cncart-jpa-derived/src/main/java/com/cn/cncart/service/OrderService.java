package com.cn.cncart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cn.cncart.dal.ItemDAL;
import com.cn.cncart.dal.OrderDAL;
import com.cn.cncart.entity.Item;
import com.cn.cncart.entity.Order;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	OrderDAL orderDal;
	
	//@Autowired
	//ItemDAL itemDal;

	@Transactional
	public Order getOrderById(int id) {
		return orderDal.getOrderById(id);
	}

//	@Transactional
//	public void saveOrder(Order order) {
//		Order saveOrder = new Order();
//		saveOrder.setOrderType(order.getOrderType());
//		
//		List<Item> itemList = new ArrayList<Item>();
//		for(Item item: order.getItems()) {
//			Item currentItem = itemDal.getByID(item.getId());
//			itemList.add(currentItem);
//		}
//		saveOrder.setItems(itemList);
//		
//		orderDal.save(saveOrder);
//	}

	@Transactional
	public void delete(int id) {
		orderDal.delete(id);		
	}

}
