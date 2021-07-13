package DataLayer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/*
 * Used as a mold for table "employee" in database
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable{

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Set of tasks which instance of employee works on.
	 * Used to create a row in table "employee_task" which is a many-to-many link between the two.
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "employee_task",
			joinColumns = { @JoinColumn(name="employee_oib")},
			inverseJoinColumns = { @JoinColumn(name="task_id")}
			)
	private Set<Task>tasks = new HashSet<>();

	/*
	 * Login information of employee.
	 * Connection using one-to-one relationship with login.
	 */
	@OneToOne(mappedBy="employee", cascade= CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Login login;

	/*
	 * Employee's oib, corresponds to column "oib" in table, used as primary key
	 */
	@Id
	@Column(name = "oib", unique = true)
	private String oib;

	/*
	 *Name of Employee, corresponding column name is "first_name" in table "employee"
	 */
	@Column(name = "first_name", nullable = false)
	private String fName;

	/*
	 * Last name of Employee, corresponding column name is "last_name" in table "employee"
	 */
	@Column(name = "last_name", nullable= false)
	private String lName;

	/*
	 * Job position of Employee, corresponding column name is "jobposition" in table "employee"
	 */
	@Column(name = "jobposition", nullable= false)
	private String jobPosition;

	public Employee() {}

	public Employee(String oib, String fName, String lName, String jobPosition) {
		this.oib = oib;
		this.fName = fName;
		this.lName = lName;
		this.jobPosition = jobPosition;
	}

	public String getOib() {
		return oib;
	}

	public void setOib(String oib) {
		this.oib = oib;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setTasksSet(Task task) {
		tasks.add(task);
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}