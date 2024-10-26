package com.cn.cncart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cncart.service.ItemDetailsService;

@RestController
@RequestMapping("/itemDetails")
public class ItemDetailsController {
	
	@Autowired
	ItemDetailsService itemDetailsService;
	
	@DeleteMapping("/delete/id/{id}")
	public void delete(@PathVariable int id){
		itemDetailsService.delete(id);
	}

}
