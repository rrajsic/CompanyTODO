package com.zadatak15.DatabaseLayer;

import java.util.List;

import javax.persistence.EntityManager;

import DataLayer.Employee;
import DataLayer.Task;

/*
 * Communicates with database using Entity Manager which is set in constructor.
 * This class is used for database operations such as adding employees, deleting, updating employees..
 */
public class EmployeeRepository implements IEmployeeRepository {

	private EntityManager entityManager;

	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/*
	 * Adds employee to database.
	 */
	public void addEmployee(Employee employee) {

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Gets employee from database using oib.
	 */
	public Employee getEmployee(String oib) {
		Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.oib =:oib", Employee.class)
				.setParameter("oib", oib).getSingleResult();

		if (employee != null) {
			return employee;
		} else {
			return null;
		}
	}

	/*
	 * Gets all employees from database
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		return entityManager.createQuery("from Employee").getResultList();
	}
	
	/*
	 * Deletes employee which is found using employees oib.
	 * Also removes employee from employee_task relationship by removing employee from tasks set
	 */
	public void deleteEmployee(String oib) {
		Employee employee = entityManager.find(Employee.class, oib);
		if (employee != null) {
			try {
				entityManager.getTransaction().begin();
				employee.getTasks().forEach(task -> {
					task.getEmployees().remove(employee);
				});
				entityManager.remove(employee);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Adds task to employee's task set (which is all tasks the employee is working on) and
	 * then adds a row in table employee_task with this employee and this task
	 */
	public void addTask(String oib, Task newTask) {
		Employee employee = entityManager.find(Employee.class, oib);
		employee.setTasksSet(newTask);

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Updates employee in database by merging row with employee given as argument
	 */
	@Override
	public void updateEmployee(Employee employee) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(employee);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
