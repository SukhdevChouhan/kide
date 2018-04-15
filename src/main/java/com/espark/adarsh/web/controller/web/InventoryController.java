package com.espark.adarsh.web.controller.web;

import java.io.IOException;
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
	
	// ********************************Inventory View****************************//
		/*@RequestMapping("/inventory")
		public ModelAndView getTasksPage() throws IOException {
			LOGGER.debug("Getting inventory page");
			CreateJson createJson = new CreateJson();
			Map<String, Object> ls = createJson.CreateJsonMethod();
			return new ModelAndView("viewInventory", ls);
		}
}*/
	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getTasksPage() throws IOException {
		CreateJson createJson = new CreateJson();
		Map<String, Object> ls = createJson.CreateJsonMethod();
//		return new ModelAndView("viewInventory", ls);
	    return new ResponseEntity<Map<String, Object>>(ls, HttpStatus.OK);
	}
}
