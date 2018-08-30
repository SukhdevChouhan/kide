package com.espark.adarsh.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class seleniumDataInsert {
	public static WebDriver driver;
	private static WebElement element;
	private static Select select;
	public static void main(String[] args) {
		try{
		
		System.setProperty("webDriver.chrome.driver", "/kida/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("window-size=1366,768");
		chromeOptions.addArguments("--start-maximized");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(chromeOptions.CAPABILITY, chromeOptions);
		driver = new ChromeDriver(capabilities);
		driver.get("http://localhost:9090");
		element = driver.findElement(By.xpath("/html/body/div/div[2]/button"));
		element.click();
		driver.findElement(By.xpath("/html/body/div/nav/ul/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/nav/ul/li[2]/a")).click();
		
		String[] str={"testString","testStringItem","testStringprice","testStringquantity","others","other surpresis","testStringunit_Price","testStringbrand","testStringshop_from"};
		String[] xpaths={"invDate","item","price","quantity","uom","catagory","unit_Price","brand","shop_from"};
		for(int i=0;i<120;i++){
		driver.findElement(By.id(xpaths[0])).clear();
		driver.findElement(By.id(xpaths[0])).sendKeys(str[0]);
		driver.findElement(By.id(xpaths[1])).clear();
		driver.findElement(By.id(xpaths[1])).sendKeys(str[1]);
		driver.findElement(By.id(xpaths[2])).clear();
		driver.findElement(By.id(xpaths[2])).sendKeys(str[2]);
		driver.findElement(By.id(xpaths[3])).clear();
		driver.findElement(By.id(xpaths[3])).sendKeys(str[3]);
		select = new Select(driver.findElement(By.id(xpaths[4])));
		select.selectByVisibleText(str[4]);
		select = new Select(driver.findElement(By.id(xpaths[5])));
		select.selectByVisibleText(str[5]);
		driver.findElement(By.id(xpaths[6])).sendKeys(str[6]);
		driver.findElement(By.id(xpaths[7])).sendKeys(str[7]);
		driver.findElement(By.id(xpaths[8])).sendKeys(str[8]);
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/nav/ul/li[2]/a")).click();
		}
		/*
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
		*/
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
