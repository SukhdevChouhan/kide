package com.espark.adarsh.persistence.repositories;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.entites.impl.Task;

public interface InventoryRepository<T> {
	public Collection<Inventory> getAllInventory();

	public void refreshTask(Inventory inventory);
}
