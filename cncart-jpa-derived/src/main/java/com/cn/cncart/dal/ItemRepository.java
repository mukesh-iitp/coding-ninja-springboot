package com.cn.cncart.dal;

import org.springframework.data.repository.CrudRepository;

import com.cn.cncart.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	//1st Parameter is item entity
	//2nd Parameter is data type of unique id

}
