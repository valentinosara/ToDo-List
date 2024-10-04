package dataAccesObject;

import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import entities.Task;

public class TaskDAO {

	private final String SUCCESS_MESSAGE = "\nThe task was done successfully.\n";
	private final String TASK_NONEXISTENT = "Cannot remove task because it does not exist.";
	private final String TASKS_ISEMPTY = "There are no tasks available.\n";
	private final String INVALID_INPUT = "Invalid input. Insert 1, 2, 3 or 4.";
	private final String INVALID_INPUT_REMOVE = "Invalid input. Insert 1 or 2";

	private ArrayList<Task> tasks;
	int id = -1;

	public TaskDAO() {
		tasks = new ArrayList<Task>();
	}

	public void addTask(Task task) {
		tasks.add(task);
		System.out.println(SUCCESS_MESSAGE);
	}

	public int getNextId() {

		id++;

		return id;
	}

	public void listTasks() {
		if (this.tasks.isEmpty()) {
			System.out.println(TASKS_ISEMPTY);
		} else {
			System.out.println("Listing all tasks...");
			for (Task task : tasks) {
				System.out.println(task);

			}
		}
	}

	public void modifyTask(Scanner input) {
		int option;

		if (this.tasks.isEmpty()) {
			System.out.println("Cannot modify tasks because there are no tasks available.\n");
		} else {
			System.out.println("Insert task ID: ");
			int idModify = Integer.parseInt(input.nextLine());
			Task task = searchTask(idModify);
			if (task == null) {
				System.out.println("Cannot modify task because it does not exist.\n");
			} else {
				System.out.println("What do you want to modify?");
				System.out.println("1. Name \n" + "2. Description \n" + "3. Due date \n" + "4. All\n");
				option = Integer.parseInt(input.nextLine());

				String name, description, dueDate;

				switch (option) {
				case 1:
					System.out.print("Insert new name: ");
					name = input.nextLine();
					task.setName(name);
					System.out.println(SUCCESS_MESSAGE);
					break;

				case 2:
					System.out.print("Insert new description: ");
					description = input.nextLine();
					task.setDescription(description);
					System.out.println(SUCCESS_MESSAGE);
					break;

				case 3:
					System.out.print("Insert new due date: ");
					dueDate = input.nextLine();
					task.setDueDate(dueDate);
					System.out.println(SUCCESS_MESSAGE);
					break;

				case 4:
					System.out.print("Insert new name: ");
					name = input.nextLine();
					task.setName(name);
					System.out.print("\nInsert new description: ");
					description = input.nextLine();
					task.setDescription(description);
					System.out.print("\nInsert new due date: ");
					dueDate = input.nextLine();
					task.setDueDate(dueDate);
					System.out.println(SUCCESS_MESSAGE);
					break;

				default:
					System.out.println("Invalid input. Insert 1, 2, 3 or 4.");
					break;
				}
			}
		}
	}

	public void removeTask() {
		Scanner input = new Scanner(System.in);
		int option = 0;

		if (tasks.isEmpty()) {
			System.out.println(TASKS_ISEMPTY);
		} else {
			System.out.println("1. Remove\n2. Remove all");
			option = Integer.parseInt(input.nextLine());
			switch (option) {
			case 1:
				System.out.println("Insert task ID: ");
				int idRemove = Integer.parseInt(input.nextLine());
				Task task = searchTask(idRemove);
				if (task == null) {
					System.out.println(TASK_NONEXISTENT);
				} else {
					tasks.remove(task);
					System.out.println(SUCCESS_MESSAGE);

				}
				break;
			case 2:
				tasks.removeAll(tasks);
				System.out.println(SUCCESS_MESSAGE);
				break;
			default:
				System.out.println(INVALID_INPUT_REMOVE);
				break;
			}
		}
	}

	private Task searchTask(int id) {
		Task task = null;
		int i = 0;

		while (i < tasks.size() && !tasks.get(i).sameId(id)) {
			i++;
		}
		if (i < tasks.size()) {
			task = tasks.get(i);
		}

		return task;
	}

}
