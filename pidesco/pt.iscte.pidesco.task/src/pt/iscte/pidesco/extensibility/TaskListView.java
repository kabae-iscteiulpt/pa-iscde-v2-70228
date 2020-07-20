package pt.iscte.pidesco.extensibility;

import java.util.HashMap;

import pt.iscte.pidesco.entity.Task;

public interface TaskListView {

	/**
	 * Gets the task list view.
	 * 
	 * @param pathOfRuntimeWorkSpace should not be a empty name
	 * @return taskListView
	 */
	HashMap<String, Task> createTaskListView(String pathOfRuntimeWorkSpace);

}
