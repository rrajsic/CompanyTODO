package DataLayer;

import java.util.List;

/*
 * Used for printing list of Employees
 */
public class EmployeePrinter {

	private List<Employee> employees;

	public EmployeePrinter(List<Employee> employees) {
		this.employees = employees;
	}

	/*
	 * Prints list of employees
	 */
	public void print() {

		System.out.println("------Employees------");
		System.out.println();
		for (Employee employee : employees) {

			System.out.println("Name: " + employee.getfName());
			System.out.println("Surname: " + employee.getlName());
			System.out.println("Job position: " + employee.getJobPosition());
			System.out.println("OiB: " + employee.getOib());
			System.out.println();
		}
	}
}

