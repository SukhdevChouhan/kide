package com.espark.adarsh.web.manager;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.Inventory;

public interface InventoryManager<M> {
	public void refreshTask(Inventory inventory);

	public Collection<Inventory> getAllInventory();
}
