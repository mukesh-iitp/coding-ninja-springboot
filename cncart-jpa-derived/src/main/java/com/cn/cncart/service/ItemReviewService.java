package com.cn.cncart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cncart.dal.ItemReviewDAL;
import com.cn.cncart.entity.ItemReview;

import jakarta.transaction.Transactional;

@Service
public class ItemReviewService {

	@Autowired
	ItemReviewDAL itemReviewDAL;
	
	@Transactional
	public void save(ItemReview review) {
		
		itemReviewDAL.save(review);
		
	}
	
	

}
