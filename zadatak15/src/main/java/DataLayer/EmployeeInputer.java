package DataLayer;

import com.zadatak15.Main.KeyboardInputer;

/*
 * Used for responsibility of inputing Employee with keyboard input.
 */
public class EmployeeInputer {

	private Employee employee;

	public EmployeeInputer() {
		this.employee = new Employee();
	}


	public Employee getEmployee() {
		return this.employee;
	}

	/*
	 * Asks for input name from keyboard
	 */
	public void inputName() {
		String name;
		System.out.print("Enter name: ");
		name = KeyboardInputer.getInstance().input.nextLine();

		employee.setfName(name);
	}

	/*
	 * Asks for input last name from keyboard
	 */
	public void inputSurname() {
		String surname;
		System.out.print("Enter last name: ");
		surname = KeyboardInputer.getInstance().input.nextLine();

		employee.setlName(surname);
	}


	/*
	 * Asks for input job position from keyboard
	 */
	public void inputJobposition() {
		String jobposition;
		System.out.print("Enter job position: ");
		jobposition = KeyboardInputer.getInstance().input.nextLine();
		employee.setJobPosition(jobposition);
	}

	/*
	 * Asks for input oib from keyboard.
	 * If input is different from 11 characters, user will be asked until input is 11 characters.
	 */
	public void inputOib() {
		String oib;
		do {
			System.out.print("Enter OIB: ");
			oib = KeyboardInputer.getInstance().input.nextLine();
			if (oib.length() != 11) System.out.println("OiB has 11 numbers");
		} while (oib.length() != 11);

		employee.setOib(oib);
	}
}
