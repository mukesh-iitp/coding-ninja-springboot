package com.cn.cncart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cncart.dal.ItemDAL;
import com.cn.cncart.entity.Item;

import jakarta.transaction.Transactional;

@Service
public class ItemService {
	
	@Autowired
	ItemDAL itemDAL;
	
	@Transactional
	public Item getItemByID(int id) {
		return itemDAL.getByID(id);
	}
	
	@Transactional
	public void saveItem(Item item) {
		itemDAL.save(item);
	}

	@Transactional
	public void delete(int id) {
		itemDAL.delete(id);
	}

	@Transactional
	public void update(Item updatedItem) {
		itemDAL.update(updatedItem);
	}

}
