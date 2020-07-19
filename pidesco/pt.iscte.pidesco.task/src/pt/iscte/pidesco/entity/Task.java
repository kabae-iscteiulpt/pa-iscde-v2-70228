package pt.iscte.pidesco.entity;

public class Task {

	private String priority;
	private String description;
	private String resource;
	private String path;
	private String location;

	public Task(String description, String priority, String resource, String path, String location) {
		this.setDescription(description);
		this.setPriority(priority);
		this.setResource(resource);
		this.setPath(path);
		this.setLocation(location);

	}

	public Task(String description) {
		this.description = description;

	}

	public Task(String description, String resource, String path, String location) {
		this.setDescription(description);
		this.setResource(resource);
		this.setPath(path);
		this.setLocation(location);

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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task [priority=" + priority + ", description=" + description + ", resource=" + resource + ", path="
				+ path + ", location=" + location + "]";
	}

}
