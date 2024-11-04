package com.cn.cncart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cn.cncart.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	//1st Parameter is item entity
	//2nd Parameter is data type of unique id
	
	//Native Query
	//@Query("SELECT * FROM item WHERE description LIKE 'Iphone%' Limit 2;")
	@Query(value = "SELECT * FROM item WHERE description LIKE :desc% Limit 2;", nativeQuery = true)
	List<Item> getItemByDesc(@Param("desc") String desc);

}
