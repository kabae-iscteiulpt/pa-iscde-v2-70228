package pt.iscte.pidesco.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import pt.iscte.pidesco.entity.Priority;
import pt.iscte.pidesco.entity.Task;
import pt.iscte.pidesco.extensibility.TaskListView;

/**
 * The main class responsibly to get all the list of tasks.
 */
public class TaskEngine implements TaskListView {

	private final static String TODOWORD = "//TODO";

	private HashMap<String, Task> listOfTasks;
	private String rootOfFiles;

	public TaskEngine(String rootOfFiles) {
		this.setRootOfFiles(rootOfFiles);
	}

	/**
	 * Gets the task list view.
	 * 
	 * @param pathOfRuntimeWorkSpace should not be a empty name
	 * @return taskListView
	 */
	public HashMap<String, Task> createTaskListView(String pathOfRuntimeWorkSpace) {
		this.setRootOfFiles(pathOfRuntimeWorkSpace);
		File folderOfRunTime = new File(rootOfFiles);
		listOfTasks = new HashMap<>();

		File[] listOfFiles = folderOfRunTime.listFiles();

		for (File file : listOfFiles) {

			int location = 1;
			if (file.isFile()) {

				try {
					@SuppressWarnings("resource")
					Scanner in = new Scanner(file);
					Task task = null;
					while (in.hasNextLine()) {

						String line = in.nextLine();

						String[] vector = line.split(" ");

						String specialWord = vector[0].trim();

						if (specialWord.equals(TODOWORD)) {
							String priority = vector[1].trim();
							String resource = file.getName();
							String path = file.getPath();
							String locationS = "line " + location + "";

							for (Priority e : Priority.values()) {
								String prior = e + "";

								if (priority != null & prior.equalsIgnoreCase(priority)) {
									String description = "";
									for (int i = 2; i < vector.length; i++) {
										description = description + vector[i] + " ";
									}

									task = new Task(description, prior, resource, path, locationS);

									String chave = path + locationS;
									listOfTasks.put(chave, task);
									break;
								} else {

									String description = " ";
									for (int i = 1; i < vector.length; i++) {
										description = description + vector[i] + " ";
									}
									task = new Task(description, resource, path, locationS);
									String chave = path + locationS;
									listOfTasks.put(chave, task);
								}

							}
						}
						location++;
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}

		return listOfTasks;

	}

	/**
	 * Gets the rootOfFiles.
	 * 
	 * @return rootOfFiles
	 */
	public String getRootOfFiles() {
		return rootOfFiles;
	}

	/**
	 * Sets the rootOfFiles.
	 * 
	 * @param rootOfFiles
	 */
	public void setRootOfFiles(String rootOfFiles) {
		this.rootOfFiles = rootOfFiles;
	}

}