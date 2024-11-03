package com.cn.cncart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cncart.dal.ItemDetailsRepository;
import com.cn.cncart.entity.ItemDetails;

//import com.cn.cncart.dal.ItemDetailsDal;
//import jakarta.transaction.Transactional;

@Service
public class ItemDetailsService {

	@Autowired
	//ItemDetailsDal itemDetailsDal;
	ItemDetailsRepository itemDetailsRepository;
	
	
	//@Transactional
	public void delete(int id) {
		//itemDetailsDal.delete(id);
		itemDetailsRepository.deleteById(id);
	}


	public List<ItemDetails> getItemDetailsForPrice(double price) {
		return itemDetailsRepository.findByPriceGreaterThan(price);
	}

}
