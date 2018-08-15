package com.espark.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {
	private Logger logger = Logger.getLogger(GetExcelData.class);

	/*
	 * public static void main(String[] args) { String filePath =
	 * "E:/eclipse prog/angularExcel"; String fileName =
	 * "angularExcelapp01.xlsx"; int sheetNumber = 0; getExcelData data = new
	 * getExcelData(); List<String> list = data.readHeader(filePath, fileName,
	 * sheetNumber);
	 * 
	 * // no need to convert header to map // Map<String, Object> headerKeys =
	 * data.convertListToMap(list); // System.out.println(headerKeys);
	 * 
	 * List<Object> excelDataList = data.readExcelData(filePath, fileName,
	 * sheetNumber); List<List<Object>> listOfValuesRowWise =
	 * data.divideListAsPerHeaderSize(excelDataList, list.size());
	 * System.out.println("listOfValuesRowWise : " + listOfValuesRowWise); }
	 */

	/**
	 * @author This routine will convert List to Map
	 *
	 */
	public Map<String, Object> convertListToMap(List<?> headerData) {
		String[] headerDataArray = headerData.toArray(new String[headerData.size()]);
		Map<String, Object> headerMap = new HashMap<>();
		for (int i = 0; i < headerDataArray.length; i++) {
			headerMap.put(headerDataArray[i], null);
		}
		return headerMap;
	}

	/**
	 * This routine will convert any excel to List row-wise
	 *
	 */
	public List<List<Object>> divideListAsPerHeaderSize(List<Object> dataValueList, int headerSize) {
		List<Object> dataValueTruncatedList = null;
		List<List<Object>> cumulativeDataValueTruncatedList = new ArrayList<List<Object>>();
		int headerSizeIncremental = 0;
		int k = ((dataValueList.size()) / headerSize) - 1;
		for (int i = 0; i < k; i++) {
			// equally divide list from headerSize+1 index
			dataValueTruncatedList = dataValueList.subList(headerSizeIncremental, headerSizeIncremental + headerSize);
			headerSizeIncremental = headerSizeIncremental + headerSize;
			// System.out.println(headerSizeIncremental + 1 +
			// "--"+dataValueTruncatedList);
			cumulativeDataValueTruncatedList.add(dataValueTruncatedList);
		}
		return cumulativeDataValueTruncatedList;
	}

	/**
	 * This routine will get excel in list row-wise, including header
	 *
	 */
	public List<Object> readExcelData(String filePath, String fileName, int sheetNumber) {
		List<Object> list = new ArrayList<Object>();
		try {
			if (!filePath.endsWith("/")) {
				filePath += "/";
			}
			if (fileName.startsWith("/")) {
				fileName.substring(1);
			}
			File myFile = new File(filePath + fileName);
			if (myFile.exists()) {
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
			} else {
				logger.info("File not availbale for reading operation, details=" + myFile.getAbsolutePath());
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("Exception in file existance ::" + e.getMessage());
		}
		// System.out.println("Data Value size is : " + list.size());
		// System.out.println("Data Values List is : " + list);
		return list;
	}

	/**
	 * Only getting Header of Excel
	 *
	 */
	public List<String> readHeader(String filePath, String fileName, int sheetNumber) {
		List<String> list = new ArrayList<String>();
		try {
			if (!filePath.endsWith("/")) {
				filePath += "/";
			}
			if (fileName.startsWith("/")) {
				fileName.substring(1);
			}
			File myFile = new File(filePath + fileName);
			if (myFile.exists()) {
				FileInputStream fis = new FileInputStream(myFile);
				// Finds the workbook instance for XLSX file
				XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
				// Return first sheet from the XLSX workbook
				XSSFSheet mySheet = myWorkBook.getSheetAt(sheetNumber);
				// Get iterator to all the rows in current sheet
				Iterator<Row> rowIterator = mySheet.iterator();
				// Traversing over each row of XSX file
				String tempKey = "";
				// while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					tempKey = cell.toString();
					list.add(tempKey);
					// }
				}
			} else {
				logger.info("File not availbale for reading operation, details=" + myFile.getAbsolutePath());
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.info("Exception in file existance ::" + e.getMessage());
		}
		// System.out.println("size is : " + list.size());
		// System.out.println("Header is : " + list);
		return list;
	}
}