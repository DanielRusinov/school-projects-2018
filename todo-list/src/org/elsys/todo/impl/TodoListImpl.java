package org.elsys.todo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.elsys.todo.*;

public class TodoListImpl implements TodoList {

		private List<Task> tasks = new ArrayList<>();
		
		public TodoListImpl(List<Task> tasks) {
			this.tasks = tasks;
		}
		
		@Override
		public Double percentageCompleted() {
			double temp = tasks.size();
			return  (tasks.stream()
					.filter(p1 -> p1.getStatus() == Status.DONE)
					.collect(Collectors.toList()).size() / temp * 100);
			
		}

		@Override
		public TodoList join(TodoList other) {
			List<Task> otherList = other.getTasks();
			
			List<Task> result = Stream.concat(tasks.stream(), otherList.stream())
	                .distinct()
	                .collect(Collectors.toList()); 
			
			return new TodoListImpl(result);
		}
		
		@Override
		public Boolean isCompleted() {
			return tasks.stream()
					.allMatch(p1 -> p1.getStatus() == Status.DONE);
		}
		
		@Override
		public List<Task> getTasks() {
			return tasks;
		}
		
		@Override
		public TodoList filter(Criteria criteria) {
			List<Task> result = tasks.stream()
					.filter(p1 -> criteria.compares(p1))
					.collect(Collectors.toList());
			
			return new TodoListImpl(result);
		}

}
