package com.espark.adarsh.web.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.repositories.InventoryRepository;
import com.espark.adarsh.persistence.repositories.RoleRepository;

@Service
public class InventoryManagerImpl implements InventoryManager{
	
	@Override
	public void refreshInventory(Inventory inventory) {
		inventoryRepository.refreshInventory(inventory);
	}
	
	@Qualifier("inventoryRepositoryImpl")
	@Autowired
	private InventoryRepository inventoryRepository;

	public void setInventoryRepository(final InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	@Qualifier("roleRepositoryImpl")
	@Autowired
	private RoleRepository roleRepository;
	
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Transactional
	public Boolean saveInventory(Inventory inventory) {
		inventoryRepository.saveInventory(inventory);
		return null;
	}
	
	@Transactional
	public Boolean updateInventory(Inventory inventory) {
		inventoryRepository.updateInventory(inventory);
		return null;
	}
	
	@Transactional
	public Boolean deleteInventory(Inventory inventory) {
		inventoryRepository.deleteInventory(inventory);
		return null;
	}

	@Override
	public Inventory getInventory(Inventory inventory) {
		return inventoryRepository.getInventory(inventory);
	}

	@Override
	public Collection<Inventory> getAllInventory() {
		return inventoryRepository.getAllInventory();
	}

	@Override
	public Inventory getInventoryById(Inventory inventory) {
		return inventoryRepository.getInventoryById(inventory);
	}

	@Override
	public Inventory getInventoryByName(Inventory inventory) {
		return inventoryRepository.getInventoryByName(inventory);
	}
}
