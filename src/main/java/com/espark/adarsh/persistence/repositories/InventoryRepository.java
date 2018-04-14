package com.espark.adarsh.persistence.repositories;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.Inventory;

public interface InventoryRepository {
	public Collection<Inventory> getAllInventory();
}
