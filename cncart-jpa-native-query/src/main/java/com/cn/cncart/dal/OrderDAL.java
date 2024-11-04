package com.cn.cncart.dal;

import com.cn.cncart.entity.Order;

public interface OrderDAL {

	Order getOrderById(int id);

	void delete(int id);

	void save(Order saveOrder);

}
