package com.cn.cnpayment.dal;

import com.cn.cnpayment.entity.Orders;

import java.util.List;

public interface OrderDal {


    Orders getById(int id);

    void save(Orders orders);

    void delete(int id);

    List<Orders> getAllOrders();


}
