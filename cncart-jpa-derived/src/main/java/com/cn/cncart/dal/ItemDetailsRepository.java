package com.cn.cncart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cn.cncart.entity.ItemDetails;

//public interface ItemDetailsRepository extends CrudRepository<ItemDetails, Integer>{
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer>{
//JpaRepository help in implementing derived query
	
	List<ItemDetails> findByPriceGreaterThan(Double price);

}
