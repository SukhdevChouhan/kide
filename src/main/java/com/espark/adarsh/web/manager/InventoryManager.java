package com.espark.adarsh.web.manager;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.Inventory;

public interface InventoryManager<M> {
	public void refreshInventory(Inventory inventory);
	public Boolean saveInventory(Inventory inventory);
	public Boolean updateInventory(Inventory inventory);
	public Boolean deleteInventory(Inventory inventory);
	public Inventory getInventory(Inventory inventory);
	public Inventory getInventoryById(Inventory inventory);
	public Inventory getInventoryByName(Inventory inventory);
	public Collection<Inventory> getAllInventory();
}
