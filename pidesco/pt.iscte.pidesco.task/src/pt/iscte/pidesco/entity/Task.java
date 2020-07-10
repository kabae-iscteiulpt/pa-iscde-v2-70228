package pt.iscte.pidesco.entity;

public class Task {
	// private String check;
	// private Priority priority;
	private String description;
	private String resource;
	private String path;
	private String location;

	/**
	 * @param check
	 * @param priority
	 * @param description
	 * @param resource
	 * @param path
	 * @param location
	 */
	public Task(String description, String resource, String path, String location) {
		this.setDescription(description);
		this.setResource(resource);
		this.setPath(path);
		this.setLocation(location);

	}

	public Task(String description) {

	}

	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return resource
	 */
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/*
	 * public Priority getPriority() { return priority; }
	 * 
	 * public void setPriority(Priority priority) { this.priority = priority; }
	 */

}
