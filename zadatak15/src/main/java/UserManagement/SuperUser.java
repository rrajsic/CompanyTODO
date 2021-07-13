package UserManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zadatak15.CLI.CLI;
import com.zadatak15.CLI.SuperUserCLI;

import DataLayer.Employee;
import DataLayer.EmployeeInputer;
import DataLayer.Task;
import DataLayer.Task.taskStatus;
import DataLayer.TaskInputer;

/*
 * Extends User and has it's methods and Employee and Task Repository attributes
 */
public class SuperUser extends User implements ISuperUser {


	/*
	 * Inputs Task using TaskInputer and then adding that task to database using task repository
	 */
	public void createTask() {
		TaskInputer inputer = new TaskInputer();
		inputer.inputTitle();
		inputer.inputDescription();
		inputer.inputType();
		inputer.inputStatus();
		inputer.inputComplexity();
		inputer.inputTimespent();
		inputer.inputStartdate();
		inputer.inputEnddate();

		taskRepository.addTask(inputer.getTask());

	}

	/*
	 * Inputs employee using EmployeeInputer and then adding that employee to database using employee repository
	 */
	public void createEmployee() {

		EmployeeInputer inputer = new EmployeeInputer();
		inputer.inputOib();
		inputer.inputName();
		inputer.inputSurname();
		inputer.inputJobposition();


		employeeRepository.addEmployee(inputer.getEmployee());
	}

	/*
	 * Fills list of employees using employee repository, then fills list of employee's job positions
	 * Then converts to LinkedHashSet and back to list to eliminate all duplicates
	 * At last prints job positions and their frequency (counters) in table like format
	 */
	public void printReport_NumberOfWorkersOnJobPosition() {
		List<Employee> employees = new ArrayList<>();
		employees=employeeRepository.getEmployees();


		List<String> jobpositions = new ArrayList<>();
		for(Employee employee : employees) {
			jobpositions.add(employee.getJobPosition());
		}

		LinkedHashSet<String> hashSet = new LinkedHashSet<>(jobpositions);
		List<String> jobpositions_without_duplicates = new ArrayList<>(hashSet);

		System.out.println();
		System.out.println("job position     | counter");
		System.out.println("--------------------------");
		for(String jobpos : jobpositions_without_duplicates) {
			System.out.printf("%-16s %s %-6s",jobpos,"|",Collections.frequency(jobpositions, jobpos));
			System.out.println();

		}
	}

	/*
	 * Fills list of employees using employee repository
	 * Maps timespent and employee
	 * Adds all timespent attributes from employee's task set
	 * Prints first and last name of employee and time spent in table like format
	 */
	public void printReport_TimeSpentByWorker() {
		List<Employee> employees = employeeRepository.getEmployees();
		Map<Employee,Integer> timeSpentByWorker = new HashMap<Employee,Integer>();
		for(Employee employee : employees) {
			Set<Task> employeeTasks = employee.getTasks();
			int time=0;
			for(Task task : employeeTasks) {
				time+=task.getTimespent();
			}
			timeSpentByWorker.put(employee,time);    
		}
		System.out.println();
		System.out.println("First and last name   |time spent (hours)");
		System.out.println("--------------------------------------------------");
		timeSpentByWorker.forEach((Employee,Integer)-> 
		System.out.format("%-10s %-10s | %5s\n",Employee.getfName(),Employee.getlName(),Integer));
	}


	/*
	 * Fills tasks list using task repository
	 * Finds the oldest date in tasks list where task status is OPEN and prints it
	 */
	public void printReport_LongestOpenTask() {
		List<Task> tasks = new ArrayList<>();
		tasks = taskRepository.getTasks();
		java.util.Date max_date= tasks.get(0).getStartdate();
		String title=null;
		for(Task task : tasks) {
			if(task.getStatus()==taskStatus.OPEN) {
				if(task.getStartdate().compareTo(max_date) <= 0) {
					max_date=task.getStartdate();
					title=task.getTitle();
				}
			}
		}
		System.out.println();
		System.out.println("Longest open task is: "+title+" and the start date is: "+ max_date);
	}


	/*
	 * Adds Employee - Task relationship using theirs inputers and placing them in sets 
	 * which is then automatically creating a row in table "employee_task"
	 */
	public void addEmployeeOnTask() {
		EmployeeInputer emp_inputer = new EmployeeInputer();
		emp_inputer.inputOib();

		TaskInputer task_inputer = new TaskInputer();
		task_inputer.inputID();

		Task task = taskRepository.getTask(task_inputer.getTask().getId());
		employeeRepository.addTask(emp_inputer.getEmployee().getOib(), task);
	}

	/*
	 * Returns SuperuserCLI and sets User's employee and task repository
	 */
	public CLI createCLI() {
		return new SuperUserCLI(employeeRepository, taskRepository);
	}
}
