package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Priority;
import org.elsys.todo.Task;

public class PriorityCriteria implements Criteria {

	private Priority priority;
	
	public PriorityCriteria(Priority priority) {
		super();
		this.priority = priority;
	}

	@Override
	public boolean compares(Task other) {
		return priority.equals(other.getPriority());
	}
	
	@Override
	public Criteria and(Criteria other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria or(Criteria other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria not() {
		return null;
	}

}
