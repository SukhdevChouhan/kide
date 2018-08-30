package com.espark.adarsh.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumDataInsert {
	public static WebDriver driver;
	private static WebElement element;
	private static Select select;
	public static void main(String[] args) {
		try{
			driver = new ChromeDriver();
//		String exePath = "D:/kida repositories/kide/src/main/resources/chromedriver.exe";
		
		System.setProperty("webDriver.chrome.driver", "/kida/chromedriver.exe");
		driver.get("http://localhost:9090");
		element = driver.findElement(By.xpath("/html/body/div/div[2]/button"));
		element.click();
		driver.findElement(By.xpath("/html/body/div/nav/ul/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/nav/ul/li[2]/a")).click();
		driver.findElement(By.id("invDate")).clear();
		driver.findElement(By.id("invDate")).sendKeys("testString");
		driver.findElement(By.id("item")).clear();
		driver.findElement(By.id("item")).sendKeys("testStringItem");
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("testStringprice");
		driver.findElement(By.id("quantity")).clear();
		driver.findElement(By.id("quantity")).sendKeys("testStringquantity");
		select = new Select(driver.findElement(By.id("uom")));
		select.selectByVisibleText("others");
		select = new Select(driver.findElement(By.id("catagory")));
		select.selectByVisibleText("other surpresis");
		driver.findElement(By.id("unit_Price")).sendKeys("testStringunit_Price");
		driver.findElement(By.id("brand")).sendKeys("testStringbrand");
		driver.findElement(By.id("shop_from")).sendKeys("testStringshop_from");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		
//		driver.wait(10000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
//			driver.close();
//			driver.quit();
		}
	}
}
