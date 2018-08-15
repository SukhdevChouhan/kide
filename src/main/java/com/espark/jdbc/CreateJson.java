package com.espark.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateJson {
	/**
	 * @param args
	 * @return
	 * @return
	 * @throws IOException
	 */
//	 public static void main(String[] args) throws IOException {
//	public Map<String, Object> CreateJsonMethod() throws IOException {
	public List<List<Object>> CreateJsonMethod() throws IOException {
		String filePath = "D:/kida repositories/kide/src/main/resources/";
		String fileName = "angularExcelapp01.xlsx";
		int sheetNumber = 1;
		GetExcelData data = new GetExcelData();
		List<String> list = data.readHeader(filePath, fileName, sheetNumber);
		// Map<Object,Object> returnArgs = new HashMap<Object, Object>();

		// no need to convert header to map
		Map<String, Object> headerKeys = data.convertListToMap(list);
		// System.out.println(headerKeys);

		List<Object> excelDataList = data.readExcelData(filePath, fileName, sheetNumber);
		List<List<Object>> listOfValuesRowWise = data.divideListAsPerHeaderSize(excelDataList, list.size());
		System.out.println("listOfValuesRowWise : " + listOfValuesRowWise);

		CreateJson createJson = new CreateJson();
		return listOfValuesRowWise;
//		return createJson.splitListData(listOfValuesRowWise);
	}

	public Map<String, Object> splitListData(List<List<Object>> listOfValuesRowWise) throws IOException {
		Map<String, Object> myMap = new HashMap<String, Object>();
		int i, j,k;
		for (i = 0; i < listOfValuesRowWise.size(); i++) {
			List<Object> listOfElevenValuesOfEachRow = new ArrayList<Object>(); 
			for (j = 0; j < listOfValuesRowWise.get(i).size(); j++) {
				listOfElevenValuesOfEachRow.add(listOfValuesRowWise.get(i).get(j));
			}
			myMap.put((String) listOfValuesRowWise.get(i).get(0), listOfElevenValuesOfEachRow);
			}
		return myMap;
	}

}
