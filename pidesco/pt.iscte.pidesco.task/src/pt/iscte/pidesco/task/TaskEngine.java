package pt.iscte.pidesco.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import pt.iscte.pidesco.entity.Task;
import pt.iscte.pidesco.extensibility.TaskServices;

public class TaskEngine implements TaskServices {

	private final static String TODOWORD = "//TODO";

	private HashMap<String, Task> listOfTasks;

	@Override
	public HashMap<String, Task> getListOfTasks(String pathOfRuntimeWorkSpace) {

		File folderOfRunTime = new File(pathOfRuntimeWorkSpace);

		listOfTasks = new HashMap<>();

		File[] listOfFiles = folderOfRunTime.listFiles();

		for (File file : listOfFiles) {

			int location = 1;
			if (file.isFile()) {

				try {
					Scanner in = new Scanner(file);

					while (in.hasNextLine()) {

						String line = in.nextLine();
						// System.out.println(line);

						String[] vector = line.split(" ");

						String specialWord = vector[0].trim();

						if (specialWord.equals(TODOWORD)) {

							String resource = file.getName();
							String path = file.getPath();
							String locationS = location + "";

							Task task;

							System.out.println(resource);
							System.out.println(line);
							System.out.println(path);
							System.out.println(locationS);

							System.out.println("###################");

							task = new Task(line, resource, path, locationS);
							/*
							 * if (vector[1].equalsIgnoreCase("LOW")) {
							 * 
							 * } else if (vector[1].equalsIgnoreCase("MEDIUM")) {
							 * 
							 * } else {
							 * 
							 * }
							 */

							String chave = path + locationS;

							listOfTasks.put(chave, task);

						}
						location++;
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return listOfTasks;

	}

	public static void main(String[] args) {

		TaskEngine task = new TaskEngine();
		task.getListOfTasks(
				"C:\\\\Users\\\\KWAN\\\\Desktop\\\\METI\\\\1Semestre\\\\Programação Avançada\\\\Projeto\\\\Project_ pa-iscde\\\\runtime-ISCDE");

	}

}
