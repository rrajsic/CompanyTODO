package DataLayer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Used as a mold for table "login" in database
 */
@Entity
@Table(name="login")
public class Login implements Serializable {

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * User's oib, corresponds to column "oib" in table, used as primary key
	 */
	@Id
	@Column(name="oib",nullable=false)
	String oib;

	/* Reference to which employee is currently logged in
	 * Connection with employee with one-to-one relationship.
	 */
	@OneToOne
	@MapsId
	@JoinColumn(name="oib")
	private Employee employee;

	/*
	 * Username of currently logged in employee, corresponds to "username" row in table "login"
	 */
	@Column(name="username", nullable=false)
	private String username;

	/*
	 * Password of currently logged in employee, corresponds to "password" row in table "login"
	 */
	@Column(name="password", nullable=false)
	private String password;
	
	/*
	 * User type of currently logged in employee, corresponds to "user_type" row in table "login"
	 * Used for creating types of users ->Admin,SuperUser,User with UserFactory.
	 */
	@Column(name="user_type", nullable=false)
	private UserType userType;


	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}


}
