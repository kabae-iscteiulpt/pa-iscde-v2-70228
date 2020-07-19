package pt.iscte.pidesco.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import pt.iscte.pidesco.entity.Priority;
import pt.iscte.pidesco.entity.Task;

public class TaskEngine {

	private final static String TODOWORD = "//TODO";

	private HashMap<String, Task> listOfTasks;
	private String rootOfFiles;

	public TaskEngine(String rootOfFiles) {
		this.setRootOfFiles(rootOfFiles);
	}

	@SuppressWarnings("resource")
	public HashMap<String, Task> getListOfTasks() {
		String pathOfRuntimeWorkSpace = rootOfFiles;
		File folderOfRunTime = new File(pathOfRuntimeWorkSpace);

		listOfTasks = new HashMap<>();

		File[] listOfFiles = folderOfRunTime.listFiles();

		for (File file : listOfFiles) {

			int location = 1;
			if (file.isFile()) {

				try {
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

	public String getRootOfFiles() {
		return rootOfFiles;
	}

	public void setRootOfFiles(String rootOfFiles) {
		this.rootOfFiles = rootOfFiles;
	}

	
	//remove the method below.
	public static void main(String[] args) {

		TaskEngine t = new TaskEngine("C:\\Users\\KWAN\\Desktop\\METI\\1Semestre\\Pa_Project\\runtime-ISCDE");
		HashMap<String, Task> task = t.getListOfTasks();
		int c = 1;
		for (String n : task.keySet()) {

			System.out.println(c + " " + task.get(n).toString());
			c++;
		}
	}

}
