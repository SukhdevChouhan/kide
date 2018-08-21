package com.espark.adarsh.web.manager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.repositories.RoleRepository;
import com.espark.adarsh.persistence.repositories.TaskRepository;

@Service
public class IssueManagerImpl implements IssueManager {
	@Override
	public void refreshTask(Task task) {
		taskRepository.refreshTask(task);
	}
	
	@Qualifier("taskRepositoryImpl")
	@Autowired
	private TaskRepository taskRepository;
	
	public void setTaskRepository(final TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	@Qualifier("roleRepositoryImpl")
	@Autowired
	private RoleRepository roleRepository;
	
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Transactional
	public Boolean saveTask(Task task) {
		taskRepository.saveTask(task);
		return null;
	}

	@Transactional
	public Boolean updateTask(Task task) {
		taskRepository.updateTask(task);
		return null;
	}

	@Transactional
	public Boolean deleteTask(Task task) {
		taskRepository.deleteTask(task);
		return null;
	}

	public Task getTask(final Task task) {
		return taskRepository.getTask(task);
	}

	@Override
	public Collection<Task> getAllTask() {
		return taskRepository.getAllTask();
	}

	@Override
	public Task getTaskById(Task task) {
		return taskRepository.getTaskById(task);
	}

	@Override
	public Task getTaskByName(Task task) {
		return taskRepository.getTaskByName(task);
	}

}
