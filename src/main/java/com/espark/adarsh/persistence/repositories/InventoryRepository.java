package com.espark.adarsh.persistence.repositories;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.entites.impl.Task;

public interface InventoryRepository<T> {
	public Collection<Inventory> getAllInventory();
	public void refreshInventory(Inventory inventory);
	public Boolean saveInventory(Inventory inventory);
	public Boolean updateInventory(Inventory inventory);
	public Boolean deleteInventory(Inventory inventory);
	public Inventory getInventory(Inventory inventory);
	public Inventory getInventoryById(Inventory inventory);
	public Inventory getInventoryByName(Inventory inventory);
	
}
