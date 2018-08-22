package com.espark.adarsh.persistence.repositories.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.repositories.InventoryRepository;
import com.espark.adarsh.persistence.repositories.construct.AbstractRepository;

@Repository
public class InventoryRepositoryImpl<E> extends AbstractRepository<Inventory> implements InventoryRepository<Inventory> {
	public InventoryRepositoryImpl() {
		super(Inventory.class);
	}
	
//	CreateJson createJson= new CreateJson();
//	public Inventory inventory;
//	public List<List<Object>> jsonString;
	@Override
	@Transactional
	public Collection<Inventory> getAllInventory() {
		return getAll();
		/*try {
			jsonString = createJson.CreateJsonMethod();
			inventory.setJsonString(jsonString.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inventory;*/
	}
	
	@Override
	public void refreshTask(Inventory inventory) {
		super.refresh(inventory);
	}
}
