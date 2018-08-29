package com.espark.adarsh.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumDataInsert {
	public static WebDriver driver;
	public static void main(String[] args) {
		try{
			driver = new ChromeDriver();
//		String exePath = "D:/kida repositories/kide/src/main/resources/chromedriver.exe";
		
		System.setProperty("webDriver.chrome.driver", "/kida/chromedriver.exe");
		driver.get("http://localhost:9090");
//		driver.wait(2000);
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
