package org.elsys.todo.impl;

import org.elsys.todo.Criteria;
import org.elsys.todo.Status;
import org.elsys.todo.Task;

public class StatusCriteria implements Criteria {

	private Status status;
	
	public StatusCriteria(Status status) {
		super();
		this.status = status;
	}

	@Override
	public boolean compares(Task other) {
		return status.equals(other.getStatus());
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
		// TODO Auto-generated method stub
		return null;
	}

}
