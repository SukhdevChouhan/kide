package com.espark.adarsh.persistence.repositories.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.repositories.InventoryRepository;

public class InventoryRepositoryImpl<E> implements InventoryRepository {
	List<E> ls = new ArrayList<E>();
	@Override
	public Collection<Inventory> getAllInventory() {
		ls.add((E) "test1");
		return (Collection<Inventory>) ls;
	}

}
