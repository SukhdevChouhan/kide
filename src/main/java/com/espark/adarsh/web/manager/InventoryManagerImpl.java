package com.espark.adarsh.web.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.repositories.InventoryRepository;

@Service
public class InventoryManagerImpl implements InventoryManager{
	
	@Override
	public void refreshTask(Inventory inventory) {
		inventoryRepository.refreshTask(inventory);
	}
	
	@Qualifier("inventoryRepositoryImpl")
	@Autowired
	private InventoryRepository inventoryRepository;

	public void setInventoryRepository(final InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}

	@Override
	public Collection<Inventory> getAllInventory() {
		return inventoryRepository.getAllInventory();
	}
}
