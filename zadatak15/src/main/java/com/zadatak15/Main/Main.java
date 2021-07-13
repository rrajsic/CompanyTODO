package com.zadatak15.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zadatak15.CLI.CLI;
import com.zadatak15.DatabaseLayer.EmployeeRepository;
import com.zadatak15.DatabaseLayer.LoginRepository;
import com.zadatak15.DatabaseLayer.TaskRepository;

import DataLayer.UserType;
import UserManagement.User;
import UserManagement.UserFactory;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zadatak15");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
		TaskRepository taskRepository = new TaskRepository(entityManager);
		LoginRepository loginRepository = new LoginRepository(entityManager);

		KeyboardInputer scanner = KeyboardInputer.getInstance();
		System.out.println("Username: ");
		String username = scanner.input.nextLine();

		System.out.println("Password: ");
		String password = scanner.input.nextLine();

		UserType usertype= loginRepository.getUsertype(username, password);
		User user = UserFactory.createUser(usertype);
		
		user.setEmployeeRepository(employeeRepository);
		user.setTaskRepository(taskRepository);

		CLI cli = user.createCLI();
		cli.cli();

		entityManager.close();
		entityManagerFactory.close();
		scanner.input.close();
	}
}
