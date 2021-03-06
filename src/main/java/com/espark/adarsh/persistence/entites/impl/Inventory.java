package com.espark.adarsh.persistence.entites.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.espark.adarsh.bean.InventoryCreateForm;
import com.espark.adarsh.bean.IssueCreateForm;
import com.espark.adarsh.persistence.entites.construct.AbstractEntity;

@Entity
@Table(name = "inventory_main")
public final class Inventory extends AbstractEntity<Long>{
	
	@Column(nullable = true, length = 100)
	private String inventory_uiid;
	
	@Column(nullable = true, length = 100)
	private String invDate;

	@Column(nullable = true, length = 100)
	private String item;
	
	@Column(nullable = true, length = 100)
	private String price;
	
	@Column(nullable = true, length = 100)
	private String catagory;
	
	@Column(nullable = true, length = 100)
	private String quantity;
	
	@Column(nullable = true, length = 100)
	private String uom;
	
	@Column(nullable = true, length = 100)
	private String unit_Price;
	
	@Column(nullable = true, length = 100)
	private String brand;
	
	@Column(nullable = true, length = 100)
	private String shop_from;
	
	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	
	public String getInventory_uiid() {
		return inventory_uiid;
	}

	public void setInventory_uiid(String inventory_uiid) {
		this.inventory_uiid = inventory_uiid;
	}


	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUnit_Price() {
		return unit_Price;
	}

	public void setUnit_Price(String unit_Price) {
		this.unit_Price = unit_Price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getShop_from() {
		return shop_from;
	}

	public void setShop_from(String shop_from) {
		this.shop_from = shop_from;
	}

	public Inventory(){
		super(Inventory.class);
	}
	
	public Inventory(Long id) {
		super(Inventory.class);
		super.setId(id);
		this.setInventory_uiid("");
	}
	
	public Inventory(String inventory_uiid) {
		this();
		this.inventory_uiid = inventory_uiid;
	}
	
	public Inventory(Inventory inventory) {
		super(Task.class);
		this.inventory_uiid = inventory.getInventory_uiid();
		this.invDate = inventory.getInvDate();
		this.item = inventory.getItem();
		this.price = inventory.getPrice();
		this.catagory = inventory.getCatagory();
		this.quantity = inventory.getQuantity();
		this.uom = inventory.getUom();
		this.unit_Price = inventory.getUnit_Price();
		this.brand = inventory.getBrand();
		this.shop_from = inventory.getShop_from();
	}
	
	public Inventory(final InventoryCreateForm inventoryCreateForm) {
		super(Task.class);
		this.setId(inventoryCreateForm.getId());
		this.invDate = inventoryCreateForm.getInvDate();
		this.inventory_uiid = inventoryCreateForm.getInventory_uiid();
		this.item = inventoryCreateForm.getItem();
		this.price = inventoryCreateForm.getPrice();
		this.catagory = inventoryCreateForm.getCatagory();
		this.quantity = inventoryCreateForm.getQuantity();
		this.uom = inventoryCreateForm.getUom();
		this.unit_Price = inventoryCreateForm.getUnit_Price();
		this.brand = inventoryCreateForm.getBrand();
		this.shop_from = inventoryCreateForm.getShop_from();
	}
	
}
