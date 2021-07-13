package com.zadatak15.DatabaseLayer;

import java.util.List;

import javax.persistence.EntityManager;

import DataLayer.Employee;
import DataLayer.Task;

/*
 * Communicates with database using Entity Manager which is set in constructor.
 * This class is used for database operations such as adding tasks, deleting, updating tasks..
 */
public class TaskRepository implements ITaskRepository {

	private EntityManager entityManager;

	public TaskRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/*
	 * Adds task to database.
	 */
	public void addTask(Task task) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(task);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Gets task from database using ID
	 */
	public Task getTask(int id) {
		Task task = entityManager.find(Task.class, id);
		if (task != null) {
			return task;
		} else {
			return null;
		}

	}

	/*
	 * Gets all tasks from database
	 */
	@SuppressWarnings("unchecked")
	public List<Task> getTasks() {
		return entityManager.createQuery("from Task").getResultList();

	}

	/*
	 * Deletes task which is found using employees id.
	 * Also removes task from employee_task relationship by removing task from employees task set.
	 */
	public void deleteTask(int id) {
		Task task = entityManager.find(Task.class, id);
		if (task != null) {
			try {
				entityManager.getTransaction().begin();
				task.getEmployees().forEach(employee -> {
					employee.getTasks().remove(task);
				});
				entityManager.remove(task);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * Adds employee currently working on task found with ID from argument by adding employee to tasks set and merging to database
	 * which automatically makes a new row in employee_task relationship
	 */
	public void addEmployee(int id, Employee employee) {
		Task task = entityManager.find(Task.class, id);
		task.addEmployeeToSet(employee);

		try {
			entityManager.getTransaction().begin();
			entityManager.merge(task);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Updates task in database with task from argument 
	 */
	public void updateTask(Task task) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(task);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
