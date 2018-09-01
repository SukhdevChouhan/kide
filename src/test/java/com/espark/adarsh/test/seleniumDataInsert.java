package com.espark.adarsh.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class seleniumDataInsert {
	static Logger logger;
	public static WebDriver driver;
	private static WebElement element;
	private static Select select;
	static String filePath="D:";
	static String fileName="testReportExpense.xlsx";
	static int sheehNo = 0;
	public static String excelData;
	private static Object[] str;
	private static int count;
	private static int rowcount=9;
	public static void main(String[] args) {
		str = readMonthlyMainLoadSummaryOfReports(filePath,fileName,sheehNo).toArray();
		
		System.out.println("excelDataArray : "+str[0].toString());
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
		System.out.println(str.length);
//		String[] str={"testString","testStringItem","testStringprice","testStringquantity","others","other surpresis","testStringunit_Price","testStringbrand","testStringshop_from"};
		
		String[] xpaths={"invDate","item","price","quantity","uom","catagory","unit_Price","brand","shop_from"};
			for (int i = 0; i < (str.length)/rowcount; i++) {
				driver.findElement(By.id(xpaths[0])).clear();
				driver.findElement(By.id(xpaths[0])).sendKeys(str[0+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[1])).clear();
				driver.findElement(By.id(xpaths[1])).sendKeys(str[1+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[2])).clear();
				driver.findElement(By.id(xpaths[2])).sendKeys(str[2+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[3])).clear();
				driver.findElement(By.id(xpaths[3])).sendKeys(str[3+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[4])).sendKeys(str[4+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[5])).sendKeys(str[5+(i*rowcount)].toString());
//				select = new Select(driver.findElement(By.id(xpaths[4])));
//				select.selectByVisibleText(str[4+(i*rowcount)].toString());
//				select = new Select(driver.findElement(By.id(xpaths[5])));
//				select.selectByVisibleText(str[5+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[6])).sendKeys(str[6+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[7])).sendKeys(str[7+(i*rowcount)].toString());
				driver.findElement(By.id(xpaths[8])).sendKeys(str[8+(i*rowcount)].toString());
				driver.findElement(By.xpath("/html/body/div/form/button"))
						.click();
				driver.findElement(By.xpath("/html/body/nav/ul/li[2]/a"))
						.click();
				count=count+1;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
//			driver.close();
//			driver.quit();
		}
	}
	
	public static List<String> readMonthlyMainLoadSummaryOfReports(String filePath, String fileName, int sheetNumber) {
		List<String> list = new ArrayList<String>();
		try {
			if(!filePath.endsWith("/")) {
				filePath += "/";
			}
			if(fileName.startsWith("/")) {
				fileName.substring(1);
			}

			File myFile = new File(filePath + fileName);
			if(myFile.exists()) {
				FileInputStream fis = new FileInputStream(myFile);
				// Finds the workbook instance for XLSX file
				XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
				// Return first sheet from the XLSX workbook
				XSSFSheet mySheet = myWorkBook.getSheetAt(sheetNumber);
				// Get iterator to all the rows in current sheet
				Iterator<Row> rowIterator = mySheet.iterator();
				// Traversing over each row of XSX file
				String tempKey = "";
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						tempKey = cell.toString();
						list.add(tempKey);
					}
				}
				System.out.println();
				System.out.println(list);
			} else {
				logger.info("File not availbale for reading operation, details=" + myFile.getAbsolutePath());
			}
		} catch (Exception e) {
//			e.printStackTrace();
			logger.info("Exception in file existance ::" + e.getMessage());
		}
		
		return list;
	}
}
