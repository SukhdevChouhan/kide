package com.espark.adarsh.web.controller.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.bean.UserCreateForm;
import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;
import com.espark.adarsh.web.manager.UserManager;

@WebMvcController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired(required = true)
	private UserManager userManager;

	// ****************************User View********************************//
	@RequestMapping("/users")
	public ModelAndView getUsersPage() {
		LOGGER.debug("Getting users page");
		return new ModelAndView("users", "users", userManager.getAllUser());
	}

	// ***********************User Create**********************************//
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		LOGGER.debug("Getting user create form");
		return new ModelAndView("createUser", "form", new UserCreateForm());
	}

	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
		LOGGER.debug("Processing user create form={}, bindingResult={}", form, bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "createUser";
		}
		try {
			final UserRole userRole = this.userManager.getUserRole(form.getRoleName());
			form.setRole(userRole);
			this.userManager.saveUser(new User(form));
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn("Exception occurred when trying to save the user, assuming duplicate email", e);
			bindingResult.reject("email.exists", "Email already exists");
			return "createUser";
		}
		// ok, redirect
		return "redirect:/users";
	}

	// ***********************Excel-Json App**********************************//
	public String getJsonApp() {
		// new angularExcel();
		return null;
	}
}
