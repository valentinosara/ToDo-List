package ui;

import java.util.Scanner;

import dataAccesObject.TaskDAO;
import entities.Task;

public class Main {

	public static void main(String[] args) {

		TaskDAO taskDAO = new TaskDAO();
		Scanner input = new Scanner(System.in);

		int option;

		do {
			System.out.println("To Do List");
			System.out.println("1. New Task");
			System.out.println("2. List Task");
			System.out.println("3. Modify task");
			System.out.println("4. Remove tasks");
			System.out.println("5. End program");

			try {
				option = Integer.parseInt(input.nextLine());

			} catch (NumberFormatException e) {
				option = 6;
			}

			switch (option) {
			case 1:
				System.out.println("To create a new task:");
				System.out.print("Insert name: ");
				String name = input.nextLine();
				System.out.print("\nInsert description: ");
				String description = input.nextLine();
				System.out.print("\nInsert due date: ");
				String dueDate = input.nextLine();
				int id = taskDAO.getNextId();
				taskDAO.addTask(new Task(id, name, description, dueDate));

				break;

			case 2:
				taskDAO.listTasks();
				break;

			case 3:
				taskDAO.modifyTask(input);
				break;

			case 4:
//				System.out.println("Insert task ID: ");
//				int idRemove = Integer.parseInt(input.nextLine());
				taskDAO.removeTask();
				break;

			case 5:
				System.out.println("Ending program");
				break;

			default:
				System.out.println("Invalid input. Insert 1, 2, 3, 4 or 5.\n");
				break;
			}

		} while (option != 5);

		input.close();
	}
}
