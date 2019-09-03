package org.elsys.todo;

import java.util.ArrayList;
import java.util.List;

import org.elsys.todo.impl.TaskImpl;
import org.elsys.todo.impl.TodoListImpl;

public interface TodoList {

	/**
	 * Parses the input String and creates new instance of TodoList.
	 * @param input
	 * @return new instance of TodoList
	 */
	public static TodoList parse(String input) {
		String [] oldString = input.split("\\r?\\n|\\|");
		String [] newString = new String[oldString.length];

		List<Task> tasks = new ArrayList<>();
		
		int temp = 0;
		
		for(int i = 0; i < oldString.length; i++, temp++) {
			String string = oldString[i].trim();
			newString[i] = string;
			
			if(temp == 3) {
				String [] tags = newString[i].split(",");
				TaskImpl task = new TaskImpl(Status.valueOf(newString[i - 3]), newString[i - 2],
												Priority.valueOf(newString[i - 1].toUpperCase()), tags);
				tasks.add(task);
				temp = -1;
			}
				
		}
		
		return new TodoListImpl(tasks);
	}

	/**
	 * Checks if the TodoList is completed.
	 * @return
	 */
	Boolean isCompleted();

	/**
	 * Percentage of completed tasks.
	 * @return Double, with 2-digits precision.
	 */
	Double percentageCompleted();

	/**
	 * @return all tasks in the to-do list.
	 */
	List<Task> getTasks();

	/**
	 * Returns new to-do list, filtered by the provided criteria.
	 * @param criteria
	 * @return
	 */
	TodoList filter(Criteria criteria);

	/**
	 * Joins two instances of TodoList, removing the duplicating tasks.
	 * @param other
	 * @return
	 */
	TodoList join(TodoList other);
}
