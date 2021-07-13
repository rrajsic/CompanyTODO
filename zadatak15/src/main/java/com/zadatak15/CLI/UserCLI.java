package com.zadatak15.CLI;

import com.zadatak15.DatabaseLayer.EmployeeRepository;
import com.zadatak15.DatabaseLayer.TaskRepository;
import com.zadatak15.Main.KeyboardInputer;

import UserManagement.User;

/**
 * Used as a command-line interface which extends User and gets it's methods.
 */
public class UserCLI extends User implements CLI{

	/*
	 * Sets User's employee and task repository.
	 */
	public UserCLI(EmployeeRepository employeeRepositoy, TaskRepository taskRepository){
		super.setEmployeeRepository(employeeRepositoy);
		super.setTaskRepository(taskRepository);
	}

	/*
	 * Starts a command-line interface
	 */
	public void cli() {

		int izlaz = 0;
		char odabir ='\0';

		do
		{
			System.out.println();
			System.out.println("(0) Izlaz");
			System.out.println("(1) Izlistaj zadatke");
			System.out.println("(2) Izlistaj zaposlenike");

			System.out.print("Odaberite opciju: ");
			odabir = KeyboardInputer.getInstance().input.nextLine().charAt(0);

			switch(odabir)
			{
			case '0':
				izlaz = 1;
				System.out.println("Izlaz iz programa");
				break;
			case '1':
				readTasks();
				break;
			case '2':
				readEmployees();
				break;
			}
		}
		while(!(izlaz == 1));
	}
}
