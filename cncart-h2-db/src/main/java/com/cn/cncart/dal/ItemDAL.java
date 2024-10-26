package com.cn.cncart.dal;

import com.cn.cncart.entity.Item;

public interface ItemDAL {
	
	Item getByID(int id);

	void save(Item item);

	void delete(int id);

	void update(Item updatedItem);

}
