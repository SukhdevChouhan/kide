package com.espark.adarsh.web.manager;

import java.util.Collection;

import com.espark.adarsh.persistence.entites.impl.Task;

public interface IssueManager <M>{
	    public void refreshTask(Task task);
	    public Boolean saveTask(Task task);
	    public Boolean updateTask(Task task);
	    public Boolean deleteTask(Task task);
	    public Task getTask(Task task);
	    public Task getTaskById(Task task);
	    public Task getTaskByName(Task task);
	    public Collection<Task> getAllTask();
}
