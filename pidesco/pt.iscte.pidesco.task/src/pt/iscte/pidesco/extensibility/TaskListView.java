package pt.iscte.pidesco.extensibility;

public interface TaskListView {

	/**
	 * Gets the task list view.
	 * 
	 * @param pathOfRuntimeWorkSpace should not be a empty name
	 * @return taskListView
	 */
	void createTaskListView(String pathOfRuntimeWorkSpace);

}
