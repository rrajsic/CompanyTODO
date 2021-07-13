package DataLayer;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 * Used as a mold for table "task" in database
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Set of employees works on this instance of task.
	 * Used to create a row in table "employee_task" which is a many-to-many link between the two.
	 */
	@ManyToMany(mappedBy = "tasks", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<Employee> employees = new HashSet<>();

	/*
	 * ID of task, used as primary key "id" in table "task" 
	 * Doesn't need to be set because it's created by default with auto-increment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/*
	 * Title of task, corresponds to row "title"
	 */
	@Column(name = "title", nullable = false)
	private String title;

	/*
	 * Description of task, corresponds to row "description"
	 */
	@Column(name = "description", nullable = false)
	private String description;

	/*
	 * Type of task, corresponds to row "type"
	 * taskType enum can be: BUG, TASK
	 */
	@Column(name = "type", nullable = false)
	private taskType type;

	/*
	 * Status of task, corresponds to row "status"
	 * taskStatus enum can be: OPEN, CLOSED, IN_PROGRESS
	 */
	@Column(name = "status", nullable = false)
	private taskStatus status;

	/*
	 * Complexity of task, corresponds to row "complexity"
	 * Limited to values between 1-12 with TaskInputer
	 */
	@Column(name = "complexity", nullable = false)
	private int complexity;

	/*
	 * Time spent on task, corresponds to row "timespent"
	 */
	@Column(name = "timespent", nullable = false)
	private int timespent;

	/*
	 * Start date of task, corresponds to row "startdate"
	 * Java.util.Date is automatically converted to sql.Date using PersistenceAPI
	 */
	@Column(name = "startdate", nullable = false)
	private Date startdate;

	/*
	 * End date of task, corresponds to row "enddate"
	 * Java.util.Date is automatically converted to sql.Date using PersistenceAPI
	 */
	@Column(name = "enddate", nullable = false)
	private Date enddate;

	/*
	 * Used for type in Task class
	 */
	public enum taskType {
		BUG, TASK
	}

	/*
	 * Used for status in Task class
	 */
	public enum taskStatus {
		OPEN, CLOSED, IN_PROGRESS
	}

	public Task() {
	}

	public Task(String title, String description, Task.taskType type, Task.taskStatus status, int complexity,
			int timespent, Date startdate, Date enddate) {
		this.title = title;
		this.description = description;
		this.type = type;
		this.status = status;
		this.complexity = complexity;
		this.timespent = timespent;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setType(Task.taskType type) {
		this.type = type;
	}

	public void setStatus(Task.taskStatus status) {
		this.status = status;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public void setTimespent(int timespent) {
		this.timespent = timespent;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public taskType getType() {
		return type;
	}

	public taskStatus getStatus() {
		return status;
	}

	public int getComplexity() {
		return complexity;
	}

	public int getTimespent() {
		return timespent;
	}

	public Date getStartdate() {
		return startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void addEmployeeToSet(Employee employee) {
		this.employees.add(employee);
	}

}
