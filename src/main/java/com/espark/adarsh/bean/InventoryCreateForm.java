package com.espark.adarsh.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import com.espark.adarsh.persistence.entites.impl.UserRole;

public class InventoryCreateForm {

	private Long id;
	private String invDate="";
	private String inventory_uiid="";
	private String item="";
	private String price="";
	private String catagory="";
	private String quantity="";
	private String uom="";
	private String unit_Price="";
	private String brand="";
	private String shop_from="";
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvDate() {
		return invDate;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
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
	private UserRole userRole;

	public void setRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserRole getRole() {
		return userRole;
	}
	public String setCurrentDateUiid(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
		String str = dtf.format(now);
		return str+"xxxxx";
	}
	public String setCurrentDateInv(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
		String str = dtf.format(now);
		return str;
	}
	
}
