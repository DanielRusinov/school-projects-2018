package org.elsys.todo.impl;

import java.util.Arrays;

import org.elsys.todo.Criteria;
import org.elsys.todo.Task;

public class TagsCriteria implements Criteria {

	private String[] tags;
	
	public TagsCriteria(String[] tags) {
		super();
		this.tags = tags;
	}

	@Override
	public boolean compares(Task other) {
		return Arrays.asList(tags).containsAll((Arrays.asList(other.getTags())));
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
