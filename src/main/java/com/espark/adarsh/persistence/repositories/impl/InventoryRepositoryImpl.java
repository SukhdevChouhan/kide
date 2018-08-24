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
	public Boolean saveInventory(Inventory inventory) {
		super.put(inventory);
		return null;
	}
	
	@Override
	public Inventory getInventory(Inventory inventory) {
		return getUniqueByExample(inventory);
	}
	
	@Override
	@Transactional
	public Inventory getInventoryById(Inventory inventory) {
		return (Inventory) super.getEntityById(inventory);
	}
	
	@Override
	@Transactional
	public Inventory getInventoryByName(Inventory inventory) {
		return (Inventory) super.getByColumnName("issue_date", inventory.getInvDate());
	}
	
	@Override
	public Boolean deleteInventory(Inventory inventory) {
		super.remove(inventory);
		return null;
	}
	
	@Override
	public Boolean updateInventory(Inventory inventory) {
		super.update(inventory);
		return null;
	}
	
	@Override
	public void refreshInventory(Inventory inventory) {
		super.refresh(inventory);
	}

}
