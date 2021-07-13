package DataLayer;

import java.util.List;

/*
 * Used for responsibility of printing List of tasks
 */
public class TaskPrinter {
	private List<Task> tasks;

	public TaskPrinter (List<Task> tasks) {
		this.tasks = tasks;
	}

	/*
	 * Prints List of tasks
	 */
	public void print() {

		System.out.println("------Tasks------");
		System.out.println();
		for(Task task : tasks) {
			System.out.println("ID: " + task.getId());
			System.out.println("Title: " +task.getTitle());
			System.out.println("Description: " + task.getDescription());
			System.out.println("Type: " + task.getType());
			System.out.println("Status: " + task.getStatus());
			System.out.println("Complexity: " + task.getComplexity());
			System.out.println("Time spent: " + task.getTimespent() + "h");
			System.out.println("Start date: " + task.getStartdate());
			System.out.println("End date: " + task.getEnddate());
			System.out.println();
		}
	}
}
