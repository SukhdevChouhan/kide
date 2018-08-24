package com.espark.adarsh.web.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.bean.InventoryCreateForm;
import com.espark.adarsh.bean.IssueCreateForm;
import com.espark.adarsh.persistence.entites.impl.Inventory;
import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.entites.impl.UserRole;
import com.espark.adarsh.web.manager.InventoryManager;
import com.espark.adarsh.web.manager.IssueManager;
import com.espark.adarsh.web.manager.UserManager;
import com.espark.jdbc.CreateJson;

@WebMvcController
public class InventoryController {
	Inventory inventory=null;
	private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired(required = true)
	private InventoryManager inventoryManager;
	
	@Autowired(required = true)
	private UserManager userManager;

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

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public ModelAndView getInventoryPage() throws IOException {
		return new ModelAndView("viewInventory", "inventory", inventoryManager.getAllInventory());
	}
	
	// *********************** Create Inventory***********************************//
		@RequestMapping(value = "/inventory/create", method = RequestMethod.GET)
		public ModelAndView getTaskCreatePage() {
			LOGGER.debug("Getting inventory create form");
			return new ModelAndView("createInventory", "createInv", new InventoryCreateForm());
		}
		// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@RequestMapping(value = "/inventory/create", method = RequestMethod.POST)
		public String handleInventoryCreateForm(@Valid @ModelAttribute("form") InventoryCreateForm form, BindingResult bindingResult) {
			LOGGER.debug("Processing inventory create form={}, bindingResult={}", form, bindingResult);
			if (bindingResult.hasErrors()) {
				// failed validation
				return "createInventory";
			}
			try {
				final UserRole userRole = this.userManager.getUserRole(form.getItem());
				form.setRole(userRole);
				this.inventoryManager.saveInventory(new Inventory(form));
			} catch (DataIntegrityViolationException e) {
				// probably email already exists - very rare case when multiple
				// admins are adding same user
				// at the same time and form validation has passed for more than one
				// of them.
				LOGGER.warn("Exception occurred when trying to save the inventory, assuming duplicate inventory paramater", e);
				bindingResult.reject("email.exists", "Email already exists");
				return "createInventory";
			}
			// ok, redirect
			return "redirect:/inventory";
		}
}
