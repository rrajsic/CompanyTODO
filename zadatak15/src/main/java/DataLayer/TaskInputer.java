package DataLayer;

import java.sql.Date;

import com.zadatak15.Main.KeyboardInputer;

/*
 * Used for responsibility of inputing Task with keyboard input.
 */
public class TaskInputer {
	Task task;

	public TaskInputer() {
		this.task = new Task();
	}

	
	public Task getTask() {
		return this.task;
	}

	/*
	 * Asks for input ID from keyboard.
	 * Because ID is int we need to flush scanner after input.
	 */
	public void inputID() {
		int id = KeyboardInputer.getInstance().input.nextInt();
		System.out.println("Input ID: ");
		KeyboardInputer.getInstance().input.nextLine();
		task.setId(id);
	}
	
	/*
	 * Asks for input title from keyboard.
	 */
	public void inputTitle() {
		String title;
		System.out.print("Enter title: ");
		title = KeyboardInputer.getInstance().input.nextLine();

		task.setTitle(title);
	}

	/*
	 * Asks for input description from keyboard.
	 */
	public void inputDescription() {
		String description;
		System.out.print("Enter description: ");
		description = KeyboardInputer.getInstance().input.nextLine();

		task.setDescription(description);
	}


	/*
	 * Asks for input type from keyboard using character and switch-case
	 */
	public void inputType() {
		char type = '\0';
		do {

			System.out.print("Select type : 1 - bug"
					+ "\n              2 - task): ");
			type = KeyboardInputer.getInstance().input.nextLine().charAt(0);

			if (type != '1' && type != '2') System.out.println("Invalid option");      
		} while (type != '1' && type != '2');

		switch (type) {
		case '1':
			task.setType(Task.taskType.BUG);
			break;
		case '2':
			task.setType(Task.taskType.TASK);
			break;
		}
	}

	/*
	 * Asks for input status from keyboard using character and switch-case
	 */
	public void inputStatus() {
		char status = '\0';
		do {
			System.out.print("Select type : 1 - closed"
					+ "\n              2 - open "
					+ "\n			3 - in progress):");

			status = KeyboardInputer.getInstance().input.nextLine().charAt(0);

			if (status != '1' && status != '2' && status != '3') System.out.println("Invalid option");
		} while (status != '1' && status != '2' && status != '3');

		switch (status) {
		case '1':
			task.setStatus(Task.taskStatus.CLOSED);
			break;
		case '2':
			task.setStatus(Task.taskStatus.OPEN);
			break;
		case '3':
			task.setStatus(Task.taskStatus.IN_PROGRESS);
			break;
		}
	}


	/*
	 * Asks for input complexity from keyboard.
	 * Complexity is limited to values between 1-12
	 * Because complexity is int scanner needs to be flushed after input
	 */
	public void inputComplexity() {
		int complexity;
		do {

			System.out.print("Enter complexity (1-12): ");
			complexity = Integer.parseInt(KeyboardInputer.getInstance().input.nextLine());
			KeyboardInputer.getInstance().input.nextLine();

			if (complexity < 1 || complexity > 12) System.out.println("Complexity not in range");
		} while (complexity < 1 || complexity > 12);

		task.setComplexity(complexity);
	}


	/*
	 * Asks for input time spent from keyboard
	 * Because time spent is int scanner needs to be flushed after input
	 * Cant be less than 0
	 */
	public void inputTimespent() {
		int timespent;
		do {

			System.out.print("Enter time spent (h): ");
			timespent = Integer.parseInt(KeyboardInputer.getInstance().input.nextLine());
			KeyboardInputer.getInstance().input.nextLine();
			
			if (timespent < 0) System.out.println("Time spent can't be less than 0");
		} while (timespent < 0);

		task.setTimespent(timespent);
	}


	/* Asks for input of start date from keyboard
	 * Needs to be inputed in correct format (yyyy-mm-dd) or exception will be thrown
	 */
	public void inputStartdate() {
		Date startdate;

		System.out.print("Enter start date (yyyy-mm-dd): ");
		startdate = Date.valueOf(KeyboardInputer.getInstance().input.nextLine());

		task.setStartdate(startdate);
	}


	/* Asks for input of end date from keyboard
	 * Needs to be inputed in correct format (yyyy-mm-dd) or exception will be thrown
	 */
	public void inputEnddate() {
		Date enddate;

		System.out.print("Enter end date (yyyy-mm-dd): ");
		enddate = Date.valueOf(KeyboardInputer.getInstance().input.nextLine());

		task.setEnddate(enddate);
	}

}
