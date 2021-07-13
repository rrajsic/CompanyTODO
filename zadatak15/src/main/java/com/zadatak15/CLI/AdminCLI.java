package com.zadatak15.CLI;

import com.zadatak15.DatabaseLayer.EmployeeRepository;
import com.zadatak15.DatabaseLayer.TaskRepository;
import com.zadatak15.Main.KeyboardInputer;

import UserManagement.Admin;

/**
 * Used as a command-line interface which extends Admin->Superuser->User and gets their methods.
 */
public class AdminCLI extends Admin implements CLI{

	/*
	 * Sets User's employee and task repository.
	 */
	public AdminCLI(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
		super.setEmployeeRepository(employeeRepository);
		super.setTaskRepository(taskRepository);
	}

	/*
	 * Starts a command-line interface
	 */
	public void cli() {
		int izlaz = 0;
		char odabir = '\0';
		do
		{
			System.out.println();
			System.out.println("(0) Izlaz");
			System.out.println("(1) Kreiraj zadatak");
			System.out.println("(2) Kreiraj zaposlenika");
			System.out.println("(3) Izlistaj zadatke");
			System.out.println("(4) Izlistaj zaposlenike");
			System.out.println("(5) Update task");
			System.out.println("(6) Update employee");
			System.out.println("(7) Obriši zadatak");
			System.out.println("(8) Obriši zaposlenika");
			System.out.println("(9) Dodaj zaposlenika na zadatak");
			System.out.println("(a) Po radnom mjestu tj. koliko radnika radi na pojedinom radnom mjestu");
			System.out.println("(b) Najduze otvoren zadatak");
			System.out.println("(c) Utroseno vrijeme po osobi");

			System.out.print("Odaberite opciju: ");
			odabir = KeyboardInputer.getInstance().input.nextLine().charAt(0);

			switch(odabir)
			{
			case '0':
				izlaz = 1;
				System.out.println("Izlaz iz programa");
				break;
			case '1':
				createTask();
				System.out.println("Uspjesno kreiranje zadatka\n");
				break;
			case '2':
				createEmployee();
				System.out.println("Uspjesno kreiranje zaposlenika\n");
				break;
			case '3':
				readTasks();
				break;
			case '4':
				readEmployees();
				break;
			case '5':
				updateTask();
				System.out.println("Zadatak uspjesno izmjenjen\n");
				break;
			case '6':
				updateEmployee();
				System.out.println("Zaposlenik uspjesno izmjenjen\n");
				break;
			case '7':
				deleteTask();
				System.out.println("Zadatak uspjesno obrisan\n");
				break;
			case '8': 
				deleteEmployee();
				System.out.println("Zaposlenik uspjesno obrisan\n");
				break;
			case '9':
				addEmployeeOnTask();
				break;
			case 'a':
				printReport_NumberOfWorkersOnJobPosition();
				break;
			case 'b':
				printReport_LongestOpenTask();
				break;
			case 'c':
				printReport_TimeSpentByWorker();
				break;
			}
		}

		while(!(izlaz == 1));
	}
}
