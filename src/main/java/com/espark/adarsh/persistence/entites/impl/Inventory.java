package com.espark.adarsh.persistence.entites.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.espark.adarsh.persistence.entites.construct.AbstractEntity;

@Entity
@Table(name = "inventory_main")
public final class Inventory extends AbstractEntity<Long>{
	
//	@Column(unique = true, length = 24, nullable = false)
//	private String id;
	
	@Column(nullable = true, length = 100)
	private String InvDate;
	
	@Column(nullable = true, length = 100)
	private String Item;
	
	@Column(nullable = true, length = 100)
	private String Price;
	
	@Column(nullable = true, length = 100)
	private String Catagory;
	
	@Column(nullable = true, length = 100)
	private String Quantity;
	
	@Column(nullable = true, length = 100)
	private String UoM;
	
	@Column(nullable = true, length = 100)
	private String Unit_Price;
	
	@Column(nullable = true, length = 100)
	private String Brand;
	
	@Column(nullable = true, length = 100)
	private String Shop_From;
	
	/*public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}*/

	public String getInvDate() {
		return InvDate;
	}

	public void setInvDate(String invDate) {
		InvDate = invDate;
	}

	public String getItem() {
		return Item;
	}

	public void setItem(String item) {
		Item = item;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getCatagory() {
		return Catagory;
	}

	public void setCatagory(String catagory) {
		Catagory = catagory;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public String getUoM() {
		return UoM;
	}

	public void setUoM(String uoM) {
		UoM = uoM;
	}

	public String getUnit_Price() {
		return Unit_Price;
	}

	public void setUnit_Price(String unit_Price) {
		Unit_Price = unit_Price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getShop_From() {
		return Shop_From;
	}

	public void setShop_From(String shop_From) {
		Shop_From = shop_From;
	}

	public Inventory(){
		super(Inventory.class);
	}
}
