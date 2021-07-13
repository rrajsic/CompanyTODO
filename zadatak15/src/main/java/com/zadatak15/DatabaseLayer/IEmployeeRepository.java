package com.zadatak15.DatabaseLayer;

import java.util.List;

import DataLayer.Employee;
import DataLayer.Task;

public interface IEmployeeRepository {

	public void addEmployee(Employee employee);

	public Employee getEmployee(String oib);
	public List<Employee> getEmployees();
	public void addTask(String oib,Task task);
	public void deleteEmployee(String oib);
	public void updateEmployee(Employee employee);
}
