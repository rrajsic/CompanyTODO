package com.zadatak15.CLI;

import com.zadatak15.DatabaseLayer.EmployeeRepository;
import com.zadatak15.DatabaseLayer.TaskRepository;
import com.zadatak15.Main.KeyboardInputer;

import UserManagement.SuperUser;

/**
 * Used as a command-line interface which extends Superuser->User and gets their methods.
 */
public class SuperUserCLI extends SuperUser implements CLI{

	/*
	 * Sets User's employee and task repository.
	 */
	public SuperUserCLI(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
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
			System.out.println(":: :: Kreiranje izvjestaja :: ::");
			System.out.println("(5) Po radnom mjestu tj. koliko radnika radi na pojedinom radnom mjestu");
			System.out.println("(6) Utroseno vrijeme po osobi");
			System.out.println("(7) Najduze otvoren zadatak");
			System.out.println("(8) Dodaj zaposlenika na zadatak");

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
				printReport_NumberOfWorkersOnJobPosition();
				break;
			case '6':
				printReport_TimeSpentByWorker();
				break;
			case '7':
				printReport_LongestOpenTask();
				break;
			case '8':
				addEmployeeOnTask();
				break;
			}
		}
		while(!(izlaz == 1));

	}

}
