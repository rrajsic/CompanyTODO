package UserManagement;

import java.util.ArrayList;
import java.util.List;

import com.zadatak15.CLI.CLI;
import com.zadatak15.CLI.UserCLI;
import com.zadatak15.DatabaseLayer.EmployeeRepository;
import com.zadatak15.DatabaseLayer.TaskRepository;

import DataLayer.Employee;
import DataLayer.EmployeePrinter;
import DataLayer.Task;
import DataLayer.TaskPrinter;

/*
 * Lowest ranking user type
 * Has Employee Repository and Task repository which must be set or these will be null
 */
public class User implements IUser{

	/*
	 * Employee Repository which is set with setter
	 */
	protected EmployeeRepository employeeRepository;
	/*
	 * Task Repository which is set with setter
	 */
	protected TaskRepository taskRepository;


	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public void setTaskRepository(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}


	/*
	 * Creates list of tasks and fills it with task repository and prints that list with TaskPrinter
	 */
	public void readTasks() {
		List<Task> tasks = new ArrayList<Task>();
		tasks = taskRepository.getTasks();

		TaskPrinter tprinter = new TaskPrinter(tasks);
		tprinter.print();

	}


	/*
	 * Creates list of employees and fills it with employee repository and prints that list with EmployeePrinter
	 */
	public void readEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees = employeeRepository.getEmployees();

		EmployeePrinter eprinter = new EmployeePrinter(employees);
		eprinter.print();
	}

	/*
	 * Returns CLI class which extends this one 
	 */
	public CLI createCLI() {
		return new UserCLI(employeeRepository,taskRepository);
	}
}
