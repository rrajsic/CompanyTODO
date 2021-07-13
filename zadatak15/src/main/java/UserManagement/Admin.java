package UserManagement;

import com.zadatak15.CLI.AdminCLI;
import com.zadatak15.CLI.CLI;
import DataLayer.EmployeeInputer;
import DataLayer.TaskInputer;

/*
 * Extends SuperUser->User and has their methods and Employee and Task Repository attributes
 */
public class Admin extends SuperUser implements IAdmin {


	/*
	 * Uses task inputer to input new task and
	 * then uses task repository to update that task in database.
	 */
	public void updateTask() {
		TaskInputer inputer = new TaskInputer();
		inputer.inputID();
		inputer.inputTitle();
		inputer.inputDescription();
		inputer.inputType();
		inputer.inputStatus();
		inputer.inputComplexity();
		inputer.inputTimespent();
		inputer.inputStartdate();
		inputer.inputEnddate();

		taskRepository.updateTask(inputer.getTask());

	}

	/*
	 * Uses employee inputer to input new task and
	 * then uses employee repository to update that employee in database.
	 */
	public void updateEmployee() {
		EmployeeInputer inputer = new EmployeeInputer();
		inputer.inputOib();
		inputer.inputName();
		inputer.inputSurname();
		inputer.inputJobposition();

		employeeRepository.updateEmployee(inputer.getEmployee());
	}

	
	/*
	 * Uses task inputer to get id
	 * and then uses that id to find and delete task from database using task repository
	 */
	public void deleteTask() {
		TaskInputer inputer = new TaskInputer();
		inputer.inputID();

		taskRepository.deleteTask(inputer.getTask().getId());

	}

	/*
	 * Uses employee inputer to get oib
	 * and then uses that oib to find and delete employee from database using employee repository
	 */
	public void deleteEmployee() {
		EmployeeInputer inputer = new EmployeeInputer();
		inputer.inputOib();

		employeeRepository.deleteEmployee(inputer.getEmployee().getOib());
	}

	/*
	 * returns AdminCLI with this employee and task repository in constructor
	 */
	public CLI createCLI() {
		return new AdminCLI(employeeRepository, taskRepository);
	}

}
