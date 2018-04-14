package com.ssc.util;

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
	 * @throws IOException
	 */
//	public static void main(String[] args) throws IOException {
	public Map<String, Object> CreateJsonMethod() throws IOException{
		String filePath = "E:/kida/kide/";
		String fileName = "angularExcelapp01.xlsx";
		int sheetNumber = 1;
		GetExcelData data = new GetExcelData();
		List<String> list = data.readHeader(filePath, fileName, sheetNumber);
//		Map<Object,Object> returnArgs = new HashMap<Object, Object>();

		// no need to convert header to map
		 Map<String, Object> headerKeys = data.convertListToMap(list);
		// System.out.println(headerKeys);

		List<Object> excelDataList = data.readExcelData(filePath, fileName, sheetNumber);
		List<List<Object>> listOfValuesRowWise = data.divideListAsPerHeaderSize(excelDataList, list.size());
		System.out.println("listOfValuesRowWise : " + listOfValuesRowWise);

		CreateJson createJson = new CreateJson();
		createJson.splitListData(listOfValuesRowWise);
		return headerKeys;
	}

	public Object splitListData(List<List<Object>> listOfValuesRowWise) throws IOException {
		Object[] splittedListData = null;
		JSONObject dataObj = new JSONObject();
		JSONArray dataArray = new JSONArray();

		Object jsonValues = null;
		List<Object> myArr = new ArrayList<Object>();
		// System.out.println("Length : "+listOfValuesRowWise.size()+", subString : "+listOfValuesRowWise.get(0));
		for (int i = 0; i < listOfValuesRowWise.size(); i++) {
			Object sno = null;
			myArr.clear();
			dataObj.clear();
			dataArray.clear();
			// System.out.println(listOfValuesRowWise.get(i));
			System.out.println("------------");
			for (int j = 0; j < listOfValuesRowWise.get(i).size(); j++) {
				sno = listOfValuesRowWise.get(i).get(0);
				// System.out.println("each row sno : " + sno);
				jsonValues = listOfValuesRowWise.get(i).get(j);
				myArr.add(jsonValues);
				// System.out.println("11 Values  :" + jsonValues);
			}
			dataObj.put(sno, myArr);
			// dataArray.add(dataObj);
			System.out.println(dataObj);
			FileWriter file = new FileWriter("E:/kida/kide/test.json", true);
			BufferedWriter bw = new BufferedWriter(file);
			PrintWriter out = new PrintWriter(bw);
			// out.println("{'intervals':[");
			out.println(dataObj);
			// out.println("]}");
			out.close();
		}
		return splittedListData;
	}

}
