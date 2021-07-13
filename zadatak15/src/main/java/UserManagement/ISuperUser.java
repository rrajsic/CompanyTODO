package UserManagement;

public interface ISuperUser extends IUser {

	void createTask();

	void createEmployee();
	
	void addEmployeeOnTask();

	void printReport_NumberOfWorkersOnJobPosition();

	void printReport_TimeSpentByWorker();

	void printReport_LongestOpenTask();

}
