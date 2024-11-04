package com.cn.cncart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cn.cncart.entity.ItemDetails;

//public interface ItemDetailsRepository extends CrudRepository<ItemDetails, Integer>{
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer>{
//JpaRepository help in implementing derived query
	
	//derived query
	List<ItemDetails> findByPriceGreaterThan(Double price);

	//JPQL
	@Query("Select itd From ItemDetails itd Where itd.category=?1 Order By itd.price Desc")
	List<ItemDetails> findByCatagoryOrderByPrice(String category);

	//JPQL
	@Query("SELECT COUNT(itd.category) itd FROM ItemDetails itd WHERE itd.category=?1")
	Integer countByCatagory(String category);

}
