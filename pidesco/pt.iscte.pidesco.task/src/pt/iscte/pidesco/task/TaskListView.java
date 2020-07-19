package pt.iscte.pidesco.task;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import pt.iscte.pidesco.entity.Task;
import pt.iscte.pidesco.extensibility.PidescoView;

public class TaskListView implements PidescoView {

	private static final String extensionPointID = "pt.iscte.pidesco.task.TaskList";
	private IConfigurationElement[] elements;

	public TaskListView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createContents(Composite viewArea, Map<String, Image> imageMap) {

		// tenho que retirar o caminho em baixo tem ficar uma variavel
		TaskEngine engine = new TaskEngine("C:\\Users\\KWAN\\Desktop\\METI\\1Semestre\\Pa_Project\\runtime-ISCDE");
		HashMap<String, Task> taskList = engine.getListOfTasks();

		Table table = new Table(viewArea, SWT.BORDER);

		TableColumn descriptionCol = new TableColumn(table, SWT.LEFT);
		TableColumn priorityCol = new TableColumn(table, SWT.LEFT);
		TableColumn resourceCol = new TableColumn(table, SWT.LEFT);
		TableColumn pathCol = new TableColumn(table, SWT.LEFT);
		TableColumn locationCol = new TableColumn(table, SWT.LEFT);

		descriptionCol.setText("Description");
		priorityCol.setText("Priority");
		resourceCol.setText("Resource");
		pathCol.setText("Path");
		locationCol.setText("Location");

		descriptionCol.setWidth(150);
		priorityCol.setWidth(100);
		resourceCol.setWidth(150);
		pathCol.setWidth(300);
		locationCol.setWidth(80);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		for (String chave : taskList.keySet()) {

			TableItem item = new TableItem(table, SWT.NONE);
			String description = taskList.get(chave).getDescription();
			String priority = taskList.get(chave).getPriority();
			String resource = taskList.get(chave).getResource();
			String path = taskList.get(chave).getPath();
			String location = taskList.get(chave).getLocation();

			if (priority == null) {
				item.setText(new String[] { description, "not defined", resource, path, location });
			} else {
				item.setText(new String[] { description, priority, resource, path, location });

			}
		}

		// Get the extensions and create the taskListView
		IExtensionRegistry extRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = extRegistry.getExtensionPoint(extensionPointID);
		IExtension[] extensions = extensionPoint.getExtensions();

		for (IExtension e : extensions) {
			IConfigurationElement[] confElements = e.getConfigurationElements();

			for (IConfigurationElement c : confElements) {
				String s = c.getAttribute("name");
				try {

					Object o = c.createExecutableExtension("class");

					if (o instanceof TaskListView) {

					}

				} catch (CoreException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

}
