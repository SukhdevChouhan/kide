package com.espark.adarsh.web.controller.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.web.manager.InventoryManager;
import com.espark.adarsh.web.manager.IssueManager;
import com.ssc.util.CreateJson;

@WebMvcController
public class InventoryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	
//	@Autowired(required = true)
	private InventoryManager inventoryManager;
	
	// ********************************Task View****************************//
		@RequestMapping("/inventory")
		public ModelAndView getTasksPage() throws IOException {
			LOGGER.debug("Getting inventory page");
			return new ModelAndView("viewInventory", "inventory",inventoryManager.getAllInventory());
//			return new ModelAndView("viewInventory", "inventory", new CreateJson().CreateJsonMethod());
		}
}
