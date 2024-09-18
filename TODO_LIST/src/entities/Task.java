package entities;

public class Task {
	private int id;
	private String name;
	private String description;
	private String dueDate;	
	
	//CONSTRUCTOR
	public Task(int id, String name, String description, String dueDate) {
		setId(id);;
		setName(name);
		setDescription(description);
		setDueDate(dueDate);
	}
	
	
	//GETTERS & SETTERS
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	private void setDescription(String description) {
		this.description = description;
	}
	public String getDueDate() {
		return dueDate;
	}
	private void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Task: " + name + " | Description: " + description + " | Date: " + dueDate;
	}
	
}