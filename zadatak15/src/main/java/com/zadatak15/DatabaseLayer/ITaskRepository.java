package com.zadatak15.DatabaseLayer;

import java.util.List;

import DataLayer.Employee;
import DataLayer.Task;

public interface ITaskRepository {

	public void addTask(Task task);

	public Task getTask(int id);
	public List<Task> getTasks();
	public void addEmployee(int id,Employee employee);
	public void deleteTask(int id);
	public void updateTask(Task task);
}
