package com.espark.adarsh.persistence.entites.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.espark.adarsh.persistence.entites.construct.AbstractEntity;

@Entity
@Table(name = "inventory_main")
public final class Inventory extends AbstractEntity<Long>{
	
	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
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

	@Column(nullable = false, length = 100)
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

	public Inventory(){
		super(Inventory.class);
	}
	
}
