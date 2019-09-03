package org.elsys.todo;

import org.elsys.todo.impl.PriorityCriteria;
import org.elsys.todo.impl.StatusCriteria;
import org.elsys.todo.impl.TagsCriteria;

/**
 * Interface used for filtering {@link TodoList}s.
 */
public interface Criteria {

	public static Criteria status(Status status) {
		return new StatusCriteria(status);
	}

	public static Criteria priority(Priority priority) {
		return new PriorityCriteria(priority);
	}

	public static Criteria tags(String[] tags) {

		return new TagsCriteria(tags);
	}
	
	public boolean compares(Task other);
	
	/**
	 * Creates new Criteria instance representing conjunction with the provided
	 * as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria and(Criteria other);

	/**
	 * Creates new Criteria instance representing disjunction with the provided
	 * as argument Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria or(Criteria other);

	/**
	 * Creates new Criteria instance representing negation of the Criteria.
	 * 
	 * @param other
	 * @return the new Criteria instance
	 */
	Criteria not();

}
