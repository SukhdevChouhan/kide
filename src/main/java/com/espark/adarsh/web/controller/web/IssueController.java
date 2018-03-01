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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.bean.IssueCreateForm;
import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.entites.impl.UserRole;
import com.espark.adarsh.web.manager.IssueManager;
import com.espark.adarsh.web.manager.UserManager;

@WebMvcController
public class IssueController {
	Task task = null;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(IssueController.class);

	@Autowired(required = true)
	private IssueManager issueManager;
	
	@Autowired(required = true)
	private UserManager userManager;
	
	//********************************Task View****************************//
		@RequestMapping("/tasks")
		public ModelAndView getTasksPage() {
			LOGGER.debug("Getting task page");
			return new ModelAndView("viewTask", "tasks", issueManager.getAllTask());
		}
		//***********************Task Create ***********************************//
		@RequestMapping(value = "/task/create", method = RequestMethod.GET)
		public ModelAndView getTaskCreatePage() {
			LOGGER.debug("Getting task create form");
			return new ModelAndView("createTask", "task", new IssueCreateForm());
		}

		// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
		@RequestMapping(value = "/task/create", method = RequestMethod.POST)
		public String handleTaskCreateForm(
				@Valid @ModelAttribute("form") IssueCreateForm form,
				BindingResult bindingResult) {
			LOGGER.debug("Processing task create form={}, bindingResult={}", form,
					bindingResult);
			if (bindingResult.hasErrors()) {
				// failed validation
				return "createTask";
			}
			try {
				final UserRole userRole = this.userManager.getUserRole(form
						.getIssue_name());
				form.setRole(userRole);
				this.issueManager.saveTask(new Task(form));
			} catch (DataIntegrityViolationException e) {
				// probably email already exists - very rare case when multiple
				// admins are adding same user
				// at the same time and form validation has passed for more than one
				// of them.
				LOGGER.warn(
						"Exception occurred when trying to save the task, assuming duplicate task id",
						e);
				bindingResult.reject("email.exists", "Email already exists");
				return "createTask";
			}
			// ok, redirect
			return "redirect:/tasks";
		}
		//***********************Task Edit or Update ***********************************//
		@RequestMapping(value = "/task/edit", method = RequestMethod.GET)
		public ModelAndView getTaskEditPage(@RequestParam String taskname) {
			Task a  = new Task(taskname);
			return new ModelAndView("taskEdit", "task", issueManager.getTaskByName(a));
		}
		// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
			@RequestMapping(value = "/task/edit", method = RequestMethod.POST)
			public String handleTaskEditForm(
					@Valid @ModelAttribute("task") IssueCreateForm form,
					BindingResult bindingResult) {
				System.out.println("******b***********");
				LOGGER.debug("Processing task edit form={}, bindingResult={}", form,
						bindingResult);
				if (bindingResult.hasErrors()) {
					// failed validation
					System.out.println("******failed validation***********");
					return "taskEditFail";
				}
				try {
					final UserRole userRole = this.userManager.getUserRole(form
							.getIssue_name());
					form.setRole(userRole);
					System.out.println("*****userRole*******"+userRole);
					Task task = new Task(form);
					this.issueManager.updateTask(task);
				} catch (DataIntegrityViolationException e) {
					// probably email already exists - very rare case when multiple
					// admins are adding same user
					// at the same time and form validation has passed for more than one
					// of them.
					System.out.println("In exception block");
					LOGGER.warn(
							"Exception occurred when trying to save the task, assuming duplicate task id",
							e);
					bindingResult.reject("email.exists", "Email already exists");
					return "taskEditFail";
				}
				// ok, redirect
				return "redirect:/tasks";
			}
		//***********************Task Edit ***********************************//	
		/*@RequestMapping(value = "/task/edit", method = RequestMethod.GET)
		public ModelAndView getTaskEditPage(@RequestParam String taskname) {
			System.out.println("Hi******1********am editing task********************");
			LOGGER.debug("Getting task create form");
			Task a  = new Task(taskname);
			System.out.println("*****************"+a);
			return new ModelAndView("taskEdit", "task", issueManager.getTaskByName(a));
		}

		// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
				@RequestMapping(value = "/task/edit", method = RequestMethod.POST)
				public String handleTaskEditForm(
						@Valid @ModelAttribute("formEdit") UserCreateForm form,
						BindingResult bindingResult) {
					LOGGER.debug("Processing task edit form={}, bindingResult={}", form,
							bindingResult);
					System.out.println("Hi*********2*****am editing task********************");
					if (bindingResult.hasErrors()) {
						System.out.println("Hi***************am editing task*****in error block***************");
						// failed validation
						return "editTask";
					}
					try {
						System.out.println("Hi***************am editing task*****in try block***************");
						final UserRole userRole = this.userManager.getUserRole(form.getUserName());
						form.setRole(userRole);
						this.issueManager.updateTask(new Task());
						System.out.println("Hi***************am editing task*****in try block****last***********");
						
					} catch (DataIntegrityViolationException e) {
						// probably email already exists - very rare case when multiple
						// admins are adding same user
						// at the same time and form validation has passed for more than one
						// of them.
						LOGGER.warn(
								"Exception occurred when trying to save the user, assuming duplicate email",
								e);
						bindingResult.reject("email.exists", "Email already exists");
						return "editTask";
					}
					// ok, redirect
					return "redirect:/users";
				}
	*///***********************************************************************************//		
				
}
