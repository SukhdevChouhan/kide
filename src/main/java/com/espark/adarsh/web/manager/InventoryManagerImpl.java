package com.espark.adarsh.web.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.repositories.InventoryRepository;

public class InventoryManagerImpl implements InventoryManager{
	@Qualifier("inventoryRepositoryImpl")
	private InventoryRepository inventoryRepository;
	
	@Override
	public Collection<Inventory> getAllInventory() {
		return inventoryRepository.getAllInventory();
	}

}
