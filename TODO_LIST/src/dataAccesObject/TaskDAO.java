package dataAccesObject;

import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import entities.Task;

public class TaskDAO {
	private final String SUCCESS_MESSAGE = "The task was done successfully.";
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
			System.out.println("Cannot list tasks because there are no tasks available.");
		} else {
			for (Task task : tasks) {
				System.out.println(task);
				System.out.println(SUCCESS_MESSAGE);

			}

		}
	}

	public void modifyTask(int id, Scanner input) {
		Task task = searchTask(id);
		int option;

		if (task == null) {
			System.out.println("Cannot modify task because it does not exist.");
		} else {
			System.out.println("What do you want to modify?");
			System.out.println("1. Name \n" + "2. Description \n" + "3. Due date \n" + "4. All");
			option = Integer.parseInt(input.nextLine());

			String name, description, dueDate;

			switch (option) {
			case 1:
				System.out.println("Insert new name: ");
				name = input.nextLine();
				task.setName(name);
				System.out.println(SUCCESS_MESSAGE);
				break;

			case 2:
				System.out.println("Insert new description: ");
				description = input.nextLine();
				task.setDescription(description);
				System.out.println(SUCCESS_MESSAGE);
				break;

			case 3:
				System.out.println("Insert new due date: ");
				dueDate = input.nextLine();
				task.setDueDate(dueDate);
				System.out.println(SUCCESS_MESSAGE);
				break;

			case 4:
				System.out.println("Insert new name: ");
				name = input.nextLine();
				task.setName(name);
				System.out.println("Insert new description: ");
				description = input.nextLine();
				task.setDescription(description);
				System.out.println("Insert new due date: ");
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

	public void removeTask() {
		Scanner input = new Scanner(System.in);
		Task task = searchTask(id);
		int option = 0;
//		if (task == null) {
//			System.out.println("Cannot remove task because it does not exist.");
//		} else {
		System.out.println("1. Remove\n2.Remove all");
		option = Integer.parseInt(input.nextLine());
		switch (option) {
		case 1:
			System.out.println("Insert task ID: ");
			int idRemove = Integer.parseInt(input.nextLine());
			if (task == null) {
				System.out.println("Cannot remove task because it does not exist.");
			} else {
				tasks.remove(task);

			}
			break;
		case 2:
			tasks.removeAll(tasks);
			break;
		default:
			break;
		}
		System.out.println(SUCCESS_MESSAGE);
//		}
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
