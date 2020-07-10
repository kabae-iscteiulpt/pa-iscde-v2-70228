package pt.iscte.pidesco.extensibility;

import java.util.HashMap;

import pt.iscte.pidesco.entity.Task;

public interface TaskServices {

	/**
	 * Gets the list of tasks.
	 * 
	 * @param pathOfRuntimeWorkSpace
	 * @return list of tasks
	 */
	HashMap<String, Task> getListOfTasks(String pathOfRuntimeWorkSpace);

}
