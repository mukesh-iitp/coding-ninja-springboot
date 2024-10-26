package com.cn.cncart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cn.cncart.dal.ItemDAL;
import com.cn.cncart.dal.ItemRepository;
import com.cn.cncart.entity.Item;

//import jakarta.transaction.Transactional;

@Service
public class ItemService {
	
	@Autowired
	//ItemDAL itemDAL; //HIBERNATE concept
	ItemRepository itemRepository;	//JPA Concept
	
	//@Transactional
	public Item getItemByID(int id) {
		//return itemDAL.getByID(id);
		return itemRepository.findById(id).get(); //optional.get will fetch the object
	}
	
	public List<Item> getAllItems() {
		List<Item> allItems = new ArrayList<Item>();	
		itemRepository.findAll().forEach(item -> allItems.add(item));
		return allItems;
	}
	
	//@Transactional
	public void saveItem(Item item) {
		//itemDAL.save(item);
		itemRepository.save(item);
	}

	//@Transactional
	public void delete(int id) {
		//itemDAL.delete(id);
		itemRepository.deleteById(id);
	}

	//@Transactional
	public void update(Item updatedItem) {
		//itemDAL.update(updatedItem);
		itemRepository.save(updatedItem);
	}

}
