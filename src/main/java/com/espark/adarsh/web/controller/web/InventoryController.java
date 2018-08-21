package com.espark.adarsh.web.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.web.manager.InventoryManager;
import com.espark.adarsh.web.manager.IssueManager;
import com.espark.jdbc.CreateJson;

@WebMvcController
public class InventoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired(required = true)
	private InventoryManager inventoryManager;

	private String passJsonString;
	
	// ********************************Inventory View****************************//
		/*@RequestMapping(value="/viewInventoryController", method = RequestMethod.GET)
		public ModelAndView getTasksPage() throws IOException {
			LOGGER.debug("Getting inventory page");
			CreateJson createJson = new CreateJson();
			List<List<Object>> passJsonList = createJson.CreateJsonMethod();
			
//			ModelAndView modelAndView = new ModelAndView();
//			modelAndView.setViewName("viewInventory");
//			return modelAndView.addObject("inventory", passJsonList.toString());
			//OR
			return new ModelAndView("viewInventory", "inventory", passJsonList.toString());
		}*/

	@RequestMapping(value = "/viewInventoryController", method = RequestMethod.GET)
	public ModelAndView getTasksPage() throws IOException {
		return new ModelAndView("viewInventory", "inventory", inventoryManager.getAllInventory());
	}
}
